package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CarsList")
@Component
public class AcceptedList {

	List<Accepted> acceptedList;
	
	public List<Accepted> getAcceptedList(){
		return acceptedList; 
	}
	
	public void setAcceptedList(List<Accepted> AcceptedList) {
		this.acceptedList=AcceptedList;
	}
	
}