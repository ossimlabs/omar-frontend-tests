package ossim.cucumber.step_definitions

import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver
import ossim.cucumber.config.CucumberConfig

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def config = CucumberConfig.config
def pkiHomePageUrl = config.pkiUrl
remoteDisplay = null
browser = null

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


Given(~/^that I try to enter the O2 pki home page without a pki$/) { ->
    println("Going to pki home page: $pkiHomePageUrl...")
    browser.go(pkiHomePageUrl)
}

Then(~/^it does not let me into O2$/) { ->
    println("Verifying failure to access O2 without a pki...")
    assert browser.title != "O2"
    assert browser.$("h1").text() == "Secure Connection Failed"
}

