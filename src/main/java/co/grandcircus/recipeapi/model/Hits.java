package co.grandcircus.recipeapi.model;

public class Hits {

	private Recipe recipe;
	private boolean bookmarked;
	private boolean bought;

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public boolean isBookmarked() {
		return bookmarked;
	}

	public void setBookmarked(boolean bookmarked) {
		this.bookmarked = bookmarked;
	}

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}

	@Override
	public String toString() {
		return "Hits [recipe=" + recipe + ", bookmarked=" + bookmarked + ", bought=" + bought + "]";
	}
	
	

}
