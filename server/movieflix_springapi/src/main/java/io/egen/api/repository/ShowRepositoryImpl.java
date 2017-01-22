package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import io.egen.api.constants.MovieFlixConstants;
import io.egen.api.entity.FlixShow;
import io.egen.api.entity.Genre;
import io.egen.api.entity.UserComments;
import io.egen.api.entity.UserRatingStars;

@Repository
public class ShowRepositoryImpl implements ShowRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<FlixShow> findAllShowList() {
		TypedQuery<FlixShow> query = em.createNamedQuery("FlixShow.findAll", FlixShow.class);
		return query.getResultList();
	}

	@Override
	public List<FlixShow> findTypeList(String sType) {
		TypedQuery<FlixShow> query = em.createNamedQuery("FlixShow.showType", FlixShow.class);
		query.setParameter("pType", sType);
		return query.getResultList();
	}

	@Override
	public FlixShow findOne(String id) {
		return em.find(FlixShow.class, id);
	}

	@Override
	public List<FlixShow> topRatedMoviesAndSeries() {
		TypedQuery<FlixShow> query = em.createNamedQuery("FlixShow.topRated", FlixShow.class);
		query.setParameter("imdbRating",MovieFlixConstants.rateCutoff);
		return query.getResultList();
	}

	@Override
	public List<FlixShow> sortByField(String fieldName) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FlixShow> criteriaQuery = cb.createQuery(FlixShow.class);
		Root<FlixShow> from = criteriaQuery.from(FlixShow.class);
		criteriaQuery.select(from);
		criteriaQuery.orderBy(cb.desc(from.get(fieldName)));
		TypedQuery<FlixShow> query = em.createQuery(criteriaQuery);
		return query.getResultList();

	}

	@Override
	public FlixShow findByTitle(String title) {
		TypedQuery<FlixShow> query = em.createNamedQuery("FlixShow.findByTitle", FlixShow.class);
		query.setParameter("title", title);

		List<FlixShow> show = query.getResultList();
		if (show != null && show.size() == 1) {
			return show.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Genre findGenreType(String genreType) {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findType", Genre.class);
		query.setParameter("pType", genreType);
		List<Genre> genType = query.getResultList();
		if (genType != null && genType.size() == 1) {
			return genType.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Genre createGenre(Genre gerneType) {
		em.persist(gerneType);
		return gerneType;
	}

	@Override
	public FlixShow create(FlixShow show) {
		em.persist(show);
		return show;
	}

	@Override
	public FlixShow update(FlixShow show) {
		return em.merge(show);
	}

	@Override
	public void delete(FlixShow show) {
		em.remove(show);
	}

	@Override
	public String showTitleAverageRating(String title) {
		TypedQuery<UserRatingStars> query = em.createNamedQuery("UserRatingStars.findAverageRating",
				UserRatingStars.class);
		query.setParameter("pTitleId", title);
		List<UserRatingStars> avgRating = query.getResultList();
		if (avgRating != null && avgRating.size() == 1) {
			return String.valueOf(avgRating.get(0));
		} else {
			return null;
		}
	}

	@Override
	public List<UserComments> showComments(String title) {
		TypedQuery<UserComments> query = em.createNamedQuery("UserComments.showComments", UserComments.class);
		query.setParameter("title", title);
		return query.getResultList();
	}

	@Override
	public UserComments addComment(UserComments uComment) {
		em.persist(uComment);
		return uComment;
	}

	@Override
	public UserRatingStars giveRatings(UserRatingStars uRating) {
		em.persist(uRating);
		return uRating;
	}

	@Override
	public List<FlixShow> findbyShowYear(int year) {
		TypedQuery<FlixShow> query = em.createNamedQuery("FlixShow.findbyYear", FlixShow.class);
		query.setParameter("year", year);
		return query.getResultList();
	}

	@Override
	public List<Genre> findAllGenre() {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findAllGenre", Genre.class);
		return query.getResultList();
	}

	@Override
	public List<FlixShow> findByGenreType(String genre) {
		TypedQuery<FlixShow> query = em.createNamedQuery("FlixShow.findByGenreType", FlixShow.class);
		query.setParameter("genre", genre);

		return query.getResultList();
	}

	/*
	 * select c from Client c where (?1 is null or ?1='' or c.fileNo = ?1) and
	 * (?2 is null or ?2='' or c.firstname = ?2) and (?3 is null or ?3='' or
	 * c.lastname = ?3)
	 @Override public Show findByReleasedYear(int year) { return null;}
	 */

}
