package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface FilterDao {
	public List<BookTour> regListByFilterSex(String filterSex, int idTour);

	public Integer getNumRegFilterSex(String filterSex, int idTour);

	public List<BookTour> regListByFilterTicket(int filterTicket, int idTour);

	public Integer getNumRegFilterTicket(int filterTicket, int idTour);

	public List<BookTour> cancelListByFilterSex(String filterSex, int idTour);

	public Integer getNumCancelFilterSex(String filterSex, int idTour);

	public List<BookTour> cancelListByFilterTicket(int filterTicket, int idTour);

	public Integer getNumCancelFilterTicket(int filterTicket, int idTour);
}
