package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Accepted;

public interface AcceptedService {
	public List<Accepted> getAccepted();

	public void saveAccepted(Accepted accepted);
	
	public Accepted getAccepted(int am);

	public void deleteAccepted(int am);
}
