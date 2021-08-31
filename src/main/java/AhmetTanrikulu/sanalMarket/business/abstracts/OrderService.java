package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Order;

public interface OrderService {
	
	Result add(Order order);
	
	Result wasDelivered(int id);
	
	DataResult<Order> getById(int id);
	
	DataResult<List<Order>> getByUserId (int userId);
	
	DataResult<List<Order>> getByIsDeliveredIsTrue();
	
	DataResult<List<Order>> getByIsDeliveredIsFalse();

}
