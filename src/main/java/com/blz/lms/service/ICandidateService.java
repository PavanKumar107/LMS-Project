package com.blz.lms.service;
import java.util.List;
import com.blz.lms.dto.CandidateDTO;
import com.blz.lms.model.CandidateModel;

public interface ICandidateService {

	CandidateModel addCandidate(CandidateDTO candidateDTO,String token,Long id);

	CandidateModel updateCandidate(CandidateDTO candidateDTO,Long id,String token);

	List<CandidateModel> getAllCandidates(String token);

	CandidateModel deleteCandidate(Long id,String token);
	
	List<CandidateModel> getCandidateByStatus(String status,String token);
	
	CandidateModel ChangeStatus(Long id,String status,String token);
	
	long statusCount(String status,String token);

}
