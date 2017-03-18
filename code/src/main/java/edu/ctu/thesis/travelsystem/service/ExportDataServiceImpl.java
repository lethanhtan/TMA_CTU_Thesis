package edu.ctu.thesis.travelsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.ExportDataDao;
import edu.ctu.thesis.travelsystem.model.Export;

@Service
public class ExportDataServiceImpl implements ExportDataService {

	@Autowired
	ExportDataDao exportDataDao;
	
	@Override
	@Transactional
	public void saveExport(Export objExport) {
		this.exportDataDao.saveExport(objExport);
	}

	@Override
	@Transactional
	public Integer getNumExport() {
		return this.exportDataDao.getNumExport();
	}

}
