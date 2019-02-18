package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Accepted;
import gr.hua.dit.entity.Forms;
import gr.hua.dit.service.AcceptedService;
import gr.hua.dit.service.FormsService;

@Controller
@RequestMapping("/forms")
public class FormsController {

	
	@Autowired
	private FormsService formsService;
	
	@Autowired
	private AcceptedService acceptedService;
	
	@GetMapping("/list")
	public String listForms(Model model) {
		
		// get forms from the service
		List<Forms> forms = formsService.getForms();
		System.out.println("Forms : " + forms);
		// add the forms to the model
		model.addAttribute("forms",forms);
		
		// add page title
		model.addAttribute("pageTitle", "List Forms");
		return "list-forms";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Forms forms = new Forms();
		model.addAttribute("forms", forms);
		
		// add page title
		model.addAttribute("pageTitle", "Add Form");
		return "new-form";
	}
	
	@PostMapping("/saveForm")
	public String saveForm(@ModelAttribute("forms") Forms forms) {
		// save the form using the service
		formsService.saveForm(forms);
		
		return "redirect:/forms/list";
	}
	
	@GetMapping("/accept/{am}")
	public String saveCustomer(@PathVariable("am") int am) {
		int score=0;
		Forms f = formsService.getForm(am);
		if(f.getIncome() == 0 && f.getFincome() == 0) {
			score = 999;
		}else{
			if(f.getFincome() < 10000) {
				score = score + 100;
			}else if(f.getFincome() < 15000) {
				score = score +50;
			}
			
			if(f.getBstudying() != 0) {
				score = score + f.getBstudying()*20;
			}
			
			if(!f.getScity().equalsIgnoreCase(f.getCity())) {
				score = score + 50;
			}
		}
		
		
		Accepted accepted = new Accepted(am,score);
		acceptedService.saveAccepted(accepted);
		formsService.deleteForm(am);
		
		
		return "redirect:/accepted/list";
	}
	
	
	@GetMapping("/{Am}")
	public String getCustomer(Model model, @PathVariable("Am") int am) {
		// get the form
		Forms form = formsService.getForm(am);
		
		model.addAttribute("forms", form);
		
		return "new-form";
	}
}
