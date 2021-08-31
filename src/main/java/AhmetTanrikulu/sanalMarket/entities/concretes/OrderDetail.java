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
@Table(name = "order_details")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "count")
	private double count;
	
	@ManyToOne()
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;
	
	@ManyToOne()
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;

}
