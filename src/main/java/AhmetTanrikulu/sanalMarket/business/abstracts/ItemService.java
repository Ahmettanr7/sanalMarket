package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Item;

public interface ItemService {
	
	Result add(Item item);
	
	Result deleteByItemId(int itemId);
	
	DataResult<List<Item>> getCategory1Id(int cat1Id, int pageNo, int pageSize);
	
	DataResult<Item> getById (int id);
	
	DataResult<List<Item>> getAllCategory1Id(int cat1Id);

}
