package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.FilterDao;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class FilterServiceImpl implements FilterService {
	@Autowired
	private FilterDao filterDao;

	@Override
	public List<BookTour> regListByFilterSex(String filterSex, int idTour) {
		return this.filterDao.regListByFilterSex(filterSex, idTour);
	}

	@Override
	public List<BookTour> cancelListByFilterSex(String filterSex, int idTour) {
		return this.filterDao.cancelListByFilterSex(filterSex, idTour);
	}

	@Override
	public List<BookTour> regListByFilterAge(String filterAge, int idTour) {
		return this.filterDao.regListByFilterAge(filterAge, idTour);
	}

	@Override
	public List<BookTour> cancelListByFilterAge(String filterAge, int idTour) {
		return this.filterDao.cancelListByFilterAge(filterAge, idTour);
	}
	
	@Override
	@Transactional
	public List<Tour> tourListByFilterPrice(String filterPrice) {
		return this.filterDao.tourListByFilterPrice(filterPrice);
	}
	
	@Override
	@Transactional
	public List<Tour> tourListByFilterSale(String filterSale) {
		return this.filterDao.tourListByFilterSale(filterSale);
	}
}