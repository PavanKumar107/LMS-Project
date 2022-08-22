package com.blz.lms.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.blz.lms.dto.MentorDTO;
import lombok.Data;

@Entity
@Table(name = "mentor")
@Data
public class MentorModel {
	@Id
	@GenericGenerator(name = "mentor", strategy = "increment")
	@GeneratedValue(generator = "mentor")
	private Long id;
	private String employeeId;
	private String firstName;
	private String lastName;
	private String mentorType;
	private String mentorRole;
	private String mobileNumber;
	private String email;
	private String experienceYears;
	private String preferredTime;
	private LocalDate startDate;
	private String status;
	private String mentorDescription;
	private String profileImageURL;
	private int creatorUser;
	private long supervisorId;
	private LocalDateTime createdTimeStamp;
	private LocalDateTime updatedTimeStamp;
	
	public MentorModel() {

	}

	public MentorModel(MentorDTO mentorDTO) {
		this.employeeId = mentorDTO.getEmployeeId();
		this.firstName = mentorDTO.getFirstName();
		this.lastName = mentorDTO.getLastName();
		this.mentorType = mentorDTO.getMentorType();
		this.mentorRole = mentorDTO.getMentorRole();
		this.mobileNumber = mentorDTO.getMobileNumber();
		this.email = mentorDTO.getEmail();
		this.experienceYears = mentorDTO.getExperienceYears();
		this.preferredTime = mentorDTO.getPreferredTime();
		this.startDate = mentorDTO.getStartDate();
		this.status = mentorDTO.getStatus();
		this.mentorDescription = mentorDTO.getMentorDescription();
		this.profileImageURL = mentorDTO.getProfileImageURL();
		this.creatorUser = mentorDTO.getCreatorUser();
		this.supervisorId = mentorDTO.getSupervisorId();
		this.createdTimeStamp = mentorDTO.getCreatedTimeStamp().now();
		this.updatedTimeStamp = mentorDTO.getUpdatedTimeStamp();
	}
}
