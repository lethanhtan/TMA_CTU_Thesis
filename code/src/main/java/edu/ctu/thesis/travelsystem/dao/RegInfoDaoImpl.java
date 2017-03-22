package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.CancelRegistration;
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;

@Service
public class RegInfoDaoImpl extends AbstractDao implements RegInfoDao {
	// Fill the fields automatically
	private static final Logger logger = Logger.getLogger(RegInfoDaoImpl.class);

	// Save book tour form when have id tour
	@Override
	public void saveRegInfoForm(RegistrationInfo regInfo, int idTour) {
		Session session = getCurrentSession();
		if (regInfo != null) {
			try {
				logger.info("Update design form be called!");
				session.merge(regInfo);
				session.flush();
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	@Override
	public RegistrationInfo searchRegInfoById(int idTour) {
		Session session = getCurrentSession();
		RegistrationInfo regInfo = new RegistrationInfo();
		logger.info("Registration infor: " + idTour);
		String hql = "FROM edu.ctu.thesis.travelsystem.model.RegistrationInfo WHERE idTour = ?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, idTour);
			regInfo = (RegistrationInfo) query.uniqueResult();
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		return regInfo;
	}
	
	// Display registration list by Id tour
		@SuppressWarnings("unchecked")
		@Override
		public List<CancelRegistration> cancelList(int idTour) {
			Session session = getCurrentSession();
			String hql = "FROM RegistrationInfo WHERE ID_TOUR = :idTour";
			Query query = session.createQuery(hql);
			query.setParameter("idTour", idTour);
			List<CancelRegistration> cancelList = query.list();
			for (CancelRegistration cancelReg : cancelList) {
				logger.info("Cancel registration list:" + cancelReg);
			}
			return cancelList;
		}
	
	@Override
	public List<CancelRegistration> cancelListByValue(String value) {
		Session session = getCurrentSession();
		String hql = "FROM CancelRegistration WHERE idBT like :value or cName like :value or cEmail like :value or cPhone like :value";
		Query query = session.createQuery(hql);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<CancelRegistration> cancelList = query.list();
		return cancelList;
	}
	
	@Override
	public Integer getNumCancelReg(int idTour) {
		Integer numCancelReg = cancelList(idTour).size();
		logger.info("Number of registration are: " + numCancelReg);
		return numCancelReg;
	}
	
	@Override
	public Integer getNumCancelBySearch(String value) {
		Integer numCancel = cancelListByValue(value).size();
		logger.info("Number of registration are: " + numCancel);
		return numCancel;
	}
}
