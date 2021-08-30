package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Category1;

public interface Category1Service {
	
	Result add (Category1 category1);
	
	Result delete (int id);
	
	DataResult<List<Category1>> getAll();
	
	DataResult <Category1> getById(int id);

}
