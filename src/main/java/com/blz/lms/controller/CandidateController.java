package com.blz.lms.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
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

/**
 * Purpose: candidate controller to process candidate Data APIs.
 * @version: 4.15.1.RELEASE
 * @author: Pavan Kumar G V  
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	ICandidateService candidateService;

	@Autowired
    private JobLauncher jobLauncher;
    
    @Autowired
    private Job job;

    @PostMapping("/candidates")
    public void importCsvToDBJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * Purpose: To create Candidate
	 * @Param: candidateDTO,token and id
	 */
	@PostMapping("/addcandidate")
	public CandidateModel addCandidate(@Valid@RequestBody CandidateDTO candidateDTO,@RequestHeader String token,@RequestParam Long id) {
		return candidateService.addCandidate(candidateDTO,token,id);
	}

	/**
	 * Purpose: To update Candidate details by id
	 * @Param: candidateDTO,token and id
	 */
	@PutMapping("/updatecandidate/{id}")
	public CandidateModel updateCandidate(@Valid@RequestBody CandidateDTO candidateDTO,@PathVariable Long id,@RequestHeader String token) {
		return candidateService.updateCandidate(candidateDTO, id, token);
	}

	/**
	 * Purpose: To get Candidate details by id
	 * @Param: token
	 */
	@GetMapping("/getallcandidates")
	public List<CandidateModel> getAllCandidates(@RequestHeader String token) {
		return candidateService.getAllCandidates(token);
	}

	/**
	 * Purpose: To delete Candidate details by id
	 * @Param: id and token
	 */
	@DeleteMapping("/deletecandidate/{id}")
	public CandidateModel deleteCandidate(@PathVariable Long id,@RequestHeader String token) {
		return candidateService.deleteCandidate(id, token);
	}

	/**
	 * Purpose: To get candidate details by status
	 * @Param: status and token
	 */
	@GetMapping("/getbystatus/{status}")
	public List<CandidateModel> getCandidateByStatus(@PathVariable String status,@RequestHeader String token){
		return candidateService.getCandidateByStatus(status,token);
	}

	/**
	 * Purpose: To change candidate status by id
	 * @Param: id, status and token
	 */
	@PutMapping("/changestatus/{id}")
	public CandidateModel ChangeStatus(@Valid@PathVariable Long id,@RequestParam String status,@RequestHeader String token) {
		return candidateService.ChangeStatus(id,status,token);
	}
	
	/**
	 * Purpose: To get count of status
	 * @Param: status and token
	 */
	@GetMapping("/getstatuscount")
	public long statusCount(@RequestParam String status,@RequestHeader String token) {
		return candidateService.statusCount(status, token);
	}
}
