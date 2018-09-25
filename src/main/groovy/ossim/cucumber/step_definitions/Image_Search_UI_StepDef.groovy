package ossim.cucumber.step_definitions

import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import ossim.cucumber.config.CucumberConfig

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


def config = CucumberConfig.config
def homePageUrl = config.rbtcloudRootDir
remoteDisplay = null

Given(~/^I am starting the selenium server$/) {
    ->
        println "Starting remote display..."
        def command = ["Xvfb", ":1", "-screen", "0", "1366x768x24", "-ac"]
        remoteDisplay = command.execute()

        println "Starting browser..."
        def driver
        def file = new File( config.browsers.firefox.profile )
        if ( file.exists() ) {
            def profile = new FirefoxProfile( file )
            driver = new FirefoxDriver( profile )
        }
        else {
            driver = new FirefoxDriver()
        }
        browser = new Browser( driver: driver )
}

Given(~/^I am stopping the selenium server$/) {
    ->
        println "Stopping browser..."
        browser.quit()

        println "Stopping remote display..."
        remoteDisplay.waitForOrKill(1)
}

Given(~/^that I am starting at the O2 Home page$/) { ->
    browser.go(homePageUrl + "/omar-ui/omar")
    println "Page Title: ${browser.getTitle()}"
    assert browser.getTitle() == "O2"
}

Then(~/^the Search page is loaded$/) { ->
    // give time for the page to load
    sleep(2000)
    def canvas = browser.page.$("canvas")
    assert canvas.height > 0
    assert canvas.width > 0
}

When(~/^the Map button is clicked$/) { ->
    // click the main dropdown button first
    browser.page.$("a")[0].click()
    browser.page.$("a", 0, href: "#/map").click()
}



When(~/^enter Melbourne in the place name$/) { ->
//    println("enter text")
//    sleep(5000)
//    $("input#searchInput.form-control", id: "searchInput")<< "Melbourne, Fl, United States"
}

//$("span", 'ng-bind': "knoblabel").click

Then(~/^show map page centered on Melbourne$/) { ->
//    println("show map centered on Melbourne")
//    sleep(5000)
//    assert $("p", 0, class: "navbar-text").text()=="Filters"
}


Given(~/^on the Image Search Map page$/) { ->
//    browser.go "http://o2.ossim.org/"
//    println("start on map page")
//    sleep(5000)
//    $("a", text: "Map").click()
//    assert browser.title == "map"
}
When(~/^Search filter ImageID set to (.*)$/) { String imageID ->
//    println("Click keywords pulldown")
//    sleep(5000)
//    $("p", 2, class: "navbar-text").click()

}
And(~/^all filters all turned off$/) { ->
    // Write code here that turns the phrase above into concrete actions

}
