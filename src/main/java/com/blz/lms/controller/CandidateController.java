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
import com.blz.lms.dto.CandidateDTO;
import com.blz.lms.model.CandidateModel;
import com.blz.lms.service.ICandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	ICandidateService candidateService;

	@PostMapping("/addcandidate")
	public CandidateModel addCandidate(@Valid@RequestBody CandidateDTO candidateDTO,@RequestHeader String token) {
		return candidateService.addCandidate(candidateDTO,token);
	}

	@PutMapping("/updatecandidate/{id}")
	public CandidateModel updateCandidate(@Valid@RequestBody CandidateDTO candidateDTO,@PathVariable Long id,@RequestHeader String token) {
		return candidateService.updateCandidate(candidateDTO, id, token);
	}

	@GetMapping("/getallcandidates")
	public List<CandidateModel> getAllCandidates(@RequestHeader String token) {
		return candidateService.getAllCandidates(token);
	}

	@DeleteMapping("/deletecandidate/{id}")
	public CandidateModel deleteCandidate(@PathVariable Long id,@RequestHeader String token) {
		return candidateService.deleteCandidate(id, token);
	}

	@GetMapping("/getbystatus/{status}")
	public List<CandidateModel> getCandidateByStatus(@PathVariable String status,@RequestHeader String token){
		return candidateService.getCandidateByStatus(status,token);
	}

	@PutMapping("/changestatus/{id}")
	public CandidateModel ChangeStatus(@Valid@PathVariable Long id,@RequestParam String status,@RequestHeader String token) {
		return candidateService.ChangeStatus(id,status,token);
	}
	
	
	@GetMapping("/getstatuscount")
	public long statusCount(@RequestParam String status,@RequestHeader String token) {
		return candidateService.statusCount(status, token);
	}
}
