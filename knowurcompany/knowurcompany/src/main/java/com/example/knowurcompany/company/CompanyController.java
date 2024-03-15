package com.example.knowurcompany.company;

import com.example.knowurcompany.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {


    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
       try{
           companyService.addCompany(company);
           return new ResponseEntity<>("Company Added",HttpStatus.OK);
       }
       catch(Exception e){
            return new ResponseEntity<>("Object Addition Failed",HttpStatus.FORBIDDEN);
       }


    }

    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        return ResponseEntity.ok(companyService.findCompany(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String>  deleteCompany(@PathVariable Long id){
        try{
            companyService.deleteCompany(id);
            return new ResponseEntity<>("The company has been deleted",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Deletion failed",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        try{
            companyService.updateCompany(id,company);
            return new ResponseEntity<>("Company detail with id "+id+" has been updated",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Company couldn't be found",HttpStatus.NOT_FOUND);
        }
    }




}
