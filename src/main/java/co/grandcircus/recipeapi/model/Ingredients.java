 package co.grandcircus.recipeapi.model;


public class Ingredients {

	
	private String text;
	private Double weight;
	
	//@return GET text
	public String getText() {
		return text;
	}
	
	//@param SET text
	public void setText(String text) {
		this.text = text;
	}
	
	//@return GET weight
	public Double getWeight() {
		return weight;
	}
	
	//@param SET weight
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Ingredients [text=" + text + ", weight=" + weight + "]";
	}
	
	
	
	
}
