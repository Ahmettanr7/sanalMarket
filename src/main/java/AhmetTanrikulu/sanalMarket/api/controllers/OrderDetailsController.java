package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.OrderDetailService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.OrderDetail;

@RestController
@RequestMapping("/api/orderdetails/")
@CrossOrigin
public class OrderDetailsController {
	
	private OrderDetailService orderDetailService;

	public OrderDetailsController(OrderDetailService orderDetailService) {
		super();
		this.orderDetailService = orderDetailService;
	}
	
	@GetMapping("getbyorderid")
	public DataResult<OrderDetail> getByOrderId(int orderId) {
		return this.orderDetailService.getByOrderId(orderId);
	}
	
	@GetMapping("getbyitemid")
	public DataResult<List<OrderDetail>> getByItemId(int itemId) {
		return this.orderDetailService.getByItemId(itemId);
	}

}
