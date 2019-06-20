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
def firefoxBrowser

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

Given(~/^I am creating the firefox browser$/) {
    ->
        // Create chromeBrowser
        // chromeBrowser = new Browser(driver: new ChromeDriver()); break;

        // Create firefoxBrowser
        println "Creating the firefox browser..."
        def driver
        def file = new File( "blah" )//config.browsers.firefox.profile )
        if ( file.exists() ) {
            def profile = new FirefoxProfile( file )
            driver = new FirefoxDriver( profile )
        }
        else {
            driver = new FirefoxDriver()
        }
        firefoxBrowser = new Browser( driver: driver )
}

Given(~/^that I am starting at the video-vrails homepage using firefox$/) {
    ->
        println "Using firefox and pulling up video-vrails page"

        browser = firefoxBrowser
        println homePageUrl
        browser.setBaseUrl(https://omar-dev.ossim.io/omar-video-vrails/)
        browser.go(homePageUrl)
        def pageTitle = browser.getTitle()

        assert pageTitle == "Welcome to Grails & Vue"
}

Given(~/^I have clicked the menu button while the menu is NOT displayed$/) {
    ->
        def menu = browser.page.$("body").find("div").find { it.@class == "v-overlay v-overlay--active" }
        def dropdown_button = browser.page.$("body").find("i").find { it.@class == "v-icon fas fa-bars theme--dark" }
        sleep(1000)
        if (menu == null)
            dropdown_button.click()
}

Then(~/^The menu should be displayed$/) {
    ->
        assert browser.page.$("body").find("div").find { it.@class == "v-overlay v-overlay--active" } != null
}

