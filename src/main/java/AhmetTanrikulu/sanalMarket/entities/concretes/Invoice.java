package AhmetTanrikulu.sanalMarket.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "date_")
	private LocalDate date;
	
	@Column(name = "address_id")
	private int adressId;
	
	@Column(name = "cargo_fiche_no")
	private String cargoFicheNo;
	
	@Column(name = "total_price")
	private double totalPrice;

}
