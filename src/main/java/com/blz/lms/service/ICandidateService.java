package com.blz.lms.service;
import java.util.List;
import com.blz.lms.dto.CandidateDTO;
import com.blz.lms.model.CandidateModel;

public interface ICandidateService {

	CandidateModel addCandidate(CandidateDTO candidateDTO,String token);

	CandidateModel updateCandidate(CandidateDTO candidateDTO,Long id,String token);

	List<CandidateModel>getAllCandidates(String token);

	CandidateModel deleteCandidate(Long id,String token);
	
	List<CandidateModel> getCandidateByStatus(String status);
	
	CandidateModel ChangeStatus(Long id,String token);

}
