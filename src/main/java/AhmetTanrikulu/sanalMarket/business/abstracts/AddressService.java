package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Address;

public interface AddressService {
	
	Result add(Address address);
	
	DataResult<List<Address>> getAllByUserId (int userId);
	
	DataResult<List<Address>> getAll ();

}
