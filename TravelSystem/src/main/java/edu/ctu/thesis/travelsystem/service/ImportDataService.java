package edu.ctu.thesis.travelsystem.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportDataService {
	public void importExcel(MultipartFile excelfile);
}
