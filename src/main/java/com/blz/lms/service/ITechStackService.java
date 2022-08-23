package com.blz.lms.service;

import java.util.List;

import com.blz.lms.dto.TechStackDTO;
import com.blz.lms.model.TechStackModel;

public interface ITechStackService {
	TechStackModel addtechstack(TechStackDTO techStackDTO,String token,List<Long> id);

	TechStackModel updateTechstack(TechStackDTO techStackDTO,Long id,String token);

	List<TechStackModel> getAllTechStack(String token);
	
	TechStackModel deleteTechStack(Long id,String token);
}
