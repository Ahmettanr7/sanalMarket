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

import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","singleInformations","orderDetails","payments","invoices"})
@Table(name = "orders")
//SerializationException Kontrol et
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "date_")
	private LocalDate date;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "status_")
	private TinyIntTypeDescriptor status;
	
	@Column(name = "address_id")
	private int addressId;
	
	@ManyToOne()
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "address_id", insertable = false, updatable = false)
	private Address address;
	
	@OneToMany(mappedBy = "order")
	@JsonIgnore
	private List<OrderDetail> orderDetails;
	
	@OneToMany(mappedBy = "order")
	@JsonIgnore
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "order")
	@JsonIgnore
	private List<Invoice> invoices;

}