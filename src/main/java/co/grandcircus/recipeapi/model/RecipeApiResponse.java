package co.grandcircus.recipeapi.model;

import java.util.List;

public class RecipeApiResponse {
	private String q;

	private int from;

	private int to;

	private boolean more;

	private int count;

	private List<Hits> hits;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public boolean isMore() {
		return more;
	}

	public void setMore(boolean more) {
		this.more = more;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Hits> getHits() {
		return hits;
	}

	public void setHits(List<Hits> hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "RecipeApiResponse [q=" + q + ", from=" + from + ", to=" + to + ", more=" + more + ", count=" + count
				+ ", hits=" + hits + "]";
	}
	
	

	
}
