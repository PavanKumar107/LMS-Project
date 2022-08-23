package com.blz.lms.service;

import java.util.List;

import com.blz.lms.dto.HiringCandidateDTO;
import com.blz.lms.model.HiringCandidateModel;

public interface IHiringCandidateService {
	
	HiringCandidateModel addHiringCandidate(HiringCandidateDTO hiringCandidateDTO,String token,Long bankDetailsId);
	
	HiringCandidateModel updateHiringCandidate(HiringCandidateDTO hiringCandidateDTO,Long id,String token);
	
	List<HiringCandidateModel> getAllHiringCandidate(String token);

	HiringCandidateModel deleteHiringCandidate(Long id,String token);

}
