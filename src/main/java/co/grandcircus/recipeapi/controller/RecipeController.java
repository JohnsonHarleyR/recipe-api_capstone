package co.grandcircus.recipeapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.recipeapi.RecipeApiService;
import co.grandcircus.recipeapi.dao.FavoriteDao;
import co.grandcircus.recipeapi.dao.UserDao;
import co.grandcircus.recipeapi.model.Favorite;
import co.grandcircus.recipeapi.model.Hits;
import co.grandcircus.recipeapi.model.Recipe;
import co.grandcircus.recipeapi.model.RecipeApiResponse;
import co.grandcircus.recipeapi.model.User;

@Controller
public class RecipeController {

	@Autowired
	private RecipeApiService service;

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDao userRepo;
	@Autowired
	private FavoriteDao favoriteRepo;

	// This tells the navigation bar and favorites page whether a
	// user is logged in.
	private boolean loggedIn = false;
	private String loginMessage = "Please enter your username and password.";
	private String signUpMessage = "Please enter the following information.";
	private String infoMessage = "Here is your user information.";
	private String editMessage = "Edit your user info here.";
	
	private RecipeApiResponse response = new RecipeApiResponse();

	// Home page
	@RequestMapping("/")
	public String homePage(Model model) {
		
		String defaultFrom = "0";
		String defaultTo = "9";

		// Page variable
		session.setAttribute("page", 1);

		// For the nav bar
		model.addAttribute("loggedin", loggedIn);
		model.addAttribute("fromNum", defaultFrom);
		model.addAttribute("toNum", defaultTo);
		
		session.setAttribute("fromNum", defaultFrom);
		session.setAttribute("toNum", defaultTo);
		

		return "index";
	}
	
	//Favorites Page
	@RequestMapping("/favorite-list")
	public String favorite(Model model) {
		
		//Get current user
		User user = (User)session.getAttribute("user");
		
		List<Favorite> favorites = new ArrayList<>();
		int listSize = 0;
		
		if (!loggedIn) {
			return "login";
		} else {
			//Get list of their favorite recipes
			 favorites = favoriteRepo.findByUserId(user.getId());
			
			listSize = favorites.size();
			
			model.addAttribute("listsize", listSize);
			model.addAttribute("favorites", favorites);
			model.addAttribute("loggedin", loggedIn);
			return "favorite";
		}
		
		
	}
	
	//Add to user favorites
	@PostMapping("/favorite/add")
	public String addFavorite(
			@RequestParam(value = "name") String label,
			@RequestParam(value = "imageurl") String imageUrl,
			Model model) {
		
		boolean exists = false;
		
		//Get user
		User user = (User)session.getAttribute("user");
		
		//Get list of their favorite recipes
		List<Favorite> favorites = favoriteRepo.findByUserId(user.getId());
		
		/*
		//See if favorite already exists
		exists = doesFavoriteExist(favorites, label);
		*/
		
		//Create url string
		String url = "/recipe?recipe=" + label;
		
		//Loop through favorites to see if it exists already
		
		
		
		//Create new favorite - if it doesn't exist
		if (!exists) {
			Favorite favorite = new Favorite(label, url, imageUrl, user.getId());
			//Save to favorite
			favoriteRepo.save(favorite);
		}
		
		System.out.println(url);
		System.out.println(label);
		
		/*
		//Set button message
		model.addAttribute("button", "Saved");
		*/
		
		return "redirect:" + url;
	}

//	 Next group of results
	@RequestMapping("/next")
	public String nextResults(Model model) {

		// next page
		// somehow determine if you're on last page, then disallow next page


		String keyword = (String) session.getAttribute("keyword");
		String fromNum = (String) session.getAttribute("fromNum");
		String toNum = (String) session.getAttribute("toNum");
		
		Integer from = Integer.parseInt(fromNum);
		from +=10;
		Integer to = Integer.parseInt(toNum);
		to +=10;
		
		session.setAttribute("keyword", keyword);
		session.setAttribute("fromNum", from + "");
		session.setAttribute("toNum", to + "");

		response = service.recipeSearch(keyword, from  + "", to + "");
		
		session.setAttribute("response", response);

		model.addAttribute("searchResult", response);
		model.addAttribute("loggedin", loggedIn);

		return "search";
	}

//	 Previous group of results
	@RequestMapping("/previous")
	public String previousResults(Model model) {

//		// previous page
//		int page = (Integer) session.getAttribute("page");
//		if (page != 0) {
//			page -= 1;
//		}
//
//		session.setAttribute("page", page);
		
		String keyword = (String) session.getAttribute("keyword");
		String fromNum = (String) session.getAttribute("fromNum");
		String toNum = (String) session.getAttribute("toNum");
		
		Integer from = Integer.parseInt(fromNum);
		from -=10;
		Integer to = Integer.parseInt(toNum);
		to -=10;
		
		session.setAttribute("keyword", keyword);
		session.setAttribute("fromNum", from + "");
		session.setAttribute("toNum", to + "");

		response = service.recipeSearch(keyword, from  + "", to + "");
		
		session.setAttribute("response", response);

		model.addAttribute("searchResult", response);
		model.addAttribute("loggedin", loggedIn);

		return "search";
		
	}

	// Advanced search form
	@RequestMapping("/advanced")
	public String advancedSearchPage(Model model) {

		// Page variable
		session.setAttribute("page", 1);

		// For the nav bar
		model.addAttribute("loggedin", loggedIn);

		return "advanced";

	}

	// Advanced search results
	@RequestMapping("/advanced-search")
	public String advancedSearchResult(@RequestParam(name = "keyword") String keyword,
			@RequestParam(name = "fromNum") String fromNum, @RequestParam(name = "toNum") String toNum,
			@RequestParam(name = "diet", required = false) String diet,
			@RequestParam(name = "health", required = false) String health,
			@RequestParam(name = "min", required = false) String caloriesMin,
			@RequestParam(name = "max", required = false) String caloriesMax,
			@RequestParam(name = "excluded", required = false) String excluded, Model model) {

		System.out.println(keyword);
		System.out.println(toNum);
		System.out.println(fromNum);
		System.out.println(diet);
		System.out.println(health);
		System.out.println(caloriesMin);
		System.out.println(caloriesMax);
		System.out.println(excluded);

		String calories = null;

		if (caloriesMin != null && caloriesMax != null) {
			calories = caloriesMin + "-" + caloriesMax;
		} else {
			calories = "";
		}

		response = service.advancedRecipeSearch(keyword, fromNum, toNum, diet, health, calories,
				excluded);

		// Get page
		int page = (Integer) session.getAttribute("page");

		model.addAttribute("page", page); // page
		model.addAttribute("searchResult", response);
		model.addAttribute("loggedin", loggedIn);
		return "search";
	}

	// Search for recipes
	@RequestMapping("/search")
	public String searchResult(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "from", required = false) String fromNum,
			@RequestParam(name = "to", required = false) String toNum, Model model) {

		String key;
		String from;
		String to;
		
		if (keyword == null) {
			key = (String) session.getAttribute("keyword");
		} else {
			key = keyword;
		}
		
		if (fromNum == null) {
			from = (String) session.getAttribute("fromNum");
		} else {
			from = fromNum;
		}
		
		if (toNum == null) {
			to = (String) session.getAttribute("toNum");
		} else {
			to = toNum;
		}
		
		response = service.recipeSearch(key, from, to);

//		session.setAttribute("response", response);
//		session.setAttribute("keyword", key);
//		session.setAttribute("fromNum", from);
//		session.setAttribute("toNum", to);

		// Get page
		int page = (Integer) session.getAttribute("page");

		model.addAttribute("page", page);
		model.addAttribute("searchResult", response);
		model.addAttribute("min", from);
		model.addAttribute("max", to);
		model.addAttribute("keyword", key);
		
		session.setAttribute("response", response);
		session.setAttribute("keyword", key);
		session.setAttribute("fromNum", from);
		session.setAttribute("toNum", to);

		// For the nav bar
		model.addAttribute("loggedin", loggedIn);

		return "search";
	}

	// TODO NOT WORKING, Potential issue with double encoding...
	// Individual recipe page
	@RequestMapping("/recipe")
	public String recipe(Model model, @RequestParam(name = "recipe") String recipeLabel) {

		System.out.println(recipeLabel);
		
		//For seeing if recipe has been favorited already
		boolean exists = false;
		User user = (User)session.getAttribute("user");
		List<Favorite> favorites = favoriteRepo.findByUserId(user.getId());
		String buttonMessage;
		
		//Determine if favorite exists
		exists = doesFavoriteExist(favorites, recipeLabel);
		
		checkLogin();
		
		//Set favorite button message
		if (exists) {
			buttonMessage = "Saved";
		} else {
			buttonMessage = "Save Favorite!";
		}
		
		//RecipeApiResponse response = (RecipeApiResponse) session.getAttribute("response");
		
		List<Hits> hits = response.getHits();
		
		Recipe recipe = new Recipe();
		
		for (Hits hit : hits) {
			if (hit.getRecipe().getLabel().equals(recipeLabel)) {
				recipe = hit.getRecipe();
			}
		}
				
		model.addAttribute("recipe", recipe);
		model.addAttribute("button", buttonMessage);

		// For the nav bar
		model.addAttribute("loggedin", loggedIn);
		return "/recipe";
	}

	// HEADER
	// Putting the header control here so I can access these variables
	@RequestMapping("partials/header")
	public String header(
			// RedirectAttributes redirectAttributes,
			Model model) {
		User user = (User) session.getAttribute("user");
		// let's try this
		if (user != null) {
			model.addAttribute("user", user);
		}

		model.addAttribute("loggedin", loggedIn);
		// redirectAttributes.addFlashAttribute("user", user);
		// redirectAttributes.addFlashAttribute("user", user);
		// redirectAttributes.addFlashAttribute("loggedIn", loggedIn);
		return "header";
	}

	// USER PAGES

	// Favorites page
	@RequestMapping("/favorite")
	public String favorites(Model model) {

		// get user
		User user = (User) session.getAttribute("user");
		
		//Check if logged in
		checkLogin();
		

		model.addAttribute("loggedin", loggedIn);
		
		
		
		// If user is not logged in, redirect to login page
		if (!loggedIn) {
			model.addAttribute("loggedin", login);
			return "redirect:/login";
		} else {
			model.addAttribute("user", user);
			return "favorite";
		}

	}

	// Login page
	@RequestMapping("/login")
	public String login(Model model) {

		// tell nav bar whether user is logged in
		model.addAttribute("loggedin", loggedIn);
		model.addAttribute("message", loginMessage);

		return "login";
	}

	// Login submit
	@PostMapping("/login/submit")
	public String submit(@RequestParam("identity") String identity, @RequestParam String password, Model model,
			RedirectAttributes redir // not sure what this does? Pass to another method? useful
	) {

		User user;

		// see if user exists
		// find out if it's an email or username
		if (identity.contains("@")) {
			user = userRepo.findByEmail(identity);
		} else {
			user = userRepo.findByUsername(identity);
		}

		// 1. user is found
		// - or -
		// 2. password is incorrect

		if (user == null || !password.contentEquals(user.getPassword())) {
			loginMessage = "Your username, email, or password was incorrect.";
			model.addAttribute("message", loginMessage);
			loggedIn = false;
			return "redirect:/login";
		} else {
			loggedIn = true;
		}

		// add data to the session? not sure I understand this part fully yet
		session.setAttribute("user", user);

		// I don't think this is actually needed with the way I'm doing it
		// but it is a nifty thing
		//redir.addFlashAttribute("message", "You are now logged in, " + user.getName() + ".");

		return "redirect:/";
	}

	// Logout
	@RequestMapping("/logout")
	public String logout(RedirectAttributes redir) {

		loginMessage = "Please enter your username and password.";
		signUpMessage = "Please enter the following information.";
		infoMessage = "Here is your user information.";
		editMessage = "Edit your user info here.";

		// removes objects added to session

		session.invalidate();
		loggedIn = false;
		return "redirect:/login";
	}

	// Sign up page
	@RequestMapping("/sign-up")
	public String signUp(Model model) {

		// tell nav bar whether user is logged in
		model.addAttribute("loggedin", loggedIn);
		model.addAttribute("message", signUpMessage);

		return "sign-up";
	}

	// Login submit
	@PostMapping("sign-up/submit")
	public String signUpSubmit(@RequestParam(value = "username") String username,
			@RequestParam(value = "email") String email, @RequestParam(value = "password1") String password1,
			@RequestParam(value = "password2") String password2, @RequestParam(value = "name") String name,
			Model model) {

		List<User> users = userRepo.findAll();

		for (User u : users) {
			if (u.getUsername().equals(username)) {
				signUpMessage = "Username already exists. Please choose another.";
				model.addAttribute("loggedin", loggedIn);
				model.addAttribute("message", signUpMessage);
				return "redirect:/sign-up";
			}
			if (u.getEmail().equals(email)) {
				signUpMessage = "Email already exists. Please choose another.";
				model.addAttribute("loggedin", loggedIn);
				model.addAttribute("message", signUpMessage);
				return "redirect:/sign-up";
			}

		}

		if (!password1.equals(password2)) {
			signUpMessage = "Passwords did not match. Please try again.";
			model.addAttribute("loggedin", loggedIn);
			model.addAttribute("message", signUpMessage);
			return "redirect:/sign-up";
		} else {
			// make it so the email has to match a regex too
			User user = new User(username, email, password1, name);
			userRepo.save(user);
			session.setAttribute("user", user);
			loggedIn = true;
			infoMessage = "Sign up was successful!";
			return "redirect:/user-info";

		}
	}

	// Add user page
	@RequestMapping("/add")
	public String addTask(

			Model model) {

		User user = (User) session.getAttribute("user");
		

		model.addAttribute("user", user);
		model.addAttribute("loggedin", loggedIn);

		if (loggedIn == true) {
			return "add";
		} else {
			return "redirect:/login";
		}

	}

	// User info page
	@RequestMapping("/user-info")
	public String userSettings(Model model) {

		User user = (User) session.getAttribute("user");
		String hiddenPass = "";

		// redirect to login if not logged in
		if (user == null) {
			return "redirect:/login";
		}

		for (int i = 0; i < user.getPassword().length(); i++) {
			hiddenPass += "*";
		}

		model.addAttribute("user", user);
		model.addAttribute("loggedin", loggedIn);
		model.addAttribute("password", hiddenPass);
		model.addAttribute("message", infoMessage);

		return "user-info";
	}

	// Edit user page
	@RequestMapping("/user/edit")
	public String editUser(Model model) {

		User user = (User) session.getAttribute("user");

		// redirect to login if not logged in
		if (user == null) {
			return "redirect:/login";
		}

		model.addAttribute("user", user);
		model.addAttribute("loggedin", loggedIn);
		model.addAttribute("message", editMessage);

		return "edit-user";
	}

	// Submit changes to user
	@PostMapping("/user/edit/submit")
	public String edit(@RequestParam(value = "userid") Long userId, @RequestParam(value = "username") String username,
			@RequestParam(value = "email") String email, @RequestParam(value = "password1") String password1,
			@RequestParam(value = "password2") String password2, @RequestParam(value = "name") String name,
			Model model) {

		List<User> users = userRepo.findAll();
		User us = (User) session.getAttribute("user");
		User user = userRepo.findByUsername(us.getUsername()); // unnecessary steps - fix

		for (User u : users) {
			if (u.getUsername().equals(username) && u.getId() != user.getId()) {
				editMessage = "New username is unavailable. Please choose another.";
				model.addAttribute("user", user);
				model.addAttribute("loggedin", loggedIn);
				model.addAttribute("message", infoMessage);
				return "redirect:/user/edit";
			}
		}

		if (!password1.equals(password2)) {
			editMessage = "Passwords did not match. Please try again.";
			model.addAttribute("user", user);
			model.addAttribute("loggedin", loggedIn);
			model.addAttribute("message", editMessage);
			return "redirect:/user/edit";
		} else {
			// make it so the email has to match a regex too
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password1);
			user.setName(name);
			userRepo.save(user);
			session.setAttribute("user", user);
			loggedIn = true;
			infoMessage = "Information was successfully edited.";
			return "redirect:/user-info";

		}
		
		
	}
	
	
	
	//Extra methods

	//Find if favorite exists
	public boolean doesFavoriteExist(List<Favorite> favorites, String label) {
		boolean exists = false;
		
		for (Favorite favorite: favorites) {
			if (favorite.getLabel().equals(label)) {
				exists = true;
			}
		}
		
		return exists;
	}
	
	public void checkLogin() {
		User user = (User)session.getAttribute("user");
		
		if (user == null) {
			loggedIn = false;
		} else {
			loggedIn = true;
		}
		
	}
	

}
