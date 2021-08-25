package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.CartService;
import AhmetTanrikulu.sanalMarket.core.utilities.business.BusinessRules;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.CartDao;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.ItemDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Cart;
import AhmetTanrikulu.sanalMarket.entities.dtos.CartDto;

@Service
public class CartManager implements CartService{
	
	private CartDao cartDao;
	private ItemDao itemDao;

	public CartManager(CartDao cartDao, ItemDao itemDao) {
		super();
		this.cartDao = cartDao;
		this.itemDao = itemDao;
	}

	@Override
	public Result add(Cart cart) {
		
		var result = BusinessRules.run(
				);
		if (result != null) {
			return result;
		}
		var item = this.cartDao.getAllByUserIdAndItemIdAndCartStatusIsTrue(cart.getUserId(), cart.getItemId());
		if(item != null) {
			var findItem = this.itemDao.getById(item.getItemId());
			var newCount= item.getCount()+cart.getCount();
			var newLineTotal= newCount*findItem.getUnitPrice();
//			for (int a = 0; a < 100; a++) {
//			 var itemm = this.cartDao.getAllByUserIdAndCartStatusIsTrue(cart.getUserId()).get(a);
//			float newTotalPrice= +itemm.getLineTotal();
//			item.setTotalCartPrice(newTotalPrice);
//			}
			item.setCount(newCount);
			item.setLineTotal(newLineTotal);
			this.cartDao.save(item);
			return new SuccessResult("Sepete eklendi");
			}
		
			cart.setCartStatus(true);
			cart.setLineTotal(cart.getCount()*itemDao.getById(cart.getItemId()).getUnitPrice());
			cart.setTotalCartPrice(cart.getLineTotal());
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
