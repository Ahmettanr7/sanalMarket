package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer>{
	
	Payment getByOrderId (int orderId);
	
	

}
