package AhmetTanrikulu.sanalMarket.entities.concretes;


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
@Table(name = "order_details")
//SerializationException Kontrol et
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "line_total")
	private double lineTotal;

	@ManyToOne()
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;
	
	@ManyToOne()
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;
	
	@OneToMany(mappedBy = "orderDetail")
	@JsonIgnore
	private List<InvoiceDetail> invoiceDetails;
}
