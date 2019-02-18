package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Accepted;

public interface AcceptedDAO {
	public List<Accepted> getAccepted();

	public void saveAccepted(Accepted accepted);
	
	public Accepted getAccepted(int am);

	public void deleteAccepted(int am);
}
