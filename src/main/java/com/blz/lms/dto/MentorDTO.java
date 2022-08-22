package com.blz.lms.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MentorDTO {
	
	@Pattern(regexp = "^[0-9]{2,}$",message = "Invalid employee Id")
	private String employeeId;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Firstname Invalid")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z\\s]{2,}$",message = "Last name Invalid")
	private String lastName;
	
	@Pattern(regexp="Fulltime|Parttime",message="invalid mentor type")
	private String mentorType;
	
	@Pattern(regexp="lead|support",message="invalid role")
	private String mentorRole;
	
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Enter valid mobile number")
	private String mobileNumber;
	
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message ="Enter valid email address")
	private String email;
	
	@Pattern(regexp = "^[0-9]{1,2}$",message = "Invalid experiance years")
	private String experienceYears;
	
	@Pattern(regexp="Morning|Evening",message = "Enter valid preferred time")
	private String preferredTime;
	
	@NotBlank(message = "Startdate cannot be empty")
	private LocalDate startDate;
	
	@Pattern(regexp="Married|single",message = "Enter valid status")
	private String status;
	
	@NotBlank(message = "MentorDescription cannot be empty")
	private String mentorDescription;
	
	@NotBlank(message = "ProfileImageURL cannot be empty")
	private String profileImageURL;
	
	@NotBlank(message = "CreatorUser cannot be empty")
	private int creatorUser;
	
	private long supervisorId;
	
	private LocalDateTime createdTimeStamp;
	
	private LocalDateTime updatedTimeStamp;
}

