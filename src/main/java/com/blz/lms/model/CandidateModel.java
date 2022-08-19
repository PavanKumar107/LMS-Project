package com.blz.lms.model;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.blz.lms.dto.CandidateDTO;
import lombok.Data;

@Entity
@Table(name="candidate")
@Data

public class CandidateModel {
	@Id
	@GenericGenerator(name = "candidate", strategy = "increment")
	@GeneratedValue(generator = "candidate")
	private Long id;
	private String cicId;
	private String fullName;
	private String email;
	private String mobileNum;
	private String hiredDate;
	private String degree;
	private Double aggrPer;
	private String city;
	private String state;
	private String preferredJobLocation;
	private String status;
	private String passedOutYear;
	private String creatorUser;
	private String candidateStatus;
	private LocalDateTime creationTimeStamp;
	private LocalDateTime updatedTimeStamp;

	public CandidateModel() {

	}

	public CandidateModel(CandidateDTO candidateDTO) {
		this.cicId =candidateDTO.getCicId();
		this.fullName = candidateDTO.getFullName();
		this.email = candidateDTO.getEmail();
		this.mobileNum = candidateDTO.getMobileNum();
		this.hiredDate = candidateDTO.getHiredDate();
		this.degree = candidateDTO.getDegree();
		this.aggrPer = candidateDTO.getAggrPer();
		this.city = candidateDTO.getCity();
		this.state = candidateDTO.getState();
		this.preferredJobLocation = candidateDTO.getPreferredJobLocation();
		this.status = candidateDTO.getStatus();
		this.passedOutYear = candidateDTO.getPassedOutYear();
		this.creatorUser = candidateDTO.getCreatorUser();
		this.candidateStatus = candidateDTO.getCandidateStatus();
		this.creationTimeStamp = candidateDTO.getCreationTimeStamp();
		this.updatedTimeStamp = candidateDTO.getUpdatedTimeStamp();
	}
}
