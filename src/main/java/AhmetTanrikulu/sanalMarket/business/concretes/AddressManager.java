package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.AddressService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.AddressDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Address;

@Service
public class AddressManager implements AddressService{
	
	private AddressDao addressDao;
	
	

	public AddressManager(AddressDao addressDao) {
		super();
		this.addressDao = addressDao;
	}

	@Override
	public Result add(Address address) {
		this.addressDao.save(address);
		return new SuccessResult("Adres ekleme işlemi başarılı");
	}

	@Override
	public DataResult<List<Address>> getAllByUserId(int userId) {
		return new SuccessDataResult<List<Address>>(this.addressDao.getAllByUserId(userId),"Kullanıcıya ait adresler getirildi");
	}

	@Override
	public DataResult<List<Address>> getAll() {
		return new SuccessDataResult<List<Address>>(this.addressDao.findAll(),"Bütün adresler getirildi");
	}

}
