package com.project.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.server.entity.ServerInfo;
import com.project.server.exception.ServerNotFound;
import com.project.server.service.ServerService;

@Controller
public class ServerController {

	@Autowired
	private ServerService service;

	// end point to get all the servers
	@GetMapping("/")
	public ModelAndView getAllServers() {
		List<ServerInfo> serverList = service.getAllServersDetails();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listOfServer", serverList);
		return mav;
	}

	// end point to get server by Id
	@GetMapping(value = "/Id/{id}")
	public String getById(@PathVariable Integer id, Model model) throws ServerNotFound {
		model.addAttribute("listOfServer", service.getServerDetailById(id));
		return "index";

	}

	// end point to add a new server
	@GetMapping("/server/new")
	public String createNewServer(Model model) {
		ServerInfo serverInfo = new ServerInfo();
		model.addAttribute("server", serverInfo);
		return "saveDetails";
	}

	// Post method to add new server details
	@PostMapping(value = "/saveServer")
	public String saveServerDetails(ServerInfo server) {
		service.addNewServer(server);
		return "redirect:/";
	}

	// end point to get a server by name
	@GetMapping(value = "/Name/{name}")
	public String getServerByName(@PathVariable String name, Model model)
			throws ServerNotFound {
		model.addAttribute("listOfServer", service.getServerDetailByName(name));
		return "index";
	}

	// end point to delete a server by Id
	@GetMapping("/delete/{id}")
	public String deleteServerById(@PathVariable Integer id) throws ServerNotFound {
		service.deleteById(id);
		return "redirect:/";
	}
}
