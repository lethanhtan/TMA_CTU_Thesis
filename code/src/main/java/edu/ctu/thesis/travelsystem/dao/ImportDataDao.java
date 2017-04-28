package edu.ctu.thesis.travelsystem.dao;

import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.model.Import;

public interface ImportDataDao {
	public void importExcel(MultipartFile excelfile, String listType);

	public void saveImport(Import object);
}
