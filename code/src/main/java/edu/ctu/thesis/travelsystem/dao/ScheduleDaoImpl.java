package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.Schedule;

@Service
public class ScheduleDaoImpl extends AbstractDao implements ScheduleDao {

	private static final Logger logger = Logger.getLogger(ScheduleDaoImpl.class);
	
	@Override
	public void saveSchedule(Schedule schedule) {
		Session session = getCurrentSession();
		try {
			session.save(schedule);
			session.flush();
		} catch (NullPointerException e) {
			logger.info("Null schedule!");
		}
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
	public void updateSchedule(Schedule schedule) {
		Session session = getCurrentSession();
		try {
			session.update(schedule);
			session.flush();
		} catch (NullPointerException e) {
			logger.info("Null schedule object for update schedule!");
		}
	}

	@Override
	public Schedule findSchedule(int idTour) {
		Session session = getCurrentSession();
		logger.info("Query schedule: ");
		String hql = "from Schedule s where s.tour.idTour = :idTour";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);

		return (Schedule) query.uniqueResult();
	}

}
