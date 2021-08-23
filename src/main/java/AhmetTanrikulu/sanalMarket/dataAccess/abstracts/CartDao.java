package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AhmetTanrikulu.sanalMarket.entities.concretes.Cart;
import AhmetTanrikulu.sanalMarket.entities.dtos.CartDto;

public interface CartDao extends JpaRepository<Cart, Integer>{
	
	List<Cart> getAllByUserId (int userId);
	
	List<Cart> getAllByUserIdAndItemId (int userId, int itemId);
	
	@Query("SELECT New AhmetTanrikulu.sanalMarket.entities.dtos.CartDto"
			+ " (c.userId, c.itemId, i.itemName, i.itemCode, i.unitPrice, i.category1, i.category2, i.category3, "
			+ "i.category4, i.brand,"
			+ "SUM(c.count) as count)"
			+ " FROM Item i Inner Join i.carts c "
			+ "WHERE c.userId=:userId And c.cartStatus=1 "
			+ "GROUP BY c.userId, c.itemId, i.itemName, i.itemCode, i.unitPrice, i.category1, i.category2, i.category3,"
			+ " i.category4, i.brand")
	List<CartDto> getActiveCartItem (@Param("userId") int userId);
	
	List<Cart> getByUserIdAndItemIdAndCartStatusIsTrue (int userId, int itemId);
}
