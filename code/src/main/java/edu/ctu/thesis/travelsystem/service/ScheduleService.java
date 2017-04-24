package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Schedule;

public interface ScheduleService {

	public void saveSchedule(Schedule schedule);

	public void deleteSchedule(int id);

	public void updateSchedule(Schedule schedule);

	public Schedule findSchedule(int idTour);

	public List<Schedule> listSchedule();

}
