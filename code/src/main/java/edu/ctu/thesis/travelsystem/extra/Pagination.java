package edu.ctu.thesis.travelsystem.extra;

public class Pagination {
	public static Integer paginationX(Integer currentPage, Integer page) {
		return currentPage * page - page;
	}

	public static Integer paginationY(Integer numOfPage, Integer currentPage, Integer page) {
		Integer y = paginationX(currentPage, page);
		if (y + page > numOfPage) {
			y = (y + paginationX(currentPage, page) - (y + paginationX(currentPage, page) - numOfPage));
		} else {
			y += page;
		}
		if (numOfPage < 5 && page == 5 || numOfPage < 10 && page == 10 || numOfPage < 15 && page == 15) {
			y = numOfPage;
		}
		return y;
	}
}
