package AhmetTanrikulu.sanalMarket.business.abstracts;


import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.User;

public interface UserService {

	DataResult<User> getByEmail (String email);
	
	DataResult<User> getById (int id);
	
	DataResult<User> getByUserName (String userName);
}
