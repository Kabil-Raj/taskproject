package com.project.test.employeeDetailsController.services;

import java.util.Date;

public class EmployeeDetailsControllerService {

	public String createRandomEmployeeName(int employeeNameLength) {
		int decimalValueOfLetterA = 97;
		String randomString = "";
		for (int i = 0; i < employeeNameLength; i++) {
			// Need random value between 0 to 25
			// adding 97 with the random value so that a character between 97 to 122 will be
			// obtained
			int decimalValueOfCharacter = decimalValueOfLetterA + (int) (Math.random() * 26);
			randomString = randomString + (char) (decimalValueOfCharacter);
		}
		return randomString;
	}

	public Date createRandomDate(String setStartDateInMilliSeconds, String setEndDateInMilliSeconds) {
		String excludingLastSixZerosInStartDate = setStartDateInMilliSeconds.substring(0, 7);
		String excludingLastSixZerosInEndDate = setEndDateInMilliSeconds.substring(0, 7);

//	converting string to integer to get the difference between start and end date
		int startDateInMilliSeconds = Integer.parseInt(excludingLastSixZerosInStartDate);
		int endDateInMilliSeconds = Integer.parseInt(excludingLastSixZerosInEndDate);
		int differenceBetweenStartAndEndDate = endDateInMilliSeconds - startDateInMilliSeconds;

//	fetching first two character to get same year
//	fetching character from 2nd to 6th position to get date after the start date
		String firstTwoCharactersFromStartDate = excludingLastSixZerosInStartDate.substring(0, 2);
		String characterFromSecondToSixthInStartDate = excludingLastSixZerosInStartDate.substring(2, 7);
		int toGetDateAfterStartDate = Integer.parseInt(characterFromSecondToSixthInStartDate);

//	generating random between 1 and difference between start and end date
//	adding the random value to the integer "toGetDateAfterStartDate" to get the date after the start date
		double randomMilliSecondsAfterStartDate = toGetDateAfterStartDate
				+ (Math.random() * differenceBetweenStartAndEndDate + 1);
		int milliSecondsInInteger = (int) (randomMilliSecondsAfterStartDate);
		String randomDateAndTimeAfterStartDate = firstTwoCharactersFromStartDate + milliSecondsInInteger + "000000";
		long dateAndTimeInMilliSeconds = Long.parseLong(randomDateAndTimeAfterStartDate);
		Date dateAfterStartDate = new Date(dateAndTimeInMilliSeconds);
		return dateAfterStartDate;
	}

	public int createEmployeeID(int employeeIdlength) {
		int employeeId = 0;
		String employeeIdInString = "";
		for ( int i = 0; i < employeeIdlength; i++) {
			int employeeID = (int) (Math.random() * employeeIdlength + 1);
			employeeIdInString =  employeeIdInString + employeeID;
		}
		employeeId = Integer.parseInt(employeeIdInString);
		return employeeId;
	}

	public String createRandomDepartment(String[] employeeDepartment) {
		int randomEmployeeDepartmentNumber = (int) (Math.random() * employeeDepartment.length);
		return employeeDepartment[randomEmployeeDepartmentNumber];
	}

	public String createRandomPlace(String[] employeePlace) {
		int randomPlace = (int) (Math.random() * employeePlace.length);
		return employeePlace[randomPlace];
	}

}
