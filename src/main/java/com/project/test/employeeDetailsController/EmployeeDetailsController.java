package com.project.test.employeeDetailsController;

import java.io.FileWriter;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.project.test.employeeDetailsController.services.EmployeeDetailsControllerService;
import com.project.test.model.EmployeeDetails;
import com.project.test.repository.EmployeeRepository;

@RestController
public class EmployeeDetailsController {

	int employeeNameLength = 5;
	int employeeIdLength = 5;
//	January 01 2019 00:00:00
	String setStartDateInMilliSeconds = "1546281000000"; 
// 	July 15 2019 00:00:00
	String setEndDateInMilliSeconds = "1563129000000";  
	String[] place = new String[] { "Chennai", "Bangalore", "Hyderabad", "Cochin", "Coimbatore" };
	String[] department = new String[] { "Developer", "HR", "QA", "Tech Lead" };

	@Autowired
	EmployeeRepository employeeRepo;

	@PostMapping("/employeeDetails")
	public void createEmployeeRecord() {
		for (int i = 0; i < 100; i++) {
			EmployeeDetails employeeDetails = new EmployeeDetails();
			EmployeeDetailsControllerService empDetContServ = new EmployeeDetailsControllerService();

			String employeeName = empDetContServ.createRandomEmployeeName(employeeNameLength);
			Date date = empDetContServ.createRandomDate(setStartDateInMilliSeconds, setEndDateInMilliSeconds);
			int employeeId = empDetContServ.createEmployeeID(employeeIdLength);
			String employeeDepartment = empDetContServ.createRandomDepartment(department);
			String employeePlace = empDetContServ.createRandomPlace(place);
			employeeDetails.employeeDetails(employeeName, date, employeeDepartment, employeeId, employeePlace);
			employeeRepo.save(employeeDetails);

		}
	}

	@GetMapping("/employeedetails")
	public List<EmployeeDetails> listEmployeeDetails() {
		createCsvAndJsonFormat(employeeRepo.findAll());
		return employeeRepo.findAll();
	}

	@GetMapping("/limitemployeedetails")
	public List<EmployeeDetails> getLimitedNumberOfEmployeeDetails(@RequestParam int offset, int count) {
		createCsvAndJsonFormat(employeeRepo.findEmployeeDetailsByLimit(offset, count));
		return employeeRepo.findEmployeeDetailsByLimit(offset, count);
	}
	
	@GetMapping("/employeedetailsbetweendate")
	public List<EmployeeDetails> getEmployeeDetailsBetweenDateRange(@RequestParam String startDate, String endDate) {
		createCsvAndJsonFormat(employeeRepo.findEmployeeDetailsBetweenDate(startDate, endDate));
		return employeeRepo.findEmployeeDetailsBetweenDate(startDate, endDate);
	}
	
	public void createCsvAndJsonFormat(List<EmployeeDetails> employeeDetails) {
		Gson createGsonFile = new Gson();
		try {
		    FileWriter csvWriter = new FileWriter("employeedetails.csv");
		    FileWriter jsonWriter = new FileWriter("employeedetails.json");
		    StatefulBeanToCsv<EmployeeDetails> beanToCsv = new StatefulBeanToCsvBuilder<EmployeeDetails>(csvWriter).build();
		    beanToCsv.write(employeeDetails);
		    csvWriter.close();
		    createGsonFile.toJson(employeeDetails, jsonWriter);
		    jsonWriter.close();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	    
	}

}
