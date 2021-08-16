package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.TownService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.TownDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.Town;

@Service
public class TownManager implements TownService{
	
	private TownDao townDao;

	public TownManager(TownDao townDao) {
		super();
		this.townDao = townDao;
	}

	@Override
	public DataResult<List<Town>> getByCityId(int cityId) {
		return new SuccessDataResult<List<Town>>(this.townDao.getByCityId(cityId));
	}

}
