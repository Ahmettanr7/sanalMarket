package AhmetTanrikulu.sanalMarket.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.OrderService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.CartDao;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.OrderDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Order;
import AhmetTanrikulu.sanalMarket.entities.dtos.CartDto;

@Service
public class OrderManager implements OrderService{
	
	private OrderDao orderDao;
	private CartDao cartDao;
 
	public OrderManager(OrderDao orderDao, CartDao cartDao) {
		super();
		this.orderDao = orderDao;
		this.cartDao = cartDao;
	}

	@Override
	public DataResult<List<Order>> getByUserId(int userId) {
		return new SuccessDataResult<List<Order>>(this.orderDao.getByUserId(userId));
	}

	@Override
	public Result add(Order order) {
		LocalDate now = LocalDate.now();
		CartDto cart= this.cartDao.getByUserIdTotalCartPrice(order.getUserId());
		
		order.setDate(now);
		order.setTotalPrice(cart.getTotalCartPrice());
		order.setDelivered(false);
		this.orderDao.save(order);
		
		var cartItems= this.cartDao.getAllByUserIdAndCartStatusIsTrue(order.getUserId());
		
		for (int i = 0; i < cartItems.stream().count() ; i++) {
			cartItems.get(i).setCartStatus(false);
			this.cartDao.save(cartItems.get(i));
		}
		
		return new SuccessResult("Siparişiniz alındı.");
		
		
	}

	@Override
	public DataResult<List<Order>> getByIsDeliveredIsTrue() {
		return new SuccessDataResult<List<Order>>(this.orderDao.getByIsDeliveredIsTrueOrderByDateDesc());
	}

	@Override
	public DataResult<List<Order>> getByIsDeliveredIsFalse() {
		return new SuccessDataResult<List<Order>>(this.orderDao.getByIsDeliveredIsFalse());
	}

	@Override
	public DataResult<Order> getById(int id) {
		return new SuccessDataResult<Order>(this.orderDao.getById(id));
	}

	@Override
	public Result wasDelivered(int id) {
		Order order = this.orderDao.getById(id);
		order.setDelivered(true);
		this.orderDao.save(order);
		return new SuccessResult("Siparişin teslim edildiği kaydedildi.");
	}

}
