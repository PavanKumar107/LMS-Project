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
import com.blz.lms.dto.BankDetailsDTO;
import com.blz.lms.model.BankDetailsModel;
import com.blz.lms.service.IBankDetailsService;

/**
 * Purpose: BankDetails controller to process BankDetails Data APIs.
 * @version: 4.15.1.RELEASE
 * @author: Pavan Kumar G V  
 */
@RestController
@RequestMapping("bankdetails")
public class BankDetailsController {

	@Autowired
	IBankDetailsService bankDetailsService;

	/**
	 * Purpose: To Create Bankdetails
	 * @Param: bankDetailsDTO, token and adminId
	 */
	@PostMapping("/addbankdetais")
	public BankDetailsModel addBankDetails(@Valid@RequestBody BankDetailsDTO bankDetailsDTO,@RequestHeader String token,@RequestParam Long adminId) {
		return bankDetailsService.addBankDetails(bankDetailsDTO, token, adminId);	
	}


	/**
	 * Purpose: To Update Bankdetails by id
	 * @Param: bankDetailsDTO, id, token and adminId
	 */
	@PutMapping("/updatebankdetails/{id}")
	public BankDetailsModel updateBankDetails(@Valid@RequestBody BankDetailsDTO bankDetailsDTO,@PathVariable Long id,@RequestHeader String token,@RequestParam Long adminId) {
		return bankDetailsService.updateBankDetails(bankDetailsDTO, id, token,adminId);
	}

	/**
	 * Purpose: To get all Bankdetails 
	 * @Param: token
	 */
	@GetMapping("/getallbankdetails")
	public List<BankDetailsModel> getAllBankDetails(@RequestHeader String token) {
		return bankDetailsService.getAllBankDetails(token);
	}

	/**
	 * Purpose: To delete Bankdetails by id 
	 * @Param: id and token
	 */
	@DeleteMapping("/deletebankdetals/{id}")
	public BankDetailsModel deleteBankDetails(@PathVariable Long id,@RequestHeader String token) {
		return bankDetailsService.deleteBankDetails(id, token);
	}
}
