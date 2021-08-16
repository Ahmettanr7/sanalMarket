package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.InvoiceService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.InvoiceDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Invoice;

@Service
public class InvoiceManager implements InvoiceService{
	
	private InvoiceDao invoiceDao;

	public InvoiceManager(InvoiceDao invoiceDao) {
		super();
		this.invoiceDao = invoiceDao;
	}

	@Override
	public DataResult<List<Invoice>> getAll() {
		return new SuccessDataResult<List<Invoice>>(this.invoiceDao.findAll(),"Faturaların Hepsini Getirme İşlemi Başarılı");
	}

	@Override
	public DataResult<Invoice> getById(int id) {
		return new SuccessDataResult<Invoice>(this.invoiceDao.getById(id),"Fatura Getirme İşlemi Başarılı");
	}

	@Override
	public DataResult<Invoice> getByOrderId(int orderId) {
		return new SuccessDataResult<Invoice>(this.invoiceDao.getByOrderId(orderId),"Sipariş Numarasına Göre Fatura Getirme İşlemi Başarılı");
	}

}
