package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.Category1Service;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Category1;

@RestController
@RequestMapping("/api/categories/")
@CrossOrigin
public class CategoriesController {
	
	private Category1Service category1Service;

	public CategoriesController(Category1Service category1Service) {
		super();
		this.category1Service = category1Service;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Category1 category1) {
		return ResponseEntity.ok(this.category1Service.add(category1));
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> deleteById(int id) {
		return ResponseEntity.ok(this.category1Service.delete(id));
	}
	
	@GetMapping("getall")
	public DataResult<List<Category1>> getAll(){
		return this.category1Service.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<Category1> getById(int id){
		return this.category1Service.getById(id);
	}

}
