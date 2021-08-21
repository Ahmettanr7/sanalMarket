package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>{
	
	List<Cart> getAllByUserId (int userId);
	
	List<Cart> getAllByUserIdAndItemId (int userId, int itemId);

}
