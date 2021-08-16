package AhmetTanrikulu.sanalMarket.business.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.ImageService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.ImageDao;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.ItemDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Image;
import AhmetTanrikulu.sanalMarket.entities.concretes.Item;

@Service
@Transactional
public class ImageManager implements ImageService{
	
	private ImageDao imageDao;
	private ItemDao itemDao;

	public ImageManager(ImageDao imageDao, ItemDao itemDao) {
		super();
		this.imageDao = imageDao;
		this.itemDao = itemDao;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(),"Resimleri Getirme İşlemi Başarılı");
	}

	@Override
	public Result add(Image image) {
		LocalDate now = LocalDate.now();
		image.setDateOfCreation(now);
		this.imageDao.save(image);
		Item item = this.itemDao.getById(image.getItemId());
		item.setImageUrl(image.getImageUrl());
		return new SuccessResult("Başarıyla eklendi");
	}

	@Override
	public DataResult<List<Image>> getByItemId(int itemId) {
		return new SuccessDataResult<List<Image>>(this.imageDao.getByItemId(itemId),"Ürüne Ait Resimleri Getirme İşlemi Başarılı");
	}

}
