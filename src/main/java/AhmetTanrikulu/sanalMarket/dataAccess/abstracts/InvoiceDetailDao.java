package AhmetTanrikulu.sanalMarket.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.sanalMarket.entities.concretes.InvoiceDetail;

public interface InvoiceDetailDao extends JpaRepository<InvoiceDetail, Integer>{

}
