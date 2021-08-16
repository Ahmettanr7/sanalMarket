package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
	
	List<Order> getByUserId (int userId);

}
