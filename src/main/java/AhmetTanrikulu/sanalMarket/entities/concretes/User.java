package AhmetTanrikulu.sanalMarket.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","singleInformations","orders","address"})
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "username_")
	@NotBlank
	@NotNull
	private String userName;
	
	@Column(name = "password_")
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name = "namesurname")
	@NotBlank
	@NotNull
	private String nameSurname;
	
	@Column(name = "email")
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name = "gender")
	@NotBlank
	@NotNull
	private String gender;
	
	@Column(name = "birthdate")
	private LocalDate birthDate;
	
	@Column(name = "createdate")
	private LocalDate createDate;
	
	@Column(name = "telnr1")
	private String telNr1;
	
	@Column(name = "telnr2")
	private String telNr2;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Order> orders;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Address> address;
	

}
