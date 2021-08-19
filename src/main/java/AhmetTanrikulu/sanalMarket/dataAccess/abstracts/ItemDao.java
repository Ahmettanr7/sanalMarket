package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import AhmetTanrikulu.sanalMarket.entities.concretes.Item;

public interface ItemDao extends JpaRepository<Item, Integer>{
	
	@Query("From Item Where category1 = :cat1Id")
	List<Item> getCategory1Id(int cat1Id, Pageable pageable);
	
	@Query("From Item Where category1 = :cat1Id")
	List<Item> getAllCategory1Id(int cat1Id);
	
	@Query("From Item Where id = :id")
	Item getById (int id);

}
