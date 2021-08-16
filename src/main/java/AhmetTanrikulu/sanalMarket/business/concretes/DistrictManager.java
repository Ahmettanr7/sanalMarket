package AhmetTanrikulu.sanalMarket.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import AhmetTanrikulu.sanalMarket.business.abstracts.DistrictService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.SuccessDataResult;
import AhmetTanrikulu.sanalMarket.dataAccess.abstracts.DistrictDao;
import AhmetTanrikulu.sanalMarket.entities.concretes.District;

@Service
public class DistrictManager implements DistrictService{
	
	private DistrictDao districtDao;

	public DistrictManager(DistrictDao districtDao) {
		super();
		this.districtDao = districtDao;
	}

	@Override
	public DataResult<List<District>> getByTownId(int townId) {
		return new SuccessDataResult<List<District>>(this.districtDao.getByTownId(townId),"İlçeye göre Mahalleler getirildi");
	}

}
