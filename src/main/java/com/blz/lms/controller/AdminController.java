package com.blz.lms.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blz.lms.dto.AdminDTO;
import com.blz.lms.model.AdminModel;
import com.blz.lms.service.IAdminService;
import com.blz.lms.util.Response;

/**
 * Purpose: Admin controller to process Admin Data APIs.
 * @version: 4.15.1.RELEASE
 * @author: Pavan Kumar G V  
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	/**
	 * Purpose: Create Admin
	 * @Param: adminDTO
	 */
	@PostMapping("/addadmin")
	public AdminModel addAdmin(@Valid@RequestBody AdminDTO adminDTO) {
		return adminService.addAdmin(adminDTO);
	}

	/**
	 * Purpose:Update Admin details
	 * @Param: id
	 */
	@PutMapping("/updateadmin/{id}")
	public AdminModel updateAdmin(@Valid@RequestBody AdminDTO adminDTO,@PathVariable Long id,@RequestHeader String token) {
		return adminService.updateAdmin(adminDTO, id,token);
	}

	/**
	 * Purpose:To get all the Admin data
	 * @Param: token
	 */
	@GetMapping("/getalladmins")
	public List<AdminModel> getAllAdmins(@RequestHeader String token) {
		return adminService.getAllAdmins(token);
	}

	/**
	 * Purpose:TO get Admin data by id
	 * @Param: id and token
	 */
	@GetMapping("/getadminbyid/{id}")
	public Optional<AdminModel> getAdminById(@PathVariable Long id,@RequestHeader String token) {
		return adminService.getAdminById(id,token);
	}

	/**
	 * Purpose:TO delete Admin data by id 
	 * @Param: id and token
	 */
	@DeleteMapping("/deleteadmin/{id}")
	public AdminModel deleteAdmin(@PathVariable Long id,@RequestHeader String token) {
		return adminService.deleteAdmin(id,token);
	}
	
	/**
	 * Purpose:Login method 
	 * @Param: email and password
	 */
	@PostMapping("/login")
	public Response login(@RequestParam String emailId,@RequestParam String password) {
		return adminService.login(emailId, password);
	}

	/**
	 * Purpose:TO reset the password
	 * @Param: emailid
	 */
	@PostMapping("/resetpassword")
	public Response resetPassword(@RequestParam String emailId) {
		return adminService.resetPassword(emailId);
	}

	/**
	 * Purpose:To change the password
	 * @Param: token and password
	 */
	@PutMapping("/changepassword/{token}")
	public AdminModel changePassword(@PathVariable String token, @RequestParam String password) {
		return adminService.changePassword(token, password);
	}

	/**
	 * Purpose:TO create profilepath
	 * @Param: id,profilepath and token
	 */
	@PostMapping("/addprofilepath")
	public AdminModel addProfilePath(@RequestBody Long id,@RequestParam String profilePath,@RequestHeader String token) {
		return adminService.addProfilePath(id, profilePath,token);
	}
}
