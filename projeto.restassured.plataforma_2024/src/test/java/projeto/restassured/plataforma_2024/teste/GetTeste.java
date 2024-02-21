package projeto.restassured.plataforma_2024.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import io.restassured.response.Response;
import projeto.restassured.plataforma_2024.UserAPI;

public class GetTeste {

	private UserAPI userAPI;

	@Before
	public void setUp() {

		userAPI = new UserAPI("https://reqres.in");

	}

	@Test
	public void testGetStatusCode() {

		Response response = userAPI.getUsers(2);
		assertEquals(200, response.getStatusCode());

	}

	@Test
	public void testGetBody() {

		Response response = userAPI.getUsers(2);

		int id = response.jsonPath().getInt("data[0].id");
		String email = response.jsonPath().getString("data[0].email");
		String first_name = response.jsonPath().getString("data[0].first_name");
		String last_name = response.jsonPath().getString("data[0].last_name");
		assertEquals(7, id);
		assertEquals("michael.lawson@reqres.in", email);
		assertEquals("Michael", first_name);
		assertEquals("Lawson", last_name);
	}

}
