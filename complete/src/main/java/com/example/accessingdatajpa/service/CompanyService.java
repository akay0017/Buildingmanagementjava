package com.example.accessingdatajpa.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatajpa.companyrepo.CompanyRepository;
import com.example.accessingdatajpa.dto.CompanyDto;
import com.example.accessingdatajpa.enttity.Company;
import com.example.accessingdatajpa.util.Const;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	public Company addCompanyDetails(CompanyDto companyDto) {
		Company comp = new Company();
		comp.setCompanyName(companyDto.getCompanyName());
		comp.setAddress(companyDto.getAddress());
		comp.setContact(companyDto.getContact());
		comp.setEmail(companyDto.getEmail());
		comp.setRent(companyDto.getRent());
		comp.setIsActive(companyDto.getIsActive());
		return companyRepository.save(comp);
	}

	public Company updateCompanyDetails(CompanyDto companyDto) {
		Optional<Company> comp = companyRepository.findOneById(companyDto.getid());
		if (comp.isPresent()) {
			comp.get().setCompanyName(companyDto.getCompanyName());
			comp.get().setAddress(companyDto.getAddress());
			comp.get().setContact(companyDto.getContact());
			comp.get().setEmail(companyDto.getEmail());
			comp.get().setRent(companyDto.getRent());
			comp.get().setIsActive(companyDto.getIsActive());
			return companyRepository.save(comp.get());
		}
		return null;

	}

	public Company deleteCompanyDetails(Integer id) {
		Optional<Company> comp = companyRepository.findOneById(id);
		if (comp.isPresent()) {
			comp.get().setIsActive(Const.N.toString());
			return companyRepository.save(comp.get());
		}
		return null;
	}

	public List<Company> getTwoCompaniesWithLargestRent() {
		List<Company> company = companyRepository.findAllByIsActive(Const.Y.toString());
		company.sort(Comparator.comparingInt(Company::getRent).reversed());
		return company.subList(0, 2);
	}

}
