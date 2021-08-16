package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.Address;


public interface AddressDao extends JpaRepository<Address, Integer>{
	
	List<Address> getAllByUserId(int userId);
}
