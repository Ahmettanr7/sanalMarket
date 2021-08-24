package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Cart;
import AhmetTanrikulu.sanalMarket.entities.dtos.CartDto;

public interface CartService {
	
	Result add (Cart cart);
	
	Result delete (int userId, int itemId);
	
	DataResult<List<Cart>> getAllByUserId (int userId);

	DataResult<List<CartDto>> getActiveCartItem (int userId);
}
