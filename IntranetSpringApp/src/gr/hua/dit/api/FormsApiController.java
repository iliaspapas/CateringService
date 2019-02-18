package gr.hua.dit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Forms;
import gr.hua.dit.service.FormsService;

@RestController
@RequestMapping("/api/forms")
public class FormsApiController {

	@Autowired
	private FormsService formsService;
	
	@RequestMapping(value="/delete/{am}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteCustomer(@PathVariable("am") int am) {
		formsService.deleteForm(am);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{am}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Forms getform(@PathVariable("am") int am) {

		Forms form = formsService.getForm(am);
		System.out.println("form :" + form);

		return form;
	}
	
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Forms createForm(@RequestParam("am") int am,
			@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name,@RequestParam("income") int income, @RequestParam("fincome") int fincome, @RequestParam("bstudying") int bstudying,@RequestParam("scity") String scity,@RequestParam("city") String city) {
		
		Forms form = new Forms(am,first_name,last_name,income,fincome,bstudying,scity,city);
		
		formsService.saveForm(form);
		return form;

	}
}
