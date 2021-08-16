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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","singleInformations","address","districts"})
@Table(name = "towns")
public class Town {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "town")
	private String town;
	
	@OneToMany(mappedBy = "town")
	@JsonIgnore
	private List<Address> address;
	
	@OneToMany(mappedBy = "town")
	@JsonIgnore
	private List<District> districts;
	
	@ManyToOne()
	@JoinColumn(name = "city_id", insertable = false, updatable = false)
	private City city;
}
