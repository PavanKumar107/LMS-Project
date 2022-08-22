package com.blz.lms.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.blz.lms.model.MentorModel;

public interface MentorRepository extends JpaRepository<MentorModel, Long> {
	List<MentorModel> getMentorByMentorRole(String status);
}
