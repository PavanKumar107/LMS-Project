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
import com.blz.lms.dto.MentorDTO;
import com.blz.lms.model.MentorModel;
import com.blz.lms.service.IMentorService;

/**
 * Purpose: Mentor controller to process Mentor Data APIs.
 * @version: 4.15.1.RELEASE
 * @author: Pavan Kumar G V  
 */
@RestController
@RequestMapping("/mentor")
public class MentorController {

	@Autowired
	IMentorService mentorService;
	
	/**
	 * Purpose: To create Mentor
	 * @Param: mentorDTO and token
	 */
	@PostMapping("/addmentor")
	public MentorModel addMentor(@Valid@RequestBody MentorDTO mentorDTO,@RequestHeader String token) {
		return mentorService.addMentor(mentorDTO, token);
	}
	
	/**
	 * Purpose: To update Mentor details by id
	 * @Param: mentorDTO, id and token
	 */
	@PutMapping("/updatementor/{id}")
	public MentorModel updateMentor(@Valid@RequestBody MentorDTO mentorDTO,@PathVariable Long id,@RequestHeader String token) {
		return mentorService.updateMentor(mentorDTO, id, token);
	}
	
	/**
	 * Purpose: To get all Mentor details
	 * @Param: token
	 */
	@GetMapping("/getallmentors")
	public List<MentorModel> getAllMentors(@RequestHeader String token) {
		return mentorService.getAllMentors(token);
	}
	
	/**
	 * Purpose: To delete Mentor details by id 
	 * @Param: mentorDTO, id and token
	 */
	@DeleteMapping("/deletementor/{id}")
	public MentorModel deleteMentor(@PathVariable Long id,@RequestHeader String token) {
		return mentorService.deleteMentor(id, token);
	}
	
	/**
	 * Purpose: To get Mentor data by id 
	 * @Param: id and token
	 */
	@GetMapping("/getmentorbyid/{id}")
	public Optional<MentorModel> getMentorById(@PathVariable Long id,@RequestHeader String token) {
		return mentorService.getMentorById(id, token);
	}
	
	/**
	 * Purpose: To get Mentor data by role 
	 * @Param: mentorRole and token
	 */
	@GetMapping("/getbymentorrole/{mentorrole}")
	public List<MentorModel> getMentorByMentorRole(@RequestParam String mentorRole , @RequestHeader String token) {
		return mentorService.getMentorByMentorRole(mentorRole, token);
	}
	
	/**
	 * Purpose: To get Mentorrole count 
	 * @Param: mentorRole and token
	 */
	@GetMapping("/getmentorrolecount")
	public long mentorsRoleCount(@RequestParam String mentorRole,@RequestHeader String token) {
		return mentorService.mentorsRoleCount(mentorRole, token);
	}
}
