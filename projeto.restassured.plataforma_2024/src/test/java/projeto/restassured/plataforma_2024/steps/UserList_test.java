package projeto.restassured.plataforma_2024.steps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import projeto.restassured.plataforma_2024.UserAPI;

public class UserList_test {

	private UserAPI userAPI;
	Response response;

	@Given("que acesso a baseURL {string}")
	public void queAcessoABaseURL(String baseURL) {

		userAPI = new UserAPI(baseURL);

	}

	@When("envio uma request GET para {int}")
	public void envioUmaRequestGETPara(Integer page) {

		response = userAPI.getUsers(page);

	}

	@Then("valido o status code esperado {int}")
	public void validoOStatusCodeEsperado(Integer int1) {

		assertEquals(200, response.getStatusCode());
		System.out.println("O status code verificado foi: "+response.getStatusCode());

	}

	@Then("valido os atributos esperados {int} {int}, {string}, {string}, {string}")
	public void validoOsAtributosEsperados(Integer posicao, Integer id, String email, String firstName,String lastName) {

		Integer idVerificado = response.jsonPath().get("data[" + posicao + "].id");
		String emailVerificado = response.jsonPath().getString("data[" + posicao + "].email");
		String firstNameVerificado = response.jsonPath().getString("data[" + posicao + "].first_name");
		String lastNameVerificado = response.jsonPath().getString("data[" + posicao + "].last_name");

		assertEquals(idVerificado, id);
		assertEquals(emailVerificado, email);
		assertEquals(firstNameVerificado, firstName);
		assertEquals(lastNameVerificado, lastName);

		System.out.println("O id verificado foi: " + idVerificado);
		System.out.println("O email verificado foi: " + emailVerificado);
		System.out.println("O firstName verificado foi: " + firstNameVerificado);
		System.out.println("O lastName verificado foi: " + lastNameVerificado);

	}

}
