package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.FormsDAO;
import gr.hua.dit.entity.Forms;

@Service
public class FormsServiceImpl implements FormsService {

	@Autowired
	private FormsDAO formsDAO;
	@Override
	@Transactional
	public List<Forms> getForms() {
		return formsDAO.getForms();
	}

	@Override
	@Transactional
	public void saveForm(Forms forms) {
		formsDAO.saveForm(forms);

	}

	@Override
	@Transactional
	public Forms getForm(int Am) {
		return formsDAO.getForm(Am);
	}

	@Override
	@Transactional
	public void deleteForm(int Am) {
		formsDAO.deleteForm(Am);

	}

}
