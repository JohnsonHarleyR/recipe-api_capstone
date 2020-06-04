package co.grandcircus.recipeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.recipeapi.RecipeApiService;
import co.grandcircus.recipeapi.model.RecipeApiResponse;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeApiService service;
	
	@RequestMapping("/recipe")
	public String homePage() {
		
		
		
		
		return "index";
	}
	
	@RequestMapping("/search")
	public String searchResult(@RequestParam(name="keyword") String keyword,
			Model model) {
		
		RecipeApiResponse response = service.recipeSearch(keyword);
		
		model.addAttribute("searchResult", response);
		
		return "search";
	}

}
