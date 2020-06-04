package co.grandcircus.recipeapi.model;

import java.util.List;

public class Recipe {

	private String uri;
	private String label;
	private String image;
	private String source;
	private String url;
	private String shareAs;
	private Double yield;
	private List<String> dietLabels;
	private List<String> cautions;
	private List<String> ingredientLines;
	private List<Ingredients> ingredients;
	private Double calories;
	private Double totalWeight;
	private Double totalTime;
	private List<Digest> digest;
	private Boolean bookmarked;
	private Boolean bought;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShareAs() {
		return shareAs;
	}

	public void setShareAs(String shareAs) {
		this.shareAs = shareAs;
	}

	public Double getYield() {
		return yield;
	}

	public void setYield(Double yield) {
		this.yield = yield;
	}

	public List<String> getDietLabels() {
		return dietLabels;
	}

	public void setDietLabels(List<String> dietLabels) {
		this.dietLabels = dietLabels;
	}

	public List<String> getCautions() {
		return cautions;
	}

	public void setCautions(List<String> cautions) {
		this.cautions = cautions;
	}

	public List<String> getIngredientLines() {
		return ingredientLines;
	}

	public void setIngredientLines(List<String> ingredientLines) {
		this.ingredientLines = ingredientLines;
	}

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	public Double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Double getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Double totalTime) {
		this.totalTime = totalTime;
	}

	public List<Digest> getDigest() {
		return digest;
	}

	public void setDigest(List<Digest> digest) {
		this.digest = digest;
	}

	public Boolean getBookmarked() {
		return bookmarked;
	}

	public void setBookmarked(Boolean bookmarked) {
		this.bookmarked = bookmarked;
	}

	public Boolean getBought() {
		return bought;
	}

	public void setBought(Boolean bought) {
		this.bought = bought;
	}

	@Override
	public String toString() {
		return "Recipe [uri=" + uri + ", label=" + label + ", image=" + image + ", source=" + source + ", url=" + url
				+ ", shareAs=" + shareAs + ", yield=" + yield + ", dietLabels=" + dietLabels + ", cautions=" + cautions
				+ ", ingredientLines=" + ingredientLines + ", ingredients=" + ingredients + ", calories=" + calories
				+ ", totalWeight=" + totalWeight + ", totalTime=" + totalTime + ", digest=" + digest + ", bookmarked="
				+ bookmarked + ", bought=" + bought + "]";
	}

}
