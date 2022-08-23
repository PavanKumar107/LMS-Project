package com.blz.lms.dto;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class HiringCandidateDTO {
	@NotBlank(message = "cisid cannot be empty")
	private String cicId;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Fullname Invalid")
	private String fullName;

	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message ="Enter valid email address")
	private String email;

	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Enter valid mobile number")
	private String mobileNum;

	@NotBlank(message = "Hiring date cannot be empty")
	private String hiredDate;

	@Pattern(regexp="Bsc|Bcom|BE|Btech|Mtech|Msc",message="invalid degree")
	private String degree;

	@NotBlank(message = "Aggrpercentage cannot be empty")
	private Double aggrPer;

	@Pattern(regexp = "^[A-Z]{1,}[a-z]{3,}$", message = "City name should start with uppercase and having atleast 4 characters!")
	private String city;

	@Pattern(regexp = "^[A-Z]{1,}[a-z]{1,}$", message = "State name should start with uppercase and having atleast 2 characters!")
	private String state;

	@Pattern(regexp = "^[A-Z]{1,}[a-z]{2,}$", message = "Job Location name should start with uppercase and having atleast 3 characters!")
	private String JobLocation;

	@NotBlank(message = "Passed out year cannot be empty")
	private String passedOutYear;

	@NotBlank(message = "Creater user cannot be empty")
	private String creatorUser;

	@Pattern(regexp="Married|Single",message="invalid candidate status")
	private String candidateStatus;

	private LocalDateTime creationTimeStamp;

	private LocalDateTime updatedTimeStamp;
}
