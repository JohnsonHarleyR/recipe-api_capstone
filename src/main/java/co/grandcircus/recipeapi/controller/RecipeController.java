package co.grandcircus.recipeapi.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.recipeapi.RecipeApiService;
import co.grandcircus.recipeapi.dao.UserDao;
import co.grandcircus.recipeapi.model.OneRecipe;
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

	// This tells the navigation bar and favorites page whether a
	// user is logged in.
	private boolean loggedIn = false;
	private String loginMessage = "Please enter your username and password.";
	private String signUpMessage = "Please enter the following information.";
	private String infoMessage = "Here is your user information.";
	private String editMessage = "Edit your user info here.";

	// Home page
	@RequestMapping("/")
	public String homePage(Model model) {

		// For the nav bar
		model.addAttribute("loggedin", loggedIn);

		return "index";
	}

//	 Next group of results
	@RequestMapping("/next")
	public String nextResults(Model model, @RequestParam(name = "fromNum") String fromNum,
			@RequestParam(name = "toNum") String toNum) {

		return "redirect:/search";
	}

//	 Previous group of results
	@RequestMapping("/previous")
	public String previousResults(Model model, @RequestParam(name = "fromNum") String fromNum,
			@RequestParam(name = "toNum") String toNum) {

		return "redirect:/search";
	}

	// Advanced search form
	@RequestMapping("/advanced")
	public String advancedSearchPage(Model model) {

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

		RecipeApiResponse response = service.advancedRecipeSearch(keyword, fromNum, toNum, diet, health, calories,
				excluded);

		model.addAttribute("searchResult", response);

		return "search";
	}

	// Search for recipes
	@RequestMapping("/search")
	public String searchResult(@RequestParam(name = "keyword") String keyword,
			@RequestParam(name = "fromNum") String fromNum, @RequestParam(name = "toNum") String toNum, Model model) {

		RecipeApiResponse response = service.recipeSearch(keyword, fromNum, toNum);

		model.addAttribute("searchResult", response);

		// For the nav bar
		model.addAttribute("loggedin", loggedIn);

		return "search";
	}

	// Individual recipe page
	@RequestMapping("/recipe")
	public String recipe(Model model, @RequestParam(name = "uri") String recipeUri) {

		OneRecipe recipe = service.getOneRecipe(recipeUri);
		model.addAttribute("recipe", recipe);

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

		model.addAttribute("loggedin", loggedIn);
		// If user is not logged in, redirect to login page
		if (loggedIn == false) {
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
		redir.addFlashAttribute("message", "You are now logged in, " + user.getName() + ".");

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

}
