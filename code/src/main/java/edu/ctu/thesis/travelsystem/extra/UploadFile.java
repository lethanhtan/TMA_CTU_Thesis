package edu.ctu.thesis.travelsystem.extra;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.controller.CreateTourController;
import edu.ctu.thesis.travelsystem.model.Tour;

public class UploadFile implements Runnable{
	
	public MultipartFile  file;
	public String name;
	public Tour tour;
	
	private static final Logger logger = Logger.getLogger(CreateTourController.class);
	
	public UploadFile(MultipartFile file, String name, Tour tour) {
		this.name = name;
		this.file = file;
		this.tour = tour;
	}

	@Override
	public void run() {
		uploadFile(file, name, tour);
		
	}
	
	public void uploadFile(MultipartFile file, String name, Tour tour) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
				tour.setImage(serverFile.getAbsolutePath());
			} catch (Exception e) {
				logger.info("Lỗi xảy ra trong quá trình upload!");
			}
		} else {
			logger.info("Bạn không chọn hình cho tour vừa tạo!");
		}
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}
	
}
