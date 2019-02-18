package gr.hua.dit.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Accepted;
import gr.hua.dit.service.AcceptedService;

@Controller
@RequestMapping("/accepted")
public class AcceptedController {

	@Autowired
	private AcceptedService acceptedService; 
	
	@GetMapping("/list")
	public String listAccepted(Model model) {
		List<Accepted> accepted = acceptedService.getAccepted();
		System.out.println("Accepted : " + accepted);
		// add the accepted to the model
		model.addAttribute("accepted",accepted);
		
		// add page title
		model.addAttribute("pageTitle", "List Accepted");
		return "list-accepted";
	}
	
	
	
}
