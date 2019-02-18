package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="FormsList")
@Component
public class FormsList {

	List<Forms> formsList;
	
	public List<Forms> getCustomerList(){
		return formsList; 
	}
	
	public void setCustomerList(List<Forms> formsList) {
		this.formsList=formsList;
	}
	
}
