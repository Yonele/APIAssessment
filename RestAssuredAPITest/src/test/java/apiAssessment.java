import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class apiAssessment {

	final String baseUri = "https://dog.ceo/api";

	// retrieve all dog breeds
	@Test
	public void shouldReturnAllBreeds(){
		when()
		.get(baseUri + "/breeds/list/all")
		.then()
		.body("message", is(not(empty())))
		.body("message", hasKey("ridgeback"));
	}
	
	//verify retriever breed is within the list
	@Test
	public void shouldContainRetriever(){    	
		when()
		.get(baseUri + "/breeds/list/all")
		.then()
		.body("message", hasKey("retriever"));
	}

	//produce a list of sub-breeds for retriever
	@Test
	public void shouldReturnOnlyListOfSpecifiedBreed(){
		when()
		.get(baseUri + "/breed/retriever/list")
		.then()
		.body("message", hasSize(4))
		.and()
		.body("message", hasItem("curly"));
	}
	
	//produce a random image / link for the sub-breed golden
	@Test
	public void mustReturnRandomBreedImage(){

		ValidatableResponse firstResponse = when()
				.get(baseUri + "/breeds/image/random")
				.then();

		Response secondResponse = when()
				.get(baseUri + "/breeds/image/random")
				.thenReturn();

		firstResponse.body("message", is(not(secondResponse.body().jsonPath().get("message"))));

	}
}
