package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.OrderDetail;

public interface OrderDetailService {
	
	DataResult<OrderDetail> getByOrderId (int orderId);
	
	DataResult<List<OrderDetail>> getByItemId (int itemId);


}
