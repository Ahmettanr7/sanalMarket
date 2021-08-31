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

import AhmetTanrikulu.sanalMarket.business.abstracts.OrderService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Order;

@RestController
@RequestMapping("/api/orders/")
@CrossOrigin
public class OrdersController {

	private OrderService orderService;

	public OrdersController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Order order) {
		return ResponseEntity.ok(this.orderService.add(order));
	}
	
	@PostMapping("wasdelivered")
	public ResponseEntity<?> wasDelivered(int id) {
		return ResponseEntity.ok(this.orderService.wasDelivered(id));
	}
	
	@GetMapping("getbyuserid")
	public DataResult<List<Order>> getByUserId(int userId) {
		return this.orderService.getByUserId(userId);
	}
	
	@GetMapping("getbyisdeliveredistrue")
	public DataResult<List<Order>> getByIsDeliveredIsTrue() {
		return this.orderService.getByIsDeliveredIsTrue();
	}
	
	@GetMapping("getbyisdeliveredisfalse")
	public DataResult<List<Order>> getByIsDeliveredIsFalse() {
		return this.orderService.getByIsDeliveredIsFalse();
	}
	
	@GetMapping("getbyid")
	public DataResult<Order> getById(int id) {
		return this.orderService.getById(id);
	}
}
