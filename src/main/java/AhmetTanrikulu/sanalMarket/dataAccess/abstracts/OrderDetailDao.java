package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer>{
	
	List<OrderDetail> getAllByOrderId (int orderId);

}
