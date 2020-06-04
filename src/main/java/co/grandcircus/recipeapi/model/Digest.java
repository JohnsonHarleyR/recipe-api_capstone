package co.grandcircus.recipeapi.model;

public class Digest {
	
	private String label;
	private String tag;
	private String schemaOrgTag;
	private Double total;
	private boolean hasRDI;
	private double daily;
	private String unit;
	private Sub sub;
	
	//@return GET label
	public String getLabel() {
		return label;
	}
	
	//@param SET label
	public void setLabel(String label) {
		this.label = label;
	}
	
	//@return GET tag
	public String getTag() {
		return tag;
	}
	
	//@param SET tag
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	//@return GET schemaOrgTag
	public String getSchemaOrgTag() {
		return schemaOrgTag;
	}
	
	//@param SET schemaOrgTag
	public void setSchemaOrgTag(String schemaOrgTag) {
		this.schemaOrgTag = schemaOrgTag;
	}
	
	//@return GET total
	public Double getTotal() {
		return total;
	}
	
	//@param SET total
	public void setTotal(Double total) {
		this.total = total;
	}
	
	//@return GET hasRDI
	public boolean isHasRDI() {
		return hasRDI;
	}
	
	//@param SET hasRDI
	public void setHasRDI(boolean hasRDI) {
		this.hasRDI = hasRDI;
	}
	
	//@return GET daily
	public double getDaily() {
		return daily;
	}
	
	//@param SET daily
	public void setDaily(double daily) {
		this.daily = daily;
	}
	
	//@return GET unit
	public String getUnit() {
		return unit;
	}
	
	//@param SET unit
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	//@return GET sub
	public Sub getSub() {
		return sub;
	}
	
	//@param SET sub
	public void setSub(Sub sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "Digest [label=" + label + ", tag=" + tag + ", schemaOrgTag=" + schemaOrgTag + ", total=" + total
				+ ", hasRDI=" + hasRDI + ", daily=" + daily + ", unit=" + unit + "]";
	}
	
	

}
