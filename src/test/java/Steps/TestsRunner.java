package Steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Selenium Behavior Driven-Development Example
//Author: Lucas Magnani Vikar Theodoro
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
                    glue={"Steps"},
                    plugin = {"pretty", "html:target/Reports/HtmlLastReport.html",
                                "json:target/Reports/JsonLastReport.json"})
public class TestsRunner { }
