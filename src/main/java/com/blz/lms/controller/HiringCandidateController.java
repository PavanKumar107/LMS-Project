package com.blz.lms.controller;
import java.util.List;

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
import com.blz.lms.dto.HiringCandidateDTO;
import com.blz.lms.model.HiringCandidateModel;
import com.blz.lms.service.IHiringCandidateService;

/**
 * Purpose: HiringCandidate controller to process HiringCandidate Data APIs.
 * @version: 4.15.1.RELEASE
 * @author: Pavan Kumar G V  
 */
@RestController
@RequestMapping("/hiringcandidate")
public class HiringCandidateController {

	@Autowired
	IHiringCandidateService hiringCandidateService;

	/**
	 * Purpose: To create HiringCandidate
	 * @Param: hiringCandidateDTO, token and bankDetailsId
	 */
	@PostMapping("/addhiringcandidate")
	public HiringCandidateModel addHiringCandidate(@Valid@RequestBody HiringCandidateDTO hiringCandidateDTO,@RequestHeader String token,@RequestParam Long bankDetailsId) {
		return hiringCandidateService.addHiringCandidate(hiringCandidateDTO, token, bankDetailsId);
	}

	/**
	 * Purpose: To update HiringCandidate details by id
	 * @Param: hiringCandidateDTO,id and token
	 */
	@PutMapping("/updatehiringcandidate/{id}")
	public HiringCandidateModel updateHiringCandidate(@RequestBody HiringCandidateDTO hiringCandidateDTO,@PathVariable Long id,@RequestHeader String token) {
		return hiringCandidateService.updateHiringCandidate(hiringCandidateDTO, id, token);
	}

	/**
	 * Purpose: To get all HiringCandidate data
	 * @Param: token 
	 */
	@GetMapping("getallhiringcandidates")
	public List<HiringCandidateModel> getAllHiringCandidate(@RequestHeader String token) {
		return hiringCandidateService.getAllHiringCandidate(token);
	}

	/**
	 * Purpose: To delete HiringCandidate details by id
	 * @Param: id and token
	 */
	@DeleteMapping("/deletehiringcandidate/{id}")
	public HiringCandidateModel deleteHiringCandidate(@PathVariable Long id,@RequestHeader String token) {
		return hiringCandidateService.deleteHiringCandidate(id, token);
	}
}
