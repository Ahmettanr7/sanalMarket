package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	
	List<Image> getByItemId (int itemId);

}
