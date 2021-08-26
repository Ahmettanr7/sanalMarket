package AhmetTanrikulu.sanalMarket.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
	
	private int userId;
	private double totalCartPrice;
	
	

}
