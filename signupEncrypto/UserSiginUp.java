package controller.supporter.signupEncrypto;

import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;

public class UserSiginUp implements UserService{
	
	private SupporterDTO supporterDTO;
	private SupporterDAO supporterDAO = new SupporterDAO();
	
	
	UserSiginUp(SupporterDTO supporterDTO) {
		this.supporterDTO = supporterDTO;
	}
	

	@Override
	public void userService() {
		supporterDAO.insert(supporterDTO);
	}
	
	
	
	

}
