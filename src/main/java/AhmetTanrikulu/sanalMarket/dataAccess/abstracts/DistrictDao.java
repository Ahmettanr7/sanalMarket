package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.District;


public interface DistrictDao extends JpaRepository<District, Integer>{

}
