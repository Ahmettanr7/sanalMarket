package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Invoice;

public interface InvoiceService {
	
	DataResult<List<Invoice>> getAll();
	
	DataResult<Invoice> getById(int id);
	
	DataResult<Invoice> getByOrderId(int orderId);

}
