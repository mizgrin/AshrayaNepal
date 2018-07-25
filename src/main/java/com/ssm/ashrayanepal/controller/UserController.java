package com.ssm.ashrayanepal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssm.ashrayanepal.model.Role;
import com.ssm.ashrayanepal.model.User;
import com.ssm.ashrayanepal.repository.UserRepository;
import com.ssm.ashrayanepal.service.HostService;
import com.ssm.ashrayanepal.service.RoleService;
import com.ssm.ashrayanepal.service.UserService;
import com.ssm.ashrayanepal.service.UserValidator;

@RequestMapping(value = "/")
@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;
	@Autowired
	RoleService roleService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	HostService hostservice;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("home");
		//test
		return "home";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(ModelMap model) {

		Optional<User> a = userRepository.findById(28L);
		List<Role> roles = roleService.listRole();
		System.out.println(a);
		model.addAttribute("role", roles);
		System.out.println(roles.size());
		model.addAttribute("userForm", new User());
		return "Registration";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@Validated @ModelAttribute("userForm") User userForm, BindingResult bindingResult,
			ModelMap model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {

		/*
		 * if (bindingResult.hasErrors()){ return"redirect:/registration";
		 * 
		 * }else{
		 */
		System.out.println(request.getParameter("roles").toString());
		Optional<Role> role = roleService.getById(Long.parseLong(request.getParameter("roles").toString()));
		/* Set<Role> set = new Set<>() ; */

		System.out.println(role.isPresent());
		System.out.println("here");
		Set<Role> set = new HashSet<Role>();

		set.add(role.get());
		/*
		 * System.out.println(set.getId());
		 *//*
			 * User.setRoles(role,set());
			 */
		userForm.getRoles().add(role.get());

		System.out.println("added");
		System.out.println("inside add");
		userService.save(userForm);
		/*
		
		*/ return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			HttpSession session = request.getSession(true);

			if (session != null) {
				if (session.getAttribute("username") != null) {
					String name = (String) session.getAttribute("username");
					System.out.println("Hello, " + name + "  Welcome to ur Profile");
				} else {
					return "redirect:/login";
				}
			}

			model.addObject("error", "Invalid Username Or Password");

			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.setViewName("login");

		}
		return "login";

	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, String name) {

		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		User hosts = userService.findByUsername(user.getUsername()); // get
																		// logged
																		// in
																		// username

		model.addAttribute("hosts", hosts);
		System.out.println(user.getUsername());
		return "welcome";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("thanq you!!, Your session was destroyed successfully!!");
		HttpSession session = request.getSession(false);
		// session.setAttribute("user", null);
		session.removeAttribute("user");
		session.getMaxInactiveInterval();
	}

}
