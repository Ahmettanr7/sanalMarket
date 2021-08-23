package AhmetTanrikulu.sanalMarket.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
	
	private int userId;
	private int itemId;
	private String itemName;
	private String itemCode;
	private float unitPrice;
	private int category1;
	private String category2;
	private String category3;
	private String category4;
	private String brand;
	private double totalCount;
	
	

}
