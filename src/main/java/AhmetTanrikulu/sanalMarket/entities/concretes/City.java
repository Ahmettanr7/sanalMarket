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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","singleInformations","address","towns"})
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "country_id")
	private int countryId;
	
	@Column(name = "city")
	private String city;
	
	@OneToMany(mappedBy = "city")
	@JsonIgnore
	private List<Address> address;
	
	@OneToMany(mappedBy = "city")
	@JsonIgnore
	private List<Town> towns;
	
	@ManyToOne()
	@JoinColumn(name = "country_id", insertable = false, updatable = false)
	private Country country;
}
