package edu.ctu.thesis.travelsystem.service;

import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.model.Import;

public interface ImportDataService {
	public void importExcel(MultipartFile excelfile);

	public void saveImport(Import object);
}
