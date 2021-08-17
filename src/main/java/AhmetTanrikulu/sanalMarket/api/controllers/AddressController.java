package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.AddressService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.ErrorDataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Address;

@RestController
@RequestMapping("/api/address/")
@CrossOrigin
public class AddressController {
	
	private AddressService addressService;

	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}

	@GetMapping("getall")
	public DataResult<List<Address>> getAll(){
		return this.addressService.getAll();
	}
	
	@GetMapping("getbyuserid")
	public DataResult<List<Address>> getByUserId(int userId){
		return this.addressService.getAllByUserId(userId);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Address address) {
		return ResponseEntity.ok(this.addressService.add(address));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		 for(FieldError fieldError :  exceptions.getBindingResult().getFieldErrors() ) {
			 validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		 }
		 
		 ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		 return errors;
	}

}
