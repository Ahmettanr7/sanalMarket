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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","singleInformations","images","orderDetails","invoiceDetails","favorites"})
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "item_code")
	@NotNull
	@NotBlank
	private String itemCode;
	
	@Column(name = "item_name")
	@NotNull
	@NotBlank
	private String itemName;
	
	@Column(name = "unit_price")
	@NotNull
	private double unitPrice;
	
	@Column(name = "category1")
	@NotNull
	private int category1;
	
	@Column(name = "category2")
	private String category2;
	
	@Column(name = "category3")
	private String category3;
	
	@Column(name = "category4")
	private String category4;
	
	@Column(name = "brand")
	@NotNull
	@NotBlank
	private String brand;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@ManyToOne()
	@JoinColumn(name = "category1", insertable = false, updatable = false)
	private Category1 category;
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<Image> images;
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<OrderDetail> orderDetails;
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<InvoiceDetail> invoiceDetails;
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<Cart> carts;
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<Favorite> favorites;
}
