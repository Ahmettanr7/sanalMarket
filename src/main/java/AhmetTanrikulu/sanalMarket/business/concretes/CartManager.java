package AhmetTanrikulu.sanalMarket.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.CartService;
import AhmetTanrikulu.sanalMarket.core.utilities.business.BusinessRules;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.CartDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Cart;

@Service
public class CartManager implements CartService{
	
	private CartDao cartDao;

	public CartManager(CartDao cartDao) {
		super();
		this.cartDao = cartDao;
	}

	@Override
	public Result add(Cart cart) {
		var result = BusinessRules.run(
				);
		if (result != null) {
			return result;
		}
		var cartt = new Cart();
		var value = this.cartDao.getAllByUserIdAndItemId(cart.getUserId(), cart.getItemId());
		var newCount = cartt.getCount() + cart.getCount();
		if ( value != null) {
			cartt.setCount(newCount);
		}
		LocalDate now = LocalDate.now();
		cart.setCreatedDate(now);
		this.cartDao.save(cart);
		return new SuccessResult(cart.getItem().getItemName()+" Sepete Eklendi");
	}

	@Override
	public Result delete(int id) {
		this.cartDao.deleteById(id);
		return new SuccessResult("Sepetten Çıkarma İşlemi Başarılı");
	}

	@Override
	public DataResult<List<Cart>> getAllByUserId(int userId) {
		return new SuccessDataResult<List<Cart>>(this.cartDao.getAllByUserId(userId));
	}

}
