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
import AhmetTanrikulu.sanalMarket.entities.dtos.CartDto;

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
		cart.setCartStatus(true);
		this.cartDao.save(cart);
		return new SuccessResult("Sepete eklendi");
	}

	@Override
	public Result delete(int userId, int itemId) {
		this.cartDao.deleteItem(userId, itemId);
		return new SuccessResult("Sepetten Çıkarma İşlemi Başarılı");
	}

	@Override
	public DataResult<List<Cart>> getAllByUserId(int userId) {
		return new SuccessDataResult<List<Cart>>(this.cartDao.getAllByUserId(userId));
	}

	@Override
	public DataResult<List<CartDto>> getActiveCartItem(int userId) {
		return new SuccessDataResult<List<CartDto>>(this.cartDao.getActiveCartItem(userId));
	}

}
