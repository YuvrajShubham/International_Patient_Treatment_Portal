package com.cts.mfpe.controller;

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

import com.cts.mfpe.exception.AuthorizationException;
import com.cts.mfpe.exception.IPTreatmentPackageNotFoundException;
import com.cts.mfpe.feign.AuthorisingClient;
import com.cts.mfpe.model.AilmentCategory;
import com.cts.mfpe.model.IPTreatmentPackage;
import com.cts.mfpe.model.SpecialistDetail;
import com.cts.mfpe.service.IPTreatmentOfferingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class IPTreatmentOfferingController {

	@Autowired
	private IPTreatmentOfferingService ipOfferingService;

	@Autowired
	private AuthorisingClient authorisingClient;

	
	@GetMapping("/ipTreatmentPackages")
	public List<IPTreatmentPackage> getAllIPTreatmentPackage(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException {
		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) {
			return ipOfferingService.findAllIPTreatmentPackages();
		} else {
			throw new AuthorizationException("Not allowed");
		}

	}

	
	@GetMapping("/ipTreatmentPackageByNameOnlyOne/{ailment}/{packageName}")
	@ApiOperation(notes = "Returns the IP Treatment Package based on package name", value = "Find IP Treatment Package by name")
	public IPTreatmentPackage getIPTreatmentPackageByNameOnlyOne (
			@ApiParam(name = "ailment", value = "ailment of the package") @PathVariable AilmentCategory ailment,
			@ApiParam(name = "packageName", value = "name of the package") @PathVariable String packageName,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException, IPTreatmentPackageNotFoundException {

		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) {
			return ipOfferingService.findIPTreatmentPackageByNameOnlyOne(ailment, packageName);
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	
	@GetMapping("/ipTreatmentPackageByName/{ailment}/{packageName}")
	@ApiOperation(notes = "Returns the IP Treatment Packages based on package names", value = "Find IP Treatment Package by name")
	public List<IPTreatmentPackage> getIPTreatmentPackageByName(
			@ApiParam(name = "ailment", value = "ailment of the package") @PathVariable AilmentCategory ailment,
			@ApiParam(name = "packageName", value = "name of the package") @PathVariable String packageName,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException, IPTreatmentPackageNotFoundException {

		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) {
			return ipOfferingService.findIPTreatmentPackageByName(ailment, packageName);
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}

	
	@GetMapping("/specialists")
	@ApiOperation(notes = "Returns the list of specialists along with their experience and contact details", value = "Find specialists")
	public List<SpecialistDetail> getAllSpecialist(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException {
		System.out.println("Inside ================"+requestTokenHeader);
		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) {
			return ipOfferingService.findAllSpecialists();
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	@GetMapping("/specialistsByExpertsise/{areaOfExpertise}")
	public List<SpecialistDetail> getSpecialistByExpertise(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@ApiParam(name = "areaOfExpertise", value = "areaOfExpertise of the specialist") @PathVariable AilmentCategory areaOfExpertise) throws AuthorizationException, IPTreatmentPackageNotFoundException {
		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) {
			return ipOfferingService.findAllSpecialistsByExpertise(areaOfExpertise);
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}
	
	/////////////////////////////////////////////////////////
	// Admin Only
	@SuppressWarnings("finally")
	@DeleteMapping("/deleteSpecialist/{specialistId}")
	public ResponseEntity<String> deleteSpecialist(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@ApiParam(name = "specialistId", value = "id of the specialist") @PathVariable int specialistId) throws AuthorizationException{
		ResponseEntity<String> response = null;
		try {
			if (authorisingClient.authorizeTheRequestIfAdmin(requestTokenHeader)) {
				ipOfferingService.deleteSpecialist(specialistId);
				response = new ResponseEntity<>("Deleted Succesfully", HttpStatus.OK);
			} else {
				throw new AuthorizationException("Not allowed");
			}
		}catch(AuthorizationException ae) {
			System.out.println(ae.getMessage());
			response = new ResponseEntity<String>("Not Authorized Access", HttpStatus.UNAUTHORIZED);
		}finally {
			return response;
		}
	}
	
	//--------------------------------------------------------
	@SuppressWarnings("finally")
	// Admin Only
	// addSpecialist endpoint : it will add the specialist details in the database and return the status of the action as ResponseEntity
	@PostMapping(path = "/addSpecialist")
	public ResponseEntity<String> addSpecialist(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody SpecialistDetail specialistDetail)	// for taking json request body from other microservice
					{
		ResponseEntity<String> response = null;
		try {
				if (authorisingClient.authorizeTheRequestIfAdmin(requestTokenHeader)) {	//authorization part
					// write your code
					if(ipOfferingService.addSpecialist(specialistDetail)) {
						System.out.println("Specialist Added");
						response = new ResponseEntity<String>("Added : "+specialistDetail, HttpStatus.OK);
					}
				} 
				else {
					throw new AuthorizationException("Not allowed");
				}
		}catch(AuthorizationException ae) {
			System.out.println(ae.getMessage());
			response = new ResponseEntity<String>("Not Authorized Access", HttpStatus.UNAUTHORIZED);
		}finally {
			return response;
		}
	}
	
	
	
	
	@GetMapping("/countPid/{pid}")
	public boolean countPid(@PathVariable int pid) {
		System.out.println(pid);
		return ipOfferingService.countById(pid);
	}
	
	
}
