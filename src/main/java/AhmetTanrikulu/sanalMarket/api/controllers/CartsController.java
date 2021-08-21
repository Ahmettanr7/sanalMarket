package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.CartService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Cart;

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
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody Cart cart) {
		return ResponseEntity.ok(this.cartService.add(cart));
	}
	
	@PostMapping("delete")
	public ResponseEntity<?> deleteById(@RequestParam int id) {
		return ResponseEntity.ok(this.cartService.delete(id));
	}

}
