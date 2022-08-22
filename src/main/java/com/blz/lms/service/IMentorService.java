package com.blz.lms.service;
import java.util.List;
import java.util.Optional;
import com.blz.lms.dto.MentorDTO;
import com.blz.lms.model.MentorModel;

public interface IMentorService {

	MentorModel addMentor(MentorDTO mentorDTO,String token);
	
	MentorModel updateMentor(MentorDTO mentorDTO,Long id,String token);
	
	List<MentorModel> getAllMentors(String token);
	
	MentorModel deleteMentor(Long id,String token);
	
	Optional<MentorModel> getMentorById(Long id,String token);
	
	List<MentorModel> getMentorByMentorRole(String mentorRole,String token);
	
	long mentorsRoleCount(String mentorRole,String token);
}
