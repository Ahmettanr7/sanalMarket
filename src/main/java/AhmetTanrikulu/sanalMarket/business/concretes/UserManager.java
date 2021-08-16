package AhmetTanrikulu.sanalMarket.business.concretes;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.UserService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.UserDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email));
	}

	@Override
	public DataResult<User> getById(int id) {
		return new SuccessDataResult<User>(this.userDao.getById(id));
	}

	@Override
	public DataResult<User> getByUserName(String userName) {
		return new SuccessDataResult<User>(this.userDao.getByUserName(userName));
	}

}
