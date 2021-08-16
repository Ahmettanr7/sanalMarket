package AhmetTanrikulu.sanalMarket.business.concretes;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.PaymentService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.PaymentDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Payment;

@Service
public class PaymentManager implements PaymentService{
	
	private PaymentDao paymentDao;

	public PaymentManager(PaymentDao paymentDao) {
		super();
		this.paymentDao = paymentDao;
	}

	@Override
	public DataResult<Payment> getByOrderId(int orderId) {
		return new SuccessDataResult<Payment>(this.paymentDao.getByOrderId(orderId));
	}

}
