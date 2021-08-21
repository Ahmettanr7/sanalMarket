package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Cart;

public interface CartService {
	
	Result add (Cart cart);
	
	Result delete (int id);
	
	DataResult<List<Cart>> getAllByUserId (int userId);

}
