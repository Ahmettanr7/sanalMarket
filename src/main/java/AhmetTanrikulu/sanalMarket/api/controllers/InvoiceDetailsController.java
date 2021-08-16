package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.InvoiceDetailService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.InvoiceDetail;

@RestController
@RequestMapping("/api/invoicedetails/")
@CrossOrigin
public class InvoiceDetailsController {
	
	private InvoiceDetailService invoiceDetailService;

	public InvoiceDetailsController(InvoiceDetailService invoiceDetailService) {
		super();
		this.invoiceDetailService = invoiceDetailService;
	}
	
	@GetMapping("getbyinvoice")
	public DataResult<InvoiceDetail> getByInvoiceId(int invoiceId) {
		return this.invoiceDetailService.getByInvoiceId(invoiceId);
	}
	
	@GetMapping("getbyorderdetailid")
	public DataResult<InvoiceDetail> getByOrderDetailId(int orderDetailId) {
		return this.invoiceDetailService.getByOrderDetailId(orderDetailId);
	}
	
	@GetMapping("getbyitem")
	public DataResult<InvoiceDetail> getByItemId(int itemId) {
		return this.invoiceDetailService.getByItemId(itemId);
	}

}
