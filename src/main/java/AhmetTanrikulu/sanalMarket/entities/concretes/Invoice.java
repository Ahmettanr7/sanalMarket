package AhmetTanrikulu.sanalMarket.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","singleInformations","invoiceDetails"})
@Table(name = "invoices")
//SerializationException Kontrol et
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
	
	@ManyToOne()
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;

	@ManyToOne()
	@JoinColumn(name = "address_id", insertable = false, updatable = false)
	private Address address;
	
	@OneToMany(mappedBy = "invoice")
	@JsonIgnore
	private List<InvoiceDetail> invoiceDetails;
}
