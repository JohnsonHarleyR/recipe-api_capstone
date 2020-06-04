package co.grandcircus.recipeapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.recipeapi.model.Recipe;
import co.grandcircus.recipeapi.model.RecipeApiResponse;

@Service
public class RecipeApiService {
	
	private RestTemplate rest = new RestTemplate();
	
	@Value("${ app.id }")
	String appId; 
	
	@Value("${ app.key }")
	String appKey;
	
	public RecipeApiResponse recipeSearch(String searchTerms) {
		
		String url = "https://api.edamam.com/search?q=" + searchTerms + "&app_id=" + appId + "&app_key=" + appKey;
		
		RecipeApiResponse searchResult = rest.getForObject(url, RecipeApiResponse.class);
		
		return searchResult;
		
	}

}
