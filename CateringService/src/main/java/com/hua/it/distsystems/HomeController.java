package com.hua.it.distsystems;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.security.MessageDigest;


import com.hua.it.distsystems.model.DirectoryServiceUser;
import com.hua.it.distsystems.model.UserCredentials;
import com.hua.it.distsystems.security.Password;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;



/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("session")
public class HomeController {
	
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	//private UserCredentialsDAO usercheck;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("UserCredentials") @Valid UserCredentials credentials, BindingResult result,Model model,HttpServletRequest request) {
	  //  String greetings = "Greetings, Spring MVC!";
	     /*	 if (result.hasErrors()) {
	            return "loginerror";
	        } */
		System.out.println("Usename from form:"+credentials.getUsername());
		System.out.println("Password from form:"+credentials.getPassword());
	    request.getSession().setAttribute("username",credentials.getUsername());
		UserCredentials temp;
		Password pass;
		String requestServiceURL="http://localhost:9763/CRUDservices_1.0.0/services/dbms_access/directory/getUserPassword/"+credentials.getUsername();
		RestTemplate restTemplate = new RestTemplate();
		String RestResponse=restTemplate.getForObject(requestServiceURL,String.class);
      //  Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		System.out.println("Service Response was:"+RestResponse);
		
/*		JdbcUserCredentialsDAO userData = 
			      (JdbcUserCredentialsDAO)context.getBean("JdbcUserCredentialsDAO");
		
		JdbcDisBookUserDAO DisBookuserData = 
			      (JdbcDisBookUserDAO)context.getBean("JdbcDisBookUserDAO");
	   
	    temp=userData.findUserByName(credentials.getUsername());
	 /*  String encryptedPassword=null;
	   //Create hash value from user provided Password
	   try {
	       //  MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
	       //  messageDigest.update(credentials.getPassword().getBytes());
	      //   encryptedPassword = new String(messageDigest.digest());
	      //   System.out.println("Now encrypted"+encryptedPassword);
	      //   System.out.println("From database:"+temp.getPassword());
	   } catch (Exception ex) {
		   System.out.println(ex.toString());
	   } */
		
	   if (!RestResponse.contains("not found")) {
		   
		   temp=new UserCredentials(credentials.getUsername(),RestResponse.trim());
		   
		   System.out.println("Submitted plaintext Password is:"+credentials.getPassword());
		   
	       Password test=new Password();
		   
		 //  String hashedGivenPassword=test.hashPassword(credentials.getPassword());
		   
		//   System.out.println("Hashed submitted Password is:"+hashedGivenPassword);
		   
		//   System.out.println("Password Read from Database is:"+temp.getPassword());
		   
		   if (test.checkPassword(credentials.getPassword(),temp.getPassword())) {
			 
			   String requestUserServiceURL="http://localhost:9763/CRUDservices_1.0.0/services/dbms_access/directory/getUser/"+credentials.getUsername();
			   
			   RestTemplate restTemplaterole = new RestTemplate();
			   String fullUserDetailsRestResponse=restTemplate.getForObject(requestUserServiceURL,String.class);
			   String[] decodedUserData=fullUserDetailsRestResponse.split(",");
			   
			 //  System.out.println("Role id is:"+decodedUserData[3]);
			   
			   switch(decodedUserData[3]) {
			    case "6666":
			      return "adminpanel";
			    case "2345":
			      return "loggedin";
			    case "2388":
			      return "loggedin";
			    case "8888":
			      return "loggedin";
			    default:
			    return "loginerror";
			   }
			   
		   } else
			 return "wrongpassword";                                  
		   
	   } else
	   return "wrongusername";
	} 
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
	 
		return "register";
	}  
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("DirectoryServiceUser") @Valid DirectoryServiceUser user,Model model, BindingResult result) {
	 
		
		System.out.println("Email:"+user.getEmail());
		System.out.println("Password:"+user.getPassword());		
		System.out.println("Username:"+user.getUsername());
		System.out.println("Role ID:"+user.getRoleid());
	
		String requestServiceURL2="http://localhost:9763/CRUDservices_1.0.0/services/dbms_access/directory/addUser/"+user.getUsername()+"/"+user.getPassword()+"/"+user.getEmail()+"/"+user.getRoleid();
		RestTemplate restTemplate2 = new RestTemplate();
		System.out.println(restTemplate2.getForObject(requestServiceURL2,String.class));
	
		
		return "adminpanel";
	} 
	
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String update(@ModelAttribute("DirectoryServiceUser") @Valid DirectoryServiceUser user,Model model, BindingResult result) {
	 
		
		String requestServiceURL2="http://localhost:9763/CRUDservices_1.0.0/services/dbms_access/directory/updateUser/"+user.getUsername()+"?email="+user.getEmail()+"&password="+user.getPassword()+"&roleid="+user.getRoleid();
		RestTemplate restTemplate2 = new RestTemplate();
		String response=restTemplate2.getForObject(requestServiceURL2,String.class);
	
		if (response.contains("updated sucessfully"))
		return "adminpanel";
		else
		return "updateuserError";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
	 
		return "deleteuser";
	}  
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
	 
		return "updateuser";
	}  
	
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String delete(@ModelAttribute("DirectoryServiceUser") @Valid DirectoryServiceUser user,Model model, BindingResult result) {
	 
		
		
		System.out.println("Email:"+user.getEmail());	
		System.out.println("Username:"+user.getUsername());
		
		
		String requestServiceURL2="http://localhost:9763/CRUDservices_1.0.0/services/dbms_access/directory/DeleteUserByName/"+user.getUsername()+"/"+user.getEmail();
		RestTemplate restTemplate2 = new RestTemplate();
		String response=restTemplate2.getForObject(requestServiceURL2,String.class);
		
		if (response.contains("Deleted Successfully"))
		return "adminpanel";
		else
	    return "userdeleteError";
	 
	}
	
	
	
	
    
	@RequestMapping(value = "/passwordChange", method = RequestMethod.POST)
	public String updatePassword(@ModelAttribute("UserCredentials") @Valid UserCredentials credentials, BindingResult result,Model model,HttpServletRequest request) {
	  //  String greetings = "Greetings, Spring MVC!";
	     /*	 if (result.hasErrors()) {
	            return "loginerror";
	        } */
		System.out.println("Attribute from session is:"+request.getSession().getAttribute("username"));
		System.out.println("Usename from change pass form:"+credentials.getUsername());
		System.out.println("Password from change pass form:"+credentials.getPassword());
		UserCredentials temp;
		Password pass;
		
		String requestServiceURL="http://localhost:9763/CRUDservices_1.0.0/services/dbms_access/directory/getUser/"+request.getSession().getAttribute("username");
		RestTemplate restTemplate = new RestTemplate();
		String RestResponse=restTemplate.getForObject(requestServiceURL,String.class);
		
		String[] decode=RestResponse.split(",");
		
		
		if (credentials.getUsername().equals(credentials.getPassword())) {
		
		 String requestServiceURL1="http://localhost:9763/CRUDservices_1.0.0/services/dbms_access/directory/DeleteUser/"+decode[4];
		 RestTemplate restTemplate1 = new RestTemplate();
		 System.out.println(restTemplate.getForObject(requestServiceURL1,String.class));
		 
		 
		 String requestServiceURL2="http://localhost:9763/CRUDservices_1.0.0/services/dbms_access/directory/addUser/"+decode[0]+"/"+credentials.getPassword()+"/"+decode[2]+"/"+decode[3];
		 RestTemplate restTemplate2 = new RestTemplate();
		 System.out.println(restTemplate2.getForObject(requestServiceURL2,String.class));
		 
		 
		 if (request.getSession().getAttribute("username").equals("admin"))
		 return "adminpanel";
		 else
	     return "loggedin";
	 
	   } else
	   return "wrongtypedPassword"; 	
	
		
	} 
	
	
	
	
	
	@RequestMapping("/changePassword")
	public String changePass() {

	 //  System.out.println("User name is:"+userName);	
		
	   return "changepass";

	}
	
	///
	
	
	@RequestMapping("/changePassBack")
	public String changePassBack() {

	   return "loggedin";

	}
	
	
	@RequestMapping("/adminBack")
	public String adminBack() {

	   return "adminpanel";

	}
	
	
	@RequestMapping("/signup")
	public String signup() {

	   return "register";

	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {

	request.getSession().setAttribute("username","");
	   return "home";

	}
	
	@RequestMapping("/signin")
	public String signin() {

	   return "home";

	}
	
	@RequestMapping("/forgotpassword")
	public String forgotpassword() {

	   return "forgotPassword";

	}
		
}

