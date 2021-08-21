package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import AhmetTanrikulu.sanalMarket.entities.concretes.Category1;


public interface Category1Dao extends JpaRepository<Category1, Integer>{
	
	@Query("From Category1 Where id = :id")
	Category1 getById (int id);

}
