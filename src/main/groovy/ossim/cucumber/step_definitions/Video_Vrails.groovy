package ossim.cucumber.step_definitions

import geb.Browser
import groovy.json.JsonOutput
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.Keys
import ossim.cucumber.config.CucumberConfig


this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


def config = CucumberConfig.config
def homePageUrl = config.ovvUrl // ovv is the omar-video-vrails url suffix

def chromeBrowser

buildNumber = System.getenv("BUILD_NUMBER")
videoPrefix = buildNumber != null ? "${buildNumber}_" : ""

Given(~/^I am starting the video vrails selenium server$/) {
    ->
        println "Starting remote display..."
        def command = ["Xvfb", ":1", "-screen", "0", "1366x768x24", "-ac"]
        remoteDisplay = command.execute()
        sleep(3000)
        println "Starting VNC server..."
        try {
            command = ["x11vnc", "-display", ":1", "-localhost", "-shared", "-forever"]
            command.execute()
            sleep(3000)
        } catch (IOException e) {
            println('Starting VNC server failed...')
        }
        println "Starting video recording..."
        try {
            command = ["flvrec.py", "-o", "${videoPrefix}high_quality_video.flv", "localhost", "5900"]
            command.execute()
            sleep(3000)
        } catch (IOException e) {
            println('Starting video recording failed...')
        }
}

Given(~/^I am creating the chrome browser$/) {
    ->
        println "Creating the chrome browser..."
        def driver
        chromeBrowser = new Browser(driver: new ChromeDriver())
        println "Created the browser"
}

Given(~/^that I am starting at the video-vrails homepage using chrome$/) {
    ->
        println "Trying to pull up video-vrails page..."
        chromeBrowser.go(homePageUrl)
        def pageTitle = chromeBrowser.getTitle()

        assert pageTitle == "Welcome to Grails & Vue"
}

Given(~/^I have clicked the menu button while the menu is NOT displayed$/) {
    ->
        def menu = chromeBrowser.page.$("body").find("div").find { it.@class == "v-overlay v-overlay--active" }
        def dropdown_button = chromeBrowser.page.$("body").find("i").find { it.@class == "v-icon fas fa-bars theme--dark" }
        sleep(1000)
        if (menu == null)
            dropdown_button.click()
}

Then(~/^The menu should be displayed$/) {
    ->
        assert chromeBrowser.page.$("body").find("div").find { it.@class == "v-overlay v-overlay--active" } != null
}

