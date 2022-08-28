package com.blz.lms.model;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@Column(name = "CANDIDATE_ID")
	private Long id;
	@Column(name = "CICID")
	private String cicId;
	@Column(name = "FULLNAME")
	private String fullName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "MOBILENO")
	private String mobileNum;
	@Column(name = "HIREDDATE")
	private String hiredDate;
	@Column(name = "DEGREE")
	private String degree;
	@Column(name = "AGGRPER")
	private Double aggrPer;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PREFERREDJOBLOCATION")
	private String preferredJobLocation;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "PASSEDOUTYEAR")
	private String passedOutYear;
	@Column(name = "CREATERUSER")
	private String creatorUser;
	@Column(name = "CANDIDATESTATUS")
	private String candidateStatus;

	private LocalDateTime creationTimeStamp;
	
	private LocalDateTime updatedTimeStamp;
	@OneToOne
	private TechStackModel techstackModel;
	

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
