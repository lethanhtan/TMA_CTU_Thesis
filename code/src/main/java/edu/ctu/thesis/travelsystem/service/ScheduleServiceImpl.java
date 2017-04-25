package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.ScheduleDao;
import edu.ctu.thesis.travelsystem.model.Schedule;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleDao scheduleDao;
	
	@Override
	@Transactional
	public void saveSchedule(Schedule schedule) {
		this.scheduleDao.saveSchedule(schedule);
	}

	@Override
	public void deleteSchedule(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Schedule> listSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void updateSchedule(Schedule schedule) {
		this.scheduleDao.updateSchedule(schedule);
	}

	@Override
	public Schedule findSchedule(int idTour) {
		return this.scheduleDao.findSchedule(idTour);
	}

}
