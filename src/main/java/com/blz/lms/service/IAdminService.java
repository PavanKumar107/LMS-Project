package com.blz.lms.service;

import java.util.List;
import java.util.Optional;
import com.blz.lms.dto.AdminDTO;
import com.blz.lms.model.AdminModel;
import com.blz.lms.util.Response;

public interface IAdminService {
	
	AdminModel addAdmin(AdminDTO adminDTO);
	
	AdminModel updateAdmin(AdminDTO adminDTO,Long id,String token);
	
	List<AdminModel>getAllAdmins(String token);
	
	Optional<AdminModel>getAdminById(Long id,String token);
	
	AdminModel deleteAdmin(Long id,String token);
	
	Response login(String emailId, String password);

	Response resetPassword(String emailId);

	AdminModel changePassword(String token, String password);

}
