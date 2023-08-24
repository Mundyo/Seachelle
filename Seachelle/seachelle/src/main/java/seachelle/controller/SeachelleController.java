package seachelle.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import seachelle.controller.model.SeachelleData;
import seachelle.controller.model.SeachelleData.SeachelleCustomer;
import seachelle.controller.model.SeachelleData.SeachelleEmployee;
import seachelle.service.SeachelleService;

@RestController
@RequestMapping("/seachelle")
@Slf4j
public class SeachelleController {

	@Autowired
	private SeachelleService seachelleService;
	
	@PostMapping("/Seachelle")
	@ResponseStatus(code = HttpStatus.CREATED)
	public  SeachelleData insertSeachelle(@RequestBody SeachelleData seachelleData) {
	   log.info("Creating a seachelle store {}", seachelleData);
	   return seachelleService.saveSeachelle(seachelleData);
	}
	
	@PutMapping("/{seachelleId}")
	public SeachelleData updateSeachelle(@PathVariable Long seachelleId,
			@RequestBody SeachelleData seachelleData) {
		seachelleData.setSeachelleId(seachelleId);
		log.info("Updating seachelle store {}", seachelleData);
		return seachelleService.saveSeachelle(seachelleData);
	}
	
	@PostMapping("/{seachelleId}/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public SeachelleEmployee addEmployeeToSeachelle(@PathVariable Long seachelleId,
		@RequestBody SeachelleEmployee seachelleEmployee) {
	  log.info("Adding employee {} to seachelle store with ID={}", seachelleEmployee,
			  seachelleId);	
	  
	  return seachelleService.saveEmployee(seachelleId, seachelleEmployee);
	}
	
	@PostMapping("/{seachelleId}/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public SeachelleCustomer addCustomerToSeachelle(@PathVariable Long seachelleId,
			@RequestBody SeachelleCustomer seachelleCustomer) {
		  log.info("Adding customer {} to seachelle store with ID={}", seachelleCustomer,
				  seachelleId);	
		  
		  return seachelleService.saveCustomer(seachelleId, seachelleCustomer); 
	}
	
	@GetMapping
	public List<SeachelleData> retrieveAllSeachelles(){
		log.info("Retrieving all seachelle stores");
		return seachelleService.retrieveAllSeachelles();
	}
	
	@GetMapping("/{seachelleId}")
	public SeachelleData retrieveSeachelleById(@PathVariable Long seachelleId) {
		log.info("Retrieving seachelle with Id={}", seachelleId);
		return seachelleService.retrieveSeachelleById(seachelleId);
	}
	
	public Map<String, String> deleteSeachelleById(@PathVariable Long seachelleId){
		log.info("Deleting seachelle with Id={}", seachelleId);
		
		seachelleService.deleteSeachelleById(seachelleId);
		
		return Map.of("message", "Seachelle store with Id=" + seachelleId + "delete.");
	}
	
	}
