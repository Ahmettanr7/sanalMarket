package AhmetTanrikulu.sanalMarket.business.abstracts;

import java.util.List;

import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.core.utilities.results.Result;
import AhmetTanrikulu.sanalMarket.entities.concretes.Image;


public interface ImageService {
	
	DataResult<List<Image>> getAll();
	Result add(Image image);
	
	DataResult<List<Image>> getByItemId(int itemId);

}
