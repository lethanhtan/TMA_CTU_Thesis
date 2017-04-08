package edu.ctu.thesis.travelsystem.dao;

import edu.ctu.thesis.travelsystem.model.Export;

public interface ExportDataDao {
	
	public void saveExport(Export objExport);
	
	public Integer getNumExport();
}
