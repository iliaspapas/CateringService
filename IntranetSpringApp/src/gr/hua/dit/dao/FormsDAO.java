package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Forms;

public interface FormsDAO {
	public List<Forms> getForms();

	public void saveForm(Forms forms);
	
	public Forms getForm(int Am);

	public void deleteForm(int Am);
}
