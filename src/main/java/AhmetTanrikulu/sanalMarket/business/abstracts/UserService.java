package AhmetTanrikulu.sanalMarket.business.abstracts;


import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.User;

public interface UserService {
	
	Result add (User user);

	DataResult<User> getByEmail (String email);
	
	DataResult<User> getById (int id);
	
	DataResult<User> getByUserName (String userName);
	
	
}
