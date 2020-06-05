package co.grandcircus.recipeapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.recipeapi.model.OneRecipe;
import co.grandcircus.recipeapi.model.Recipe;
import co.grandcircus.recipeapi.model.RecipeApiResponse;

@Service
public class RecipeApiService {

	private RestTemplate rest = new RestTemplate();

	@Value("${app.id}")
	private String appId;

	@Value("${app.key}")
	private String appKey;

	public RecipeApiResponse recipeSearch(String searchTerms, String fromNum, String toNum) {

		String url = "https://api.edamam.com/search?q=" + searchTerms + "&app_id=" + appId + "&app_key=" + appKey
				+ "&from=" + fromNum + "&to=" + toNum;

		return rest.getForObject(url, RecipeApiResponse.class);

	}

	public OneRecipe getOneRecipe(String recipeUri) {

		String url = "https://api.edamam.com/search?app_id=" + appId + "&app_key=" + appKey + "&r=" + recipeUri;

		OneRecipe recipe = rest.getForObject(url, OneRecipe.class);

		return recipe;

	}

	public RecipeApiResponse advancedRecipeSearch(
			String searchTerms, 
			String fromNum, 
			String toNum, 
			String diet, 
			String health,
			String calories, // must be sent as a string describing a range like "300-800"
			String excluded) {

		if (searchTerms != null && !searchTerms.equals("")) {
			searchTerms = "&q=" + searchTerms;
		} else {
			searchTerms = "";
		}

		if (fromNum != null && !fromNum.equals("")) {
			fromNum = "&from=" + fromNum;
		} else {
			fromNum = "";
		}

		if (toNum != null && !toNum.equals("")) {
			toNum = "&to=" + toNum;
		} else {
			toNum = "";
		}

		if (diet != null && !diet.equals("")) {
			diet = "&diet=" + diet;
		} else {
			diet = "";
		}

		if (health != null && !health.equals("")) {
			health = "&health=" + health;
		} else {
			health = "";
		}

		if (calories != null && !calories.equals("")) {
			calories = "&calories=" + calories;
		} else {
			calories = "";
		}

		if (excluded != null && !excluded.equals("")) {
			excluded = "&excluded=" + excluded;
		} else {
			excluded = "";
		}

		String url = "https://api.edamam.com/search?app_id=" + appId + "&app_key=" + appKey + searchTerms + fromNum
				+ toNum + diet + health + calories + excluded;
		
		System.out.println(url);

		return rest.getForObject(url, RecipeApiResponse.class);
		
	}

	// Method for advanced searching

	// Method to filter search results

}
