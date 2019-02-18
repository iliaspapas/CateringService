package gr.hua.dit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Accepted;
import gr.hua.dit.service.AcceptedService;

@RestController
@RequestMapping("/api/accepted")
public class AcceptedApiController {
	
	@Autowired
	private AcceptedService acceptedService;

	@RequestMapping(value = "/{am}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Accepted getaccepted(@PathVariable("am") int am) {

		Accepted accepted = acceptedService.getAccepted(am);
		System.out.println("accepted :" + accepted);

		return accepted;
	}
	
	
	@RequestMapping(value="/delete/{am}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteAccepted(@PathVariable("am") int am) {
		acceptedService.deleteAccepted(am);
		return new ResponseEntity(HttpStatus.OK);
	}
}
