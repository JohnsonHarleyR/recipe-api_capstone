package co.grandcircus.recipeapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.recipeapi.model.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Long> {
	
	List<Favorite> findByUserId (Long id);
	
	
}
