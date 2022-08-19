package com.blz.lms.dto;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AdminDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String emailId;
	private String profilePath;
	private boolean status;
	private String password;
	private LocalDateTime creatorStamp = LocalDateTime.now();
	private LocalDateTime updatedStamp;
}
