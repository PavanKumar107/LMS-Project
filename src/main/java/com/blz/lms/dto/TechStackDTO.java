package com.blz.lms.dto;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import com.blz.lms.model.AdminModel;
import lombok.Data;

@Data
public class TechStackDTO {
	@NotBlank(message = "Imagepath cannot be empty")
	private String imagePath;

	private boolean status;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Techname Invalid")
	private String techName;
}
