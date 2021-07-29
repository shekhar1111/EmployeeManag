package com.EmployeeManag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManag.entity.Employee;
import com.EmployeeManag.service.EmployeeServiceInterface;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeserviceinterface;
	
	
	@PostMapping("/addemployee")
	public ResponseEntity addEmployee(@RequestBody Employee employee, @RequestHeader(value="Authorization") String authorization){
		
		
		if(validate(authorization)==false) {
	 		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access "+authorization);
	 		}
	 		else { 			
	 			return ResponseEntity.status(HttpStatus.OK).body(this.employeeserviceinterface.addEmployee(employee));
	 		}		
	}
	

	@GetMapping("/getemployees")
	public ResponseEntity  getEmployees(@RequestHeader(value="Authorization") String authorization){
		if(validate(authorization)==false) {
	 		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access "+authorization);
	 		}
	 		else { 			
	 			return ResponseEntity.status(HttpStatus.OK).body(this.employeeserviceinterface.getEmployees());
	 		}		
	}
	
	@GetMapping("/getemployee/{id}")
	public ResponseEntity getEmployee(@PathVariable("id") int id, @RequestHeader(value="Authorization") String authorization) {
		if(validate(authorization)==false) {
	 		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access "+authorization);
	 		}
	 		else { 			
	 			return ResponseEntity.status(HttpStatus.OK).body(this.employeeserviceinterface.getEmployee(id));
	 		}			}
	
	@PutMapping("/editemployee")
	public ResponseEntity editEmployee(@RequestBody Employee employee, @RequestHeader(value="Authorization") String authorization) {
		if(validate(authorization)==false) {
	 		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access "+authorization);
	 		}
	 		else { 			
	 			return ResponseEntity.status(HttpStatus.OK).body(this.employeeserviceinterface.editEmployee(employee));
	 		}		
	}

		
		
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity deleteEmployee(@PathVariable("id") int id,  @RequestHeader(value="Authorization") String authorization) {
		if(validate(authorization)==false) {
	 		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access "+authorization);
	 		}
	 		else { 			
	 			return ResponseEntity.status(HttpStatus.OK).body(this.employeeserviceinterface.deleteEmployee(id));
	 		}		
	}
	
	
	
	public boolean validate(String authorization) {
        
        String[] authorize = authorization.split(" ");
        if(authorize[1].equals("myauthcode")) {
            return true;
        }
        return false;        
    }

}
