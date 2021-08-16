package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.ItemService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.ItemDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Item;

@Service
public class ItemManager implements ItemService{
	
	private ItemDao itemDao;

	public ItemManager(ItemDao itemDao) {
		super();
		this.itemDao = itemDao;
	}

	@Override
	public Result add(Item item) {
		this.itemDao.save(item);
		return new SuccessResult("Ürün Ekleme İşlemi Başarılı");
	}

	@Override
	public Result deleteByItemId(int itemId) {
		this.itemDao.deleteById(itemId);
		return new SuccessResult("Silme İşlemi Başarılı");
	}

	@Override
	public DataResult<List<Item>> getCategory1Id(int cat1Id) {
		return new SuccessDataResult<List<Item>>(this.itemDao.getCategory1Id(cat1Id),"Kategor1 id sine Göre Getirme İşlemi Başarılı");
	}

}