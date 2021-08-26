package AhmetTanrikulu.sanalMarket.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	@NotNull
	private int userId;
	
	@Column(name = "item_id")
	@NotNull
	private int itemId;
	
	@Column(name = "count")
	@NotNull
	private double count;
	
	@Column(name = "cart_status")
	private boolean cartStatus;
	
	@Column(name = "line_total")
	private double lineTotal;
	
	@Column(name = "total_cart_price")
	private double totalCartPrice;
	
	@ManyToOne()
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;

}
