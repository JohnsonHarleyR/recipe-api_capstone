package co.grandcircus.recipeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.recipeapi.RecipeApiService;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeApiService service;
	
	@RequestMapping("/")
	public String homePage() {
		
		return "index";
	}

}
