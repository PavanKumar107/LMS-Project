package com.blz.lms.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.blz.lms.dto.TechStackDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(name = "techstack")
@Data
public class TechStackModel {
	@Id
	@GenericGenerator(name = "techstack", strategy = "increment")
	@GeneratedValue(generator = "techstack")
	private long id;
	@JsonIgnore
	private LocalDateTime creatorStamp;
	@OneToMany
	@CollectionTable(name = "teckstackadmin", joinColumns = @JoinColumn(name = "id"))
	private List<AdminModel> creatorUser;
	private String imagePath;
	private boolean status;
	private String techName;

	public TechStackModel() {

	}

	public TechStackModel(TechStackDTO techStackDTO) {
		this.imagePath = techStackDTO.getImagePath();
		this.status = techStackDTO.isStatus();
		this.techName = techStackDTO.getTechName();
	}
}
