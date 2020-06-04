package co.grandcircus.recipeapi.model;

import java.util.List;

public class RecipeApiResponse {

	private List<Recipe> recipe;

	public List<Recipe> getRecipe() {
		return recipe;
	}

	public void setRecipe(List<Recipe> recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "RecipeApiResponse [recipe=" + recipe + "]";
	}

}
