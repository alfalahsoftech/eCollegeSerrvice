package com.fadsan.commom.dtotoentityconvertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fadsan.model.City;
import com.fadsan.model.Country;
import com.fadsan.model.State;
import com.fadsan.model.Students;
import com.fadsan.model.User;
import com.fadsan.models.dto.StudentDTO;

public class StudentAdmissionDTOToEntity {
	private static final StudentAdmissionDTOToEntity studentadmissionDTOToEntity = new StudentAdmissionDTOToEntity();

	public static final StudentAdmissionDTOToEntity getInstance() {
		return studentadmissionDTOToEntity;
	}

	public Students convertStudentAdmissionFromDtoToEntity(
			StudentDTO studentDTO, User user) throws ParseException
	 {
		Date date = new Date();
		java.sql.Date date3 = new java.sql.Date(date.getTime());
		Students students = new Students();
		students.setActive(true);
		students.setId(studentDTO.getAdmissionNo());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		students.setAdmissionDate(dateFormat.parse(studentDTO
				.getAdmissionDate()));
		students.setFirstName(studentDTO.getFirstName());
		students.setMiddleName(studentDTO.getMiddleName());
		students.setLastName(studentDTO.getLastName());
		students.setDateOfBirth(dateFormat.parse(studentDTO.getDateOfBirth()));
		students.setAddressLine1(studentDTO.getAddressLine1());
		//StudentClass studentClass = new StudentClass();
		City city = new City();
		city.setId(studentDTO.getCityId());
		students.setCity(city);
		Country country = new Country();
		country.setId(studentDTO.getCountryId());
		students.setCountry(country);
		/*Section section=new Section();
		section.setSectionId(sectionId);*/
		students.setCreatedAt(date3);
		students.setEmail(studentDTO.getEmail());
		students.setFatherName(studentDTO.getFatherName());
		students.setGender(studentDTO.getGender());
		students.setMobile(studentDTO.getMobile());
		students.setMotherName(studentDTO.getMotherName());
		students.setNationality(studentDTO.getNationality());
		students.setPhone(studentDTO.getPhone());
		students.setPinCode(studentDTO.getPinCode());
		students.setReligion(studentDTO.getReligionName());
		State state = new State();
		state.setId(studentDTO.getStateId());
		students.setState(state);
		students.setUpdatedAt(date3);
		students.setGuardianName(studentDTO.getGuardianName());
		return students;
	}
}
