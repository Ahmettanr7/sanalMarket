package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.City;



public interface CityDao extends JpaRepository<City, Integer>{
	
	List<City> getByCountryId (int countryId);

}
