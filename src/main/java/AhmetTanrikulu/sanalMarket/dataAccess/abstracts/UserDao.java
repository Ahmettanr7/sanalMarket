package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import AhmetTanrikulu.sanalMarket.entities.concretes.User;


public interface UserDao extends JpaRepository<User, Integer>{
	
	User getByEmail(String email);
	
	User getByUserName (String userName);
	
	List<User> getAllByEmail(String email);
	
	List<User> getAllByUserName(String userName);
	
	List<User> getAllByTelNr1(String telNr1);
	
	List<User> getAllByTelNr2(String telNr2);
	
	@Query("From User Where id = :id")
	User getById (int id);

}
