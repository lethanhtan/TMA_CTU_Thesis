package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.Export;

public interface ExportDataService {
	
	public void saveExport(Export objExport);

	public Integer getNumExport();
}
