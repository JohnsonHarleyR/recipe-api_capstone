package co.grandcircus.recipeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.recipeapi.model.User;


public interface UserDao extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	User findByEmail(String email);

}
