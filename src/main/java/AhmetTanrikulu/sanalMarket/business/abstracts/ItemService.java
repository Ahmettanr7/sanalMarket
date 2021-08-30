package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Item;

public interface ItemService {
	
	Result add(Item item);
	
	Result delete(int id);
	
	DataResult<List<Item>> getCategory1Id(int cat1Id, int pageNo, int pageSize);
	
	DataResult<Item> getById (int id);
	
	DataResult<List<Item>> getAllCategory1Id(int cat1Id);
	
	DataResult<List<Item>> getByItemName (String itemName);
	
	DataResult<List<Item>> getByItemNamePageable (String itemName, int pageNo, int pageSize);

}
