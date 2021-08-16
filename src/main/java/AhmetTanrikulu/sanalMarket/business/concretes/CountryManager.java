package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.CountryService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.CountryDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Country;

@Service
public class CountryManager implements CountryService{
	
	private CountryDao countryDao;

	public CountryManager(CountryDao countryDao) {
		super();
		this.countryDao = countryDao;
	}

	@Override
	public DataResult<List<Country>> getAll() {
		return new SuccessDataResult<List<Country>>(this.countryDao.findAll(),"Ülkeler Getirme İşlemi Başarılı");
	}

}
