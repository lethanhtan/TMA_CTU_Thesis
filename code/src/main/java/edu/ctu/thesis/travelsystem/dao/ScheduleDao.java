package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Schedule;

public interface ScheduleDao {
	
	public void saveSchedule(Schedule schedule);
	
	public void deleteSchedule(int id);
	
	public void updateSchedule(Schedule schedule);
	
	public Schedule findSchedule(int idTour);
	
	public List<Schedule> listSchedule();
}
