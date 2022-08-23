package com.blz.lms.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blz.lms.dto.TechStackDTO;
import com.blz.lms.model.TechStackModel;
import com.blz.lms.service.ITechStackService;

/**
 * Purpose: Techstack controller to process Techstack Data APIs.
 * @version: 4.15.1.RELEASE
 * @author: Pavan Kumar G V  
 */
@RestController
@RequestMapping("/techstack")
public class TechStackController {
	
	@Autowired
	ITechStackService techStackService;
	
	/**
	 * Purpose: To create TechStack data 
	 * @Param: techStackDTO, token and id
	 */
	@PostMapping("/addtechstack")
	public TechStackModel addtechstack(@Valid@RequestBody TechStackDTO techStackDTO,@RequestHeader String token,@RequestParam List<Long> id) {
		return techStackService.addtechstack(techStackDTO, token, id);
	}
	
	/**
	 * Purpose: To update TechStack details by id
	 * @Param: techStackDTO, token and id
	 */
	@PutMapping("/updatetechstack/{id}")
	public TechStackModel updateTechstack(@RequestBody TechStackDTO techStackDTO,@PathVariable Long id,@RequestHeader String token) {
		return techStackService.updateTechstack(techStackDTO, id, token);	
	}
	
	/**
	 * Purpose: To get all TechStack data 
	 * @Param: token
	 */
	@GetMapping("/getalltechstack")
	public List<TechStackModel> getAllTechStack(@RequestHeader String token) {
		return techStackService.getAllTechStack(token);
	}
	
	/**
	 * Purpose: To delete TechStack data by id
	 * @Param: id and token
	 */
	@DeleteMapping("deletetechstack/{id}")
	public TechStackModel deleteTechStack(@PathVariable Long id,@RequestHeader String token) {
		return techStackService.deleteTechStack(id, token);
	}
}
