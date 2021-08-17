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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","singleInformations","orders","invoices"})
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	@NotNull
	private int userId;
	
	@Column(name = "country_id")
	@NotNull
	private int countryId;
	
	@Column(name = "city_id")
	@NotNull
	private int cityId;
	
	@Column(name = "town_id")
	@NotNull
	private int townId;
	
	@Column(name = "district_id")
	@NotNull
	private int districtId;
	
	@Column(name = "postal_code")
	@NotNull
	@NotBlank
	private String postalCode;
	
	@Column(name = "address_text")
	@NotNull
	@NotBlank
	private String addressText;
	
	@ManyToOne()
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "country_id", insertable = false, updatable = false)
	private Country country;
	
	@ManyToOne()
	@JoinColumn(name = "city_id", insertable = false, updatable = false)
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "town_id", insertable = false, updatable = false)
	private Town town;
	
	@ManyToOne()
	@JoinColumn(name = "district_id", insertable = false, updatable = false)
	private District district;
	
	@OneToMany(mappedBy = "address")
	@JsonIgnore
	private List<Order> orders;
	
	@OneToMany(mappedBy = "address")
	@JsonIgnore
	private List<Invoice> invoices;

}
