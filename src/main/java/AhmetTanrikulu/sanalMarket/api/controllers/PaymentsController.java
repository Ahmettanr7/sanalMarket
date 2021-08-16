package AhmetTanrikulu.sanalMarket.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.PaymentService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Payment;
@RestController
@RequestMapping("/api/payments/")
@CrossOrigin
public class PaymentsController {
	
	private PaymentService paymentService;

	public PaymentsController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@GetMapping("getbyorderid")
	public DataResult<Payment> getByOrderId(int orderId) {
		return this.paymentService.getByOrderId(orderId);
	}
	
	

}
