package edu.ctu.thesis.travelsystem.dao;

import org.springframework.web.multipart.MultipartFile;

public interface ImportDataDao {
	public void importExcel(MultipartFile excelfile);
}
