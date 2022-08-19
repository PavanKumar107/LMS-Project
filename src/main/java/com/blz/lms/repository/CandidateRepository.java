package com.blz.lms.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blz.lms.model.CandidateModel;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateModel, Long>{
		List<CandidateModel> getCandidateByStatus(String status);
}
