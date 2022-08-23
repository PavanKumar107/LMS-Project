package com.blz.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blz.lms.model.BankDetailsModel;

public interface BankDetailsRepository extends JpaRepository<BankDetailsModel, Long> {

}
