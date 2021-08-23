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
	
	@GetMapping("getbycategory")
	public DataResult<List<Item>> getByCategori(@RequestParam int cat1Id, @RequestParam int pageNo, @RequestParam int pageSize) {
		return this.itemService.getCategory1Id(cat1Id, pageNo, pageSize);
	}
	
	@GetMapping("getallcategory1Id")
	public DataResult<List<Item>> getAllCategory1Id(int cat1Id) {
		return this.itemService.getAllCategory1Id(cat1Id);
	}
	
	@GetMapping("getbyid")
	public DataResult<Item> getById(int id) {
		return this.itemService.getById(id);
	}
	
	@GetMapping("getbyitemname")
	public DataResult<List<Item>> getByItemName(@RequestParam String itemName) {
		return this.itemService.getByItemName(itemName);
	}
	
	@GetMapping("getbyitemnamepageable")
	public DataResult<List<Item>> getByItemNamePageable(@RequestParam String itemName, @RequestParam int pageNo, @RequestParam int pageSize) {
		return this.itemService.getByItemNamePageable(itemName, pageNo, pageSize);
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
