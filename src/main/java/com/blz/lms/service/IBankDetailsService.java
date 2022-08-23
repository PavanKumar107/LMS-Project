package com.blz.lms.service;
import java.util.List;
import com.blz.lms.dto.BankDetailsDTO;
import com.blz.lms.model.BankDetailsModel;

public interface IBankDetailsService {

	BankDetailsModel addBankDetails(BankDetailsDTO bankDetailsDTO,String token,Long adminId);

	BankDetailsModel updateBankDetails(BankDetailsDTO bankDetailsDTO,Long id,String token, Long adminId);

	List<BankDetailsModel> getAllBankDetails(String token);

	BankDetailsModel deleteBankDetails(Long id,String token);

}
