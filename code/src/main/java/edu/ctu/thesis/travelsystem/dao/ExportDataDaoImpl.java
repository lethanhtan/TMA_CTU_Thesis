package edu.ctu.thesis.travelsystem.dao;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.Export;

@Service
public class ExportDataDaoImpl extends AbstractDao implements ExportDataDao {

	@Override
	public void saveExport(Export objExport) {
		Session session = getCurrentSession();
		Date now = new Date();
		objExport.setDate(now);
		objExport.setTime(now);
		session.save(objExport);
		session.flush();
	}

	@Override
	public Integer getNumExport() {
		// TODO Auto-generated method stub
		return null;
	}

}
