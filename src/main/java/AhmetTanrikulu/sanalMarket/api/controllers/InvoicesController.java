package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.InvoiceService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Invoice;

@RestController
@RequestMapping("/api/invoices/")
@CrossOrigin
public class InvoicesController {
	
	private InvoiceService invoiceService;

	public InvoicesController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Invoice>> getAll() {
		return this.invoiceService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<Invoice> getById(int id) {
		return this.invoiceService.getById(id);
	}
	
	@GetMapping("getbyorderid")
	public DataResult<Invoice> getByOrderId( int orderId) {
		return this.invoiceService.getByOrderId(orderId);
	}

}
