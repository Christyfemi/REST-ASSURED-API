package getting_started;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.Test;

public class Getting_Started {

	@Test
	public void simple_get_request() {

		given()

				.when()

				.get("https://restcountries.eu/rest/v2")

				.then()

				.statusCode(200);

	}

	@Test
	public void validate_json() {
		given().when().get("https://restcountries.eu/rest/v2/alpha/USA").then().statusCode(200).body("name",
				equalTo("United States of America"),

				"alpha2Code", equalTo("US"), "altSpellings", hasItem("US"), "currencies[0].symbol", equalTo("$"),
				"languages[0].iso639_1", equalTo("en")

		);

	}
}
