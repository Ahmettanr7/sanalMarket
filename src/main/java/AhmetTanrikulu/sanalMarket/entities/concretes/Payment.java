package AhmetTanrikulu.sanalMarket.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
//SerializationException Kontrol et
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "payment_type")
	private int paymentType;
	
	@Column(name = "date_")
	private LocalDate date;
	
	@Column(name = "isok")
	private boolean isOk;
	
	@Column(name = "approve_code")
	private String approveCode;
	
	@Column(name = "payment_total")
	private double paymentTotal;
	
	@ManyToOne()
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;

}
