package com.blz.lms.model;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import com.blz.lms.dto.HiringCandidateDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(name="hiringcandidate")
@Data
public class HiringCandidateModel {
	@Id
	@GenericGenerator(name = "hiringcandidate", strategy = "increment")
	@GeneratedValue(generator = "hiringcandidate")
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
	private String JobLocation;
	private String passedOutYear;
	private String creatorUser;
	private String candidateStatus;
	@JsonIgnore
	@CreationTimestamp
	private LocalDateTime creationTimeStamp;
	@JsonIgnore
	@UpdateTimestamp
	private LocalDateTime updatedTimeStamp;
	@OneToOne
	private BankDetailsModel bankdetails;

	public HiringCandidateModel() {

	}

	public HiringCandidateModel(HiringCandidateDTO hiringCandidateDTO) {
		this.cicId = hiringCandidateDTO.getCicId();
		this.fullName = hiringCandidateDTO.getFullName();
		this.email = hiringCandidateDTO.getEmail();
		this.mobileNum = hiringCandidateDTO.getMobileNum();
		this.hiredDate = hiringCandidateDTO.getHiredDate();
		this.degree = hiringCandidateDTO.getDegree();
		this.aggrPer = hiringCandidateDTO.getAggrPer();
		this.city = hiringCandidateDTO.getCity();
		this.state = hiringCandidateDTO.getState();;
		this.JobLocation = hiringCandidateDTO.getJobLocation();
		this.passedOutYear = hiringCandidateDTO.getPassedOutYear();
		this.creatorUser = hiringCandidateDTO.getCreatorUser();
		this.candidateStatus = hiringCandidateDTO.getCandidateStatus();
		this.creationTimeStamp = hiringCandidateDTO.getCreationTimeStamp().now();
		this.updatedTimeStamp = hiringCandidateDTO.getUpdatedTimeStamp();
	}
}
