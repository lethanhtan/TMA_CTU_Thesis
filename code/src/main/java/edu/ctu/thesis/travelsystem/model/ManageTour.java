/*package edu.ctu.thesis.travelsystem.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.Tour;

@Controller
@RequestMapping("managetour")
public class ManageTour {
	@Autowired
	private SessionFactory mySessionFactory;
	
	@Transactional
	public List<Tour> searchForBook(String searchText) throws Exception {
		try {
			Session session = mySessionFactory.getCurrentSession();

			FullTextSession fullTextSession = Search.getFullTextSession(session);

			QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Tour.class).get();
			org.apache.lucene.search.Query query = qb.keyword().onFields("TOUR_NAME").matching(searchText)
					.createQuery();

			org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Tour.class);

			List<Tour> results = hibQuery.list();
			return results;
		} catch (Exception e) {
			throw e;
		}
	}

}*/