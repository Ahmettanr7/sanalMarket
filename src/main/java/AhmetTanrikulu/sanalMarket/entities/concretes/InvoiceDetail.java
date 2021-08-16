package AhmetTanrikulu.sanalMarket.entities.concretes;

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
@Table(name = "invoice_details")
//SerializationException Kontrol et
public class InvoiceDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "invoice_id")
	private int invoiceId;
	
	@Column(name = "order_detail_id")
	private int orderDetailId;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "line_total")
	private double lineTotal;
	
	@ManyToOne()
	@JoinColumn(name = "order_detail_id", insertable = false, updatable = false)
	private OrderDetail orderDetail;
	
	@ManyToOne()
	@JoinColumn(name = "invoice_id", insertable = false, updatable = false)
	private Invoice invoice;
	
	@ManyToOne()
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;

}
