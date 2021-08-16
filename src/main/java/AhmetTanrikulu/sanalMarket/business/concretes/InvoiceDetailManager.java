package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.InvoiceDetailService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.InvoiceDetailDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.InvoiceDetail;

@Service
public class InvoiceDetailManager implements InvoiceDetailService{
	
	private InvoiceDetailDao invoiceDetailDao;

	public InvoiceDetailManager(InvoiceDetailDao invoiceDetailDao) {
		super();
		this.invoiceDetailDao = invoiceDetailDao;
	}

	@Override
	public DataResult<InvoiceDetail> getByInvoiceId(int invoiceId) {
		return new SuccessDataResult<InvoiceDetail>(this.invoiceDetailDao.getByInvoiceId(invoiceId));
	}

	@Override
	public DataResult<InvoiceDetail> getByOrderDetailId(int orderDetailId) {
		return new SuccessDataResult<InvoiceDetail>(this.invoiceDetailDao.getByOrderDetailId(orderDetailId));
	}

	@Override
	public DataResult<InvoiceDetail> getByItemId(int itemId) {
		return new SuccessDataResult<InvoiceDetail>(this.invoiceDetailDao.getByItemId(itemId));
	}

}
