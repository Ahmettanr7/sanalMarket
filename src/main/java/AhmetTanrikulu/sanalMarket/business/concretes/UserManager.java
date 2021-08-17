package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.UserService;
import AhmetTanrikulu.sanalMarket.core.utilities.business.BusinessRules;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.ErrorResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessResult;
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
	public Result add(User user) {
		var result = BusinessRules.run(
				CheckIfTheEmailIsRegistered(user),
				CheckIfTheUserNamesRegistered(user),
				CheckIfTheTelNrRegistered(user),
				isRealEmail(user)
				);
		if (result != null) {
			return result;
		}
		this.userDao.save(user);
		return new SuccessResult("Kayıt Olma İşlemi Başarılı");
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
	
	private Result CheckIfTheEmailIsRegistered(User user) {
		if(userDao.getAllByEmail(user.getEmail()).stream().count() != 0) {
			return new ErrorResult("'" + user.getEmail() + "'" +" adresiyle daha önce hesap açılmış");
		}
		return new SuccessResult();
	}
	
	private Result CheckIfTheUserNamesRegistered(User user) {
		if(userDao.getAllByUserName(user.getUserName()).stream().count() != 0) {
			return new ErrorResult("'" + user.getUserName() + "'" +" kullanıcı adı ile daha önce hesap açılmış");
		}
		return new SuccessResult();
	}
	
	private Result CheckIfTheTelNrRegistered(User user) {
		if(userDao.getAllByTelNr1(user.getTelNr1()).stream().count() != 0) {
			return new ErrorResult("'" + user.getTelNr1() + "'" +" telefon numarası ile daha önce hesap açılmış");
		}
		if(userDao.getAllByTelNr2(user.getTelNr2()).stream().count() != 0) {
			return new ErrorResult("'" + user.getTelNr2() + "'" +" telefon numarası ile daha önce hesap açılmış");
		}
		return new SuccessResult();
	}
	
	private Result isRealEmail(User user) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(user.getEmail());
	     if(!matcher.matches()) {
	    	 return new ErrorResult("Hatalı Email adresi girdiniz");
	     }
	     return new SuccessResult();
	     }


}
