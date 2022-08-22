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

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IAdminService adminService;
	
	@PostMapping("/addadmin")
	public AdminModel addAdmin(@Valid@RequestBody AdminDTO adminDTO) {
		return adminService.addAdmin(adminDTO);
	}
	
	@PutMapping("/updateadmin/{id}")
	public AdminModel updateAdmin(@Valid@RequestBody AdminDTO adminDTO,@PathVariable Long id,@RequestHeader String token) {
		return adminService.updateAdmin(adminDTO, id,token);
	}
	
	@GetMapping("/getalladmins")
	public List<AdminModel> getAllAdmins(@RequestHeader String token) {
		return adminService.getAllAdmins(token);
	}
	
	@GetMapping("/getadminbyid/{id}")
	public Optional<AdminModel> getAdminById(@PathVariable Long id,@RequestHeader String token) {
		return adminService.getAdminById(id,token);
	}
	
	@DeleteMapping("/deleteadmin/{id}")
	public AdminModel deleteAdmin(@PathVariable Long id,@RequestHeader String token) {
		return adminService.deleteAdmin(id,token);
	}
	
	@PostMapping("/login")
	public Response login(@RequestParam String emailId,@RequestParam String password) {
		return adminService.login(emailId, password);
	}
	
	@PostMapping("/resetpassword")
    public Response resetPassword(@RequestParam String emailId) {
        return adminService.resetPassword(emailId);
    }

    @PutMapping("/changepassword/{token}")
    public AdminModel changePassword(@PathVariable String token, @RequestParam String password) {
        return adminService.changePassword(token, password);
    }
    
    @PostMapping("/addprofilepath")
	public AdminModel addProfilePath(@RequestBody Long id,@RequestParam String profilePath,@RequestHeader String token) {
		return adminService.addProfilePath(id, profilePath,token);
    }
}
