package com.blz.lms.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blz.lms.dto.CandidateDTO;
import com.blz.lms.exception.AdminNotFoundException;
import com.blz.lms.model.AdminModel;
import com.blz.lms.model.CandidateModel;
import com.blz.lms.repository.AdminRepository;
import com.blz.lms.repository.CandidateRepository;
import com.blz.lms.util.TokenUtil;

@Service
public class CandidateService implements ICandidateService {
	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	MailService mailService;

	@Autowired
	TokenUtil tokenUtil;

	@Override
	public CandidateModel addCandidate(CandidateDTO candidateDTO,String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			CandidateModel model = new CandidateModel(candidateDTO);
			candidateRepository.save(model);
			String body = "Candidate added successfully with candidateId"+model.getId();
			String subject = "Candidate Registration Successfull";
			mailService.send(model.getEmail(), subject, body);
			return model;
		}
		throw new AdminNotFoundException(400,"Token not present");
	}

	@Override
	public CandidateModel updateCandidate(CandidateDTO candidateDTO, Long id, String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			Optional<CandidateModel>isCandidatePresent = candidateRepository.findById(id);
			if(isCandidatePresent.isPresent()) {
				isCandidatePresent.get().setCicId(candidateDTO.getCicId());
				isCandidatePresent.get().setFullName(candidateDTO.getFullName());
				isCandidatePresent.get().setEmail(candidateDTO.getEmail());
				isCandidatePresent.get().setMobileNum(candidateDTO.getMobileNum());
				isCandidatePresent.get().setHiredDate(candidateDTO.getHiredDate());
				isCandidatePresent.get().setDegree(candidateDTO.getDegree());
				isCandidatePresent.get().setAggrPer(candidateDTO.getAggrPer());
				isCandidatePresent.get().setCity(candidateDTO.getCity());
				isCandidatePresent.get().setState(candidateDTO.getState());
				isCandidatePresent.get().setPreferredJobLocation(candidateDTO.getPreferredJobLocation());
				isCandidatePresent.get().setStatus(candidateDTO.getStatus());
				isCandidatePresent.get().setPassedOutYear(candidateDTO.getPassedOutYear());
				isCandidatePresent.get().setCreatorUser(candidateDTO.getCreatorUser());
				isCandidatePresent.get().setCandidateStatus(candidateDTO.getCandidateStatus());
				isCandidatePresent.get().setUpdatedTimeStamp(candidateDTO.getUpdatedTimeStamp());
				candidateRepository.save(isCandidatePresent.get());
				String body = "Candidate updated successfully with adminId"+isCandidatePresent.get().getId();
				String subject = "Admin updated Successfully";
				mailService.send(isCandidatePresent.get().getEmail(), subject, body);
				return isCandidatePresent.get();
			}
			throw new AdminNotFoundException(400,"Admin not present");
		}
		throw new AdminNotFoundException(400,"Token not present");
	}

	@Override
	public List<CandidateModel> getAllCandidates(String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			List<CandidateModel> getAllCandidates = candidateRepository.findAll();
			if(getAllCandidates.size()>0) {
				return getAllCandidates;
			}else {
				throw new AdminNotFoundException(400,"Candidate not present");
			}	
		}
		throw new AdminNotFoundException(400,"Token not present");
	}

	@Override
	public CandidateModel deleteCandidate(Long id, String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<CandidateModel > isCandidatePresent = candidateRepository.findById(id);
		if(isCandidatePresent.isPresent()) {
			candidateRepository.delete(isCandidatePresent.get());
			String body = "Candidate deleted successfully with candidateId"+isCandidatePresent.get().getId();
			String subject = "Candidate deleted Successfully";
			mailService.send(isCandidatePresent.get().getEmail(), subject, body);
			return isCandidatePresent.get();
		}
		throw new AdminNotFoundException(400,"Candidate not present");
	}

	@Override
	public List<CandidateModel> getCandidateByStatus(String status,String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel>isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			List<CandidateModel> isStatusPresent = candidateRepository.getCandidateByStatus(status);
			if(isStatusPresent.size() > 0) {
				return isStatusPresent;
			}
			throw new AdminNotFoundException(400,"no candidate present with that status");	
		}
		throw new AdminNotFoundException(400,"Token not present");
	}

	@Override
	public CandidateModel ChangeStatus(Long id, String status,String token) {
		Long admId = tokenUtil.decodeToken(token);
		Optional<AdminModel> isTokenPresent = adminRepository.findById(admId);
		if(isTokenPresent.isPresent()) {
			Optional<CandidateModel> isPresent = candidateRepository.findById(id);
			if (isPresent.isPresent()) {
				isPresent.get().setStatus(status);
				candidateRepository.save(isPresent.get());
				String body = "Candidate status changed successfully with candidateId"+isPresent.get().getId();
				String subject = "Candidate status changed Successfully";
				mailService.send(isPresent.get().getEmail(), subject, body);
				return isPresent.get();
			}
			throw new AdminNotFoundException(400,"Status not found");
		}
		throw new AdminNotFoundException(400,"Token not present");
	}

	@Override
	public long statusCount(String status,String token) {
		Long admId = tokenUtil.decodeToken(token);
		List<CandidateModel> isStatusPresent = candidateRepository.getCandidateByStatus(status);
		if(isStatusPresent.size()>0) {
			return isStatusPresent.stream().count();
		}
		throw new AdminNotFoundException(400,"Status not found");	
	}
}


