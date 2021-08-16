package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import AhmetTanrikulu.sanalMarket.entities.concretes.User;


public interface UserDao extends JpaRepository<User, Integer>{
	
	User getByEmail(String email);
	
	@Query("From User Where id = :id")
	User getById (int id);
	
	User getByUserName (String userName);

}
