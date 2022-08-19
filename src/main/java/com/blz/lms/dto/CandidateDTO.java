package com.blz.lms.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class CandidateDTO {
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
}
