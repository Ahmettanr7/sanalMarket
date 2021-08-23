package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.CartService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.ErrorDataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Cart;
import AhmetTanrikulu.sanalMarket.entities.dtos.CartDto;
@RestController
@RequestMapping("/api/carts/")
@CrossOrigin
public class CartsController {
	
	private CartService cartService;

	public CartsController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	
	@GetMapping("getbyuserid")
	public DataResult<List<Cart>> getByUserId(int userId){
		return this.cartService.getAllByUserId(userId);
	}
	
	@GetMapping("getactivecartitems")
	public DataResult<List<CartDto>> getActiveCartItems(@RequestParam int userId){
		return this.cartService.getActiveCartItem(userId);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody Cart cart) {
		return ResponseEntity.ok(this.cartService.add(cart));
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> deleteById(@RequestParam int id) {
		return ResponseEntity.ok(this.cartService.delete(id));
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
