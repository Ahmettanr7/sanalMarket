package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.Country;


public interface CountryDao extends JpaRepository<Country, Integer>{

}
