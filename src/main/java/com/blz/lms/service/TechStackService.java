package com.blz.lms.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.lms.dto.TechStackDTO;
import com.blz.lms.exception.AdminNotFoundException;
import com.blz.lms.model.AdminModel;
import com.blz.lms.model.TechStackModel;
import com.blz.lms.repository.AdminRepository;
import com.blz.lms.repository.TechStackRepository;
import com.blz.lms.util.TokenUtil;

@Service
public class TechStackService implements ITechStackService {

	@Autowired
	TechStackRepository techStackRepository;

	@Autowired
	TokenUtil tokenUtil;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	MailService mailService;

	@Override
	public TechStackModel addtechstack(TechStackDTO techStackDTO,String token,List<Long> id) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			List<AdminModel> admin = new ArrayList<>();
			id.stream().forEach(adminId -> {
				Optional<AdminModel> isIdPresent = adminRepository.findById(adminId);
				if(isIdPresent.isPresent()) {
					admin.add(isIdPresent.get());
				}
			});
			
			TechStackModel model = new TechStackModel(techStackDTO);
			if(admin.size()>0) {
				model.setCreatorUser(admin);
			}
			techStackRepository.save(model);
			return model;
		}
		throw new AdminNotFoundException(400,"Token invalid");
	}

	@Override
	public TechStackModel updateTechstack(TechStackDTO techStackDTO, Long id, String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			Optional<TechStackModel> isTechStackpresent = techStackRepository.findById(id);
			if(isTechStackpresent.isPresent()) {
				isTechStackpresent.get().setImagePath(techStackDTO.getImagePath());
				isTechStackpresent.get().setStatus(techStackDTO.isStatus());
				isTechStackpresent.get().setTechName(techStackDTO.getTechName());
				techStackRepository.save(isTechStackpresent.get());
				return isTechStackpresent.get();
			}
			throw new AdminNotFoundException(400,"Tech stack details not present");
		}
		throw new AdminNotFoundException(400,"Token Invalid");
	}

	@Override
	public List<TechStackModel> getAllTechStack(String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			List<TechStackModel> getAllTechStack = techStackRepository.findAll();
			if (getAllTechStack.size()>0) {
				return getAllTechStack;
			}else {
				throw new AdminNotFoundException(400,"Tech Stack details not present");
			}
		}
		throw new AdminNotFoundException(400,"Token invalid");
	}

	@Override
	public TechStackModel deleteTechStack(Long id, String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			Optional<TechStackModel> isTechStackPresent = techStackRepository.findById(id);
			if(isTechStackPresent.isPresent()) {
				techStackRepository.delete(isTechStackPresent.get());
				return isTechStackPresent.get();
			}
			throw new AdminNotFoundException(400,"Tech stack details not present");
		}
		throw new AdminNotFoundException(400,"Token invalid");
	}
}
