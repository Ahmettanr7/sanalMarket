package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.OrderDetailService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.OrderDetailDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService{
	
	private OrderDetailDao orderDetailDao;

	public OrderDetailManager(OrderDetailDao orderDetailDao) {
		super();
		this.orderDetailDao = orderDetailDao;
	}

	@Override
	public DataResult<List<OrderDetail>> getByOrderId(int orderId) {
		return new SuccessDataResult<List<OrderDetail>>(this.orderDetailDao.getAllByOrderId(orderId));
	}

}
