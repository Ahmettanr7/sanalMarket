package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.InvoiceDetail;

public interface InvoiceDetailService {

	DataResult<InvoiceDetail> getByInvoiceId (int invoiceId);
	
	DataResult<InvoiceDetail> getByOrderDetailId(int orderDetailId);
	
	DataResult<InvoiceDetail> getByItemId(int itemId);
}
