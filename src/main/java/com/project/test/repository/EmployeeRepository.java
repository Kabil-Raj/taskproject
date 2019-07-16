package com.project.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.test.model.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {
	
	
	@Query(nativeQuery = true, value = "select * from employeedetails limit ?1,?2")
	List<EmployeeDetails> findEmployeeDetailsByLimit(int offset, int count);
	
	
	@Query(nativeQuery = true,value = "select * from employeedetails where employee_date_of_joining between ?1 and ?2 order by employee_date_of_joining asc")
	List<EmployeeDetails> findEmployeeDetailsBetweenDate(String startDate, String endDate);
}
