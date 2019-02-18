package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Forms;

public interface FormsService {
	public List<Forms> getForms();

	public void saveForm(Forms forms);
	
	public Forms getForm(int Am);

	public void deleteForm(int Am);
}
