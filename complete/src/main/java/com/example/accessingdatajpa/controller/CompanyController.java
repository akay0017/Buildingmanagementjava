package com.example.accessingdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatajpa.dto.CompanyDto;
import com.example.accessingdatajpa.enttity.Company;
import com.example.accessingdatajpa.service.CompanyService;

@RestController

public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping(value = "/unsecure/addcompany")
	public Company addCompany(@RequestBody CompanyDto companyDto) {

		return companyService.addCompanyDetails(companyDto);

	}

	@PutMapping(value = "/unsecure/updatecompany")
	public Company updateCompany(@RequestBody CompanyDto companyDto) {

		return companyService.updateCompanyDetails(companyDto);

	}

	@DeleteMapping(value = "/unsecure/deletecompany/{id}")
	public Company deleteCompany(@PathVariable(name = "id") Integer id) {

		return companyService.deleteCompanyDetails(id);

	}

	@GetMapping(value = "/unsecure/getmaximanrent")
	public List<Company> getCompanyDetails() {
		return companyService.getTwoCompaniesWithLargestRent();

	}

}
