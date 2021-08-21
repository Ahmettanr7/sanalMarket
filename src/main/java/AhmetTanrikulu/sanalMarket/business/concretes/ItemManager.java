package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Autowired
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
	public DataResult<List<Item>> getCategory1Id(int cat1Id, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<Item>>(this.itemDao.getCategory1Id(cat1Id,pageable),"Kategor1 id sine Göre Getirme İşlemi Başarılı");
	}
	
	@Override
	public DataResult<List<Item>> getAllCategory1Id(int cat1Id) {
		return new SuccessDataResult<List<Item>>(this.itemDao.getAllCategory1Id(cat1Id));
	}

	@Override
	public DataResult<Item> getById(int id) {
		return new SuccessDataResult<Item>(this.itemDao.getById(id),"Ürün Getirme İşlemi Başarılı");
	}

	@Override
	public DataResult<List<Item>> getByItemName(String itemName) {
		return new SuccessDataResult<List<Item>>(this.itemDao.getByName(itemName),"'"+itemName+"'"+" arama sonuçları ;");
	}

}
