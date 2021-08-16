package AhmetTanrikulu.sanalMarket.business.abstracts;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.Payment;

public interface PaymentService {
	
	DataResult<Payment> getByOrderId (int orderId);

}
