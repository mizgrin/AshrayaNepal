package com.ssm.ashrayanepal.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.ashrayanepal.model.HostDetails;
import com.ssm.ashrayanepal.model.Rooms;
import com.ssm.ashrayanepal.model.User;
import com.ssm.ashrayanepal.repository.HostRepository;
import com.ssm.ashrayanepal.service.HostService;
import com.ssm.ashrayanepal.service.UserService;

@Controller

public class HostController {

	private final static Logger log = LoggerFactory.getLogger(HostController.class);

	@Autowired
	HostRepository repository;
	@Autowired
	HostService hostService;
	/*
	 * @Autowired HttpServlet request;
	 */
	@Autowired
	UserService userService;

	@RequestMapping(value = "/hostdetail", method = RequestMethod.GET)
	public String hostDetail(HttpServletRequest request, @ModelAttribute("hostDetail") HostDetails hostDetail,
			HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		model.addAttribute("hostDetail", new HostDetails());

		String uploadsDir = request.getRealPath("/webapp/resources/upload");
		System.out.println(uploadsDir);

		return "hostDetail";
	}

	@RequestMapping(value = "/hostdetail", method = RequestMethod.POST)

	public String hostDetail(@RequestParam("photo") MultipartFile photo, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here");
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		System.out.println(user.getUsername());

		HostDetails hosts = new HostDetails();
		/*
		 * System.out.println(user.getUsername());
		 */
		String hostname = request.getParameter("hostName");
		String hostaddress = request.getParameter("address");
		String hostfamily = request.getParameter("familyType");
		Long room = Long.parseLong(request.getParameter("availableRoom"));

		String username = user.getUsername();

		User u = userService.findByUsername(username);

		hosts.setHostName(hostname);
		hosts.setAddress(hostaddress);
		hosts.setFamilyType(hostfamily);
		hosts.setAvailableRoom(room);
		hosts.setUser(u);

		try {
			String uploadsDir1 = request.getRealPath("/");
			String uploadsDir = request.getRealPath("/resources/upload");
			File filePath = new File(uploadsDir);
			System.out.println(uploadsDir);

			System.out.println(uploadsDir1);
			if (!filePath.exists())
				;

			{
				boolean result = false;
				try {
					filePath.mkdir();
					result = true;

				} catch (SecurityException s) {
					System.out.println("not created");
				}
				System.out.println(result);
				if (result) {
					System.out.println("dir created");
				}
			}
			log.info("realPathtoUploads={}", uploadsDir);
			String orgName = photo.getOriginalFilename();
			String filePath1 = uploadsDir + "/" + orgName;

			File dest = new File(filePath1);
			photo.transferTo(dest);
			hosts.setPhoto(orgName);
			hostService.save(hosts);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("h2ere");
		model.addAttribute("host", hosts);

		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileview(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		org.springframework.security.core.userdetails.User temp = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		User user = userService.findByUsername(temp.getUsername());

		System.out.println(user.getUserId());

		Optional<HostDetails> host2 = hostService.getByuser(user);

		System.out.println("here");

		boolean h = host2.isPresent();
		System.out.println(h);

		if (h == true) {
			System.out.println(host2.get().getHostName());

			model.addAttribute("host", host2.get());
			return "/profile";

		}
		if (h == false) {
			return "redirect:/hostdetail";
		} else {
			return "welcome";
		}

	}

	@RequestMapping(value = "/updatehostdetail/{username}", method = RequestMethod.GET)
	public String updatehost(@PathVariable("username") String username, Model model) {

		Optional<HostDetails> host = hostService.findByname(username);
		model.addAttribute("hosts", host.get());
		System.out.println(username);
		return "redirect:/hostdetail";
	}

	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public String addrooms(HttpServletRequest request, @ModelAttribute("rooms") Rooms room,
			HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		model.addAttribute("rooms", room);

		String uploadsDir = request.getRealPath("/webapp/resources/upload");

		return "addrooms";
	}

	@RequestMapping(value = "/rooms", method = RequestMethod.POST)
	public String createRequest(final HttpServletRequest request, final HttpServletResponse response,
			final @ModelAttribute("spRequestDTO") Rooms rooms, final BindingResult beException,
			final @RequestParam("buttonName") String buttonName, @RequestParam CommonsMultipartFile[] fileUpload,
			String saveDirectory) throws IOException {

		// logic

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				if (!aFile.getOriginalFilename().equals("")) {
					try {
						aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
					} catch (IllegalStateException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		}
		return "roomdisplay";
	}
}
