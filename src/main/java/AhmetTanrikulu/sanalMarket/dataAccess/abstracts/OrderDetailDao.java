package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer>{

}
