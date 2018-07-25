package com.ssm.ashrayanepal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.ashrayanepal.model.HostDetails;
import com.ssm.ashrayanepal.service.HostService;


@Controller

public class GuestController {
@Autowired
HostService hostservice;


	@RequestMapping(value="/roomdetail" , method=RequestMethod.GET)
	public String saveForm(ModelMap model) {
		List<HostDetails> hostlist = (List<HostDetails>) hostservice.listhost();


		model.addAttribute("hostlists" , hostlist);
		
		return "hostlist";
	

}
}
