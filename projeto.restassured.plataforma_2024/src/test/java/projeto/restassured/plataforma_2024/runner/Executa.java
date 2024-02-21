package projeto.restassured.plataforma_2024.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/Features", 
		tags = "@atributosLT", 
		dryRun = false,
		glue = "projeto.restassured.plataforma_2024.steps",
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		plugin = {"pretty","html:target/cucumber-report.html"}

)

public class Executa {

}
