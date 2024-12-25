package com.smartforce.payroll.api.Repository;

import com.smartforce.payroll.api.Model.Payroll;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PayrollRepository extends MongoRepository<Payroll, String> {

    List<Payroll> findByPin(String pin);
    List<Payroll> findByMonth(String month);

    List<Payroll> findByMonthAndYear(String month, String year);
}
