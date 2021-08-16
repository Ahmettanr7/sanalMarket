package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("getall")
	public DataResult<List<Category1>> getAll(){
		return this.category1Service.getAll();
	}

}
