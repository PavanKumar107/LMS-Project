package com.blz.lms.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blz.lms.dto.AdminDTO;
import com.blz.lms.exception.AdminNotFoundException;
import com.blz.lms.model.AdminModel;
import com.blz.lms.repository.AdminRepository;
import com.blz.lms.util.Response;
import com.blz.lms.util.TokenUtil;

@Service
public class AdminService implements IAdminService{

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	TokenUtil tokenUtil;

	@Autowired
	MailService mailService;

	@Override
	public AdminModel addAdmin(AdminDTO adminDTO) {
		AdminModel model = new AdminModel(adminDTO);
		adminRepository.save(model);
		String body = "Admin added successfully with adminId"+model.getId();
		String subject = "Admin Registration Successfull";
		mailService.send(model.getEmailId(), subject, body);
		return model;
	}

	@Override
	public AdminModel updateAdmin(AdminDTO adminDTO, Long id,String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			Optional<AdminModel> isAdminPresent= adminRepository.findById(id);
			if(isAdminPresent.isPresent()) {
				isAdminPresent.get().setFirstName(adminDTO.getFirstName());
				isAdminPresent.get().setLastName(adminDTO.getLastName());
				isAdminPresent.get().setMobile(adminDTO.getMobile());
				isAdminPresent.get().setEmailId(adminDTO.getEmailId());
				isAdminPresent.get().setProfilePath(adminDTO.getProfilePath());
				isAdminPresent.get().setUpdatedStamp(adminDTO.getUpdatedStamp());
				adminRepository.save(isAdminPresent.get());
				String body = "Admin updated successfully with adminId"+isAdminPresent.get().getId();
				String subject = "Admin updated Successfully";
				mailService.send(isAdminPresent.get().getEmailId(), subject, body);
				return isAdminPresent.get();
			}
			throw new AdminNotFoundException(400,"Admin not present");
		}
		throw new AdminNotFoundException(400,"Token Invalid");
	}

	@Override
	public List<AdminModel> getAllAdmins(String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			List<AdminModel>getAllAdmins = adminRepository.findAll();
			if(getAllAdmins.size() > 0) {
				return getAllAdmins;
			}else {
				throw new AdminNotFoundException(400,"Admin not present");
			}	
		}
		throw new AdminNotFoundException(400,"Token Invalid");
	}

	@Override
	public Optional<AdminModel> getAdminById(Long id,String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			return adminRepository.findById(id);
		}
		throw new AdminNotFoundException(400,"Token Invalid");
	}

	@Override
	public AdminModel deleteAdmin(Long id,String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			Optional<AdminModel> isAdminPresent = adminRepository.findById(id);
			if(isAdminPresent.isPresent()) {
				adminRepository.delete(isAdminPresent.get());
				String body = "Admin deleted successfully with adminId"+isAdminPresent.get().getId();
				String subject = "Admin deleted Successfully";
				mailService.send(isAdminPresent.get().getEmailId(), subject, body);
				return isAdminPresent.get();
			}
			throw new AdminNotFoundException(400,"Admin not present");
		}
		throw new AdminNotFoundException(400,"Token Invalid");
	}

	@Override
	public Response login(String emailId, String password) {
		Optional<AdminModel> isEmailPresent = adminRepository.findByEmailId(emailId);
		if(isEmailPresent.isPresent()){
			if(isEmailPresent.get().getPassword().equals(password)){
				String token = tokenUtil.createToken(isEmailPresent.get().getId());
				return new Response("login succesfull",200,token);
			}
			throw new AdminNotFoundException(400,"Invald credentials");
		}
		throw new AdminNotFoundException(400,"invalid emailid");
	}

	@Override
	public Response resetPassword(String emailId) {
		Optional<AdminModel> isMailPresent = adminRepository.findByEmailId(emailId);
		if (isMailPresent.isPresent()){
			String token = tokenUtil.createToken(isMailPresent.get().getId());
			String url = "http://localhost:8089/admin/resetpassword "+token;
			String subject = "reset password Successfully";
			mailService.send(isMailPresent.get().getEmailId(), subject, url);
			return new Response("Reset password",200,token);
		}
		throw new AdminNotFoundException(400, "EmailNOtFound");
	}

	@Override
	public AdminModel changePassword(String token, String password) {
		Long decode = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(decode);
		if (isTokenPresent.isPresent()) {
			isTokenPresent.get().setPassword(password);
			adminRepository.save(isTokenPresent.get());
			String body = "Password changed successfully with adminId"+isTokenPresent.get().getId();
			String subject = "Password changed Successfully";
			mailService.send(isTokenPresent.get().getEmailId(), subject, body);
			return isTokenPresent.get();
		}
		throw new AdminNotFoundException(400,"Token not find");
	}

	@Override
	public AdminModel addProfilePath(Long id, String profilePath,String token) {
		Long decode = tokenUtil.decodeToken(token);
		Optional<AdminModel>isAdminPresent = adminRepository.findById(id);
		if (isAdminPresent.isPresent()) {
			isAdminPresent.get().setProfilePath(profilePath);
			adminRepository.save(isAdminPresent.get());
			String body = "Profile path added successfully with adminId"+isAdminPresent.get().getId();
			String subject = "Profile path added Successfully";
			mailService.send(isAdminPresent.get().getEmailId(), subject, body);
			return isAdminPresent.get();

		}
		throw new AdminNotFoundException(400,"Admin not present");
	}
}
