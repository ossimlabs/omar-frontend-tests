package ossim.cucumber.step_definitions

import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver
import ossim.cucumber.config.CucumberConfig

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def config = CucumberConfig.config
def pkiHomePageUrl = config.pkiUrl
remoteDisplay = null

Given(~/^I am starting the selenium server$/) { ->
    println "Starting selenium server..."
    def command = ["Xvfb", ":1", "-screen", "0", "1366x768x24", "-ac"]
    remoteDisplay = command.execute()
    sleep(3000)
}

Given(~/^I am starting the browser$/) { ->
    println "Starting browser..."
    browser = new Browser(driver: new FirefoxDriver())
    sleep(3000)
}

Given(~/^I am stopping the browser$/) { ->
    println "Stopping browser..."
    browser.quit()
    sleep(3000)
}

Given(~/^I am stopping the selenium server$/) { ->
    println "Stopping selenium server..."
    remoteDisplay.waitForOrKill(1)
    sleep(3000)
}


Given(~/^that I try to enter the omar pki home page using Firefox$/) { ->
    println("Going to pki home page $pkiHomePageUrl")
    browser.go(pkiHomePageUrl)
    println "Page Title: ${browser.getTitle()}"
}

When(~/^I attempt to log in without a pki$/) { ->

}

Then(~/^it does not let me into the omar$/) { ->

}

