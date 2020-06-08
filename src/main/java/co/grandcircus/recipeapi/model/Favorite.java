package co.grandcircus.recipeapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private String url;
	@Column(name ="image_url")
	private String imageUrl;
	@Column(name = "user_id")
	private Long userId;
	
	
	public Favorite() {	}
	
	public Favorite(String label, String url, String imgUrl, Long userId) {
		this.label = label;
		this.url = url;
		this.imageUrl = imgUrl;
		this.userId = userId;
	}
	
	//@return GET id
	public Long getId() {
		return id;
	}
	
	//@param SET id
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	//@return GET label
	public String getLabel() {
		return label;
	}

	
	//@param SET label
	public void setLabel(String label) {
		this.label = label;
	}

	
	//@return GET url
	public String getUrl() {
		return url;
	}

	
	//@param SET url
	public void setUrl(String url) {
		this.url = url;
	}

	
	//@return GET image_url
	public String getImage_url() {
		return imageUrl;
	}

	
	//@param SET image_url
	public void setImage_url(String image_url) {
		this.imageUrl = image_url;
	}

	

	
	//@return GET user_id
	public Long getUserId() {
		return userId;
	}

	
	//@param SET user_id
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", label=" + label + ", url=" + url + ", imageUrl=" + imageUrl + ", userId="
				+ userId + "]";
	}
	
	
	
	
	
	
}
