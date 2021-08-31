package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.Category1Service;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.Category1Dao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Category1;

@Service
public class Category1Manager implements Category1Service{
	
	private Category1Dao category1Dao;

	public Category1Manager(Category1Dao category1Dao) {
		super();
		this.category1Dao = category1Dao;
	}

	@Override
	public DataResult<List<Category1>> getAll() {
		return new SuccessDataResult<List<Category1>>(this.category1Dao.findAll(),"Kategorileri Getirme İşlemi Başarılı");
	}

	@Override
	public DataResult<Category1> getById(int id) {
		return new SuccessDataResult<Category1>(this.category1Dao.getById(id));
	}

	@Override
	public Result add(Category1 category1) {
		this.category1Dao.save(category1);
		return new SuccessResult("Kategori ekleme işlemi başarılı");
	}

	@Override
	public Result delete(int id) {
		this.category1Dao.deleteById(id);
		return new SuccessResult("Kategori silme işlemi başarılı");
	};

}
