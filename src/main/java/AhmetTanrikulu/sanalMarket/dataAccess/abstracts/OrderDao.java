package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import AhmetTanrikulu.sanalMarket.entities.concretes.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
	
	@Query("From Order Where id = :id")
	Order getById(int id);
	
	List<Order> getByUserId (int userId);
	
	List<Order> getByIsDeliveredIsTrueOrderByDateDesc();
	
	List<Order> getByIsDeliveredIsFalse();

}
