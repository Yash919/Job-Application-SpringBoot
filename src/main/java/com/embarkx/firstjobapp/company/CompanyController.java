package com.embarkx.firstjobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){

        companyService.updateCompany(company,id);
        return new ResponseEntity<>("Company Updated Successfully of id: "+String.valueOf(id), HttpStatus.OK);
    }

    @PostMapping("/companies")
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Added Successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted= companyService.deleteCompanyById(id);
        if(isDeleted){
            return new ResponseEntity<>("Company Successfully Deleted of id: "+String.valueOf(id),HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company=companyService.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
