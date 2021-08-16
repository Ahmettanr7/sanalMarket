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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.ItemService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.ErrorDataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Item;

@RestController
@RequestMapping("/api/items/")
@CrossOrigin
public class ItemsController {
	
	private ItemService itemService;

	public ItemsController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Item item) {
		return ResponseEntity.ok(this.itemService.add(item));
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> deleteByEducationId(@RequestParam int itemId) {
		return ResponseEntity.ok(this.itemService.deleteByItemId(itemId));
	}
	
	@GetMapping("getbycategori")
	public DataResult<List<Item>> getByCategori(int cat1Id) {
		return this.itemService.getCategory1Id(cat1Id);
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