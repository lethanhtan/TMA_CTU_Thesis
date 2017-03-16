package edu.ctu.thesis.travelsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.dao.ImportDataDao;

@Service
public class ImportDataServiceImpl implements ImportDataService {
	
	@Autowired
	ImportDataDao importDao;

	@Override
	@Transactional
	public void importExcel(MultipartFile excelfile) {
		this.importDao.importExcel(excelfile);
	}

}
