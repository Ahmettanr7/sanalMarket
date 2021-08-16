package AhmetTanrikulu.sanalMarket.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.DistrictService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.District;

@RestController
@RequestMapping("/api/districts/")
@CrossOrigin
public class DistrictsController {
	
	private DistrictService districtService;

	public DistrictsController(DistrictService districtService) {
		super();
		this.districtService = districtService;
	}
	
	@GetMapping("getbytown")
	public DataResult<List<District>> getByTown(int townId) {
		return this.districtService.getByTownId(townId);
	}

}
