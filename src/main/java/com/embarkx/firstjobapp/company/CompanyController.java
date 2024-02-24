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
    public ResponseEntity<?> getAllCompanies(){
        // ResponseEntity<List<Company>>
        List<Company> companies = companyService.getAllCompanies();
        if(companies.isEmpty()){
            ErrorResponse errorResponse = new ErrorResponse("No companies are present. ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }else{
            return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
        }
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){

        boolean check=companyService.updateCompany(company,id);
        if(check) {
            return new ResponseEntity<>("Company Updated Successfully of ID: " + id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Company with ID: "+id+" is not present. ",HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<?> getCompany(@PathVariable Long id){
        // ResponseEntity<Company>
        Company company=companyService.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }else{
            ErrorResponse errorResponse = new ErrorResponse("There is no Company present with ID: "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
