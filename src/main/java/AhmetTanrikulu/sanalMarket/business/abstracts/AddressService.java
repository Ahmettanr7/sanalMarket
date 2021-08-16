package AhmetTanrikulu.sanalMarket.business.abstracts;

import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Address;

public interface AddressService {
	
	Result add(Address address);

}
