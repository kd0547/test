package controller.supporter.signupEncrypto;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import model.supporter.SupporterDTO;

public class UserSignUpTemp extends Encrypto implements UserService{
	
	HttpServletRequest request;
	private UserSiginUp signUp;
	SupporterDTO supporterDTO;
	
	public UserSignUpTemp(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void userService() {
		
		try {
			supporterDTO = createSupporterVO(request);
			
			System.out.println(supporterDTO.toString());
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		if(signUp == null && supporterDTO != null) {
			signUp = new UserSiginUp(supporterDTO);
		}

		signUp.userService();

	}
	
	private SupporterDTO createSupporterVO(HttpServletRequest request) throws NoSuchAlgorithmException{
		SupporterDTO supporter = new SupporterDTO();
		String encrypto = null;
		encrypto = encrypt(request.getParameter("supporter_password"));
		
		//System.out.println(encrypto);
		
		if(request != null) {
			
			//System.out.println(request.getParameter("supporter_id"));
			
			supporter.setSupporter_id(request.getParameter("supporter_id"));
			supporter.setSupporter_name(request.getParameter("supporter_name"));
			supporter.setSupporter_password(encrypto);
			supporter.setPhone_number(request.getParameter("phone_number"));
			supporter.setPost_code(request.getParameter("post_code"));
			supporter.setDetailed_address(request.getParameter("detailed_address"));
			
			supporter.toString();
			
			return supporter;
		} 
		
		
		return supporter;
	}

}
