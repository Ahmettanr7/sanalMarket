package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.CityService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.CityDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;

	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getByCountryId(int countryId) {
		return new SuccessDataResult<List<City>>(this.cityDao.getByCountryId(countryId),"Ülkenin Şehirleri Getirme İşlemi Başarılı");
	}

}
