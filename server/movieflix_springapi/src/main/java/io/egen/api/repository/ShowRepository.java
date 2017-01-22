package io.egen.api.repository;

import java.util.List;

//import io.egen.api.entity.Genre;
import io.egen.api.entity.FlixShow;
//import io.egen.api.entity.UserComments;
import io.egen.api.entity.Genre;
import io.egen.api.entity.UserComments;
import io.egen.api.entity.UserRatingStars;

public interface ShowRepository
{
	public List<FlixShow> findAllShowList();
	public List<FlixShow> findTypeList(String sType);
	public List<FlixShow> topRatedMoviesAndSeries();
	public List<FlixShow> sortByField(String fieldName);
	public Genre createGenre(Genre genreType);
	public Genre findGenreType(String title);
	public String showTitleAverageRating(String title);
	public List <UserComments> showComments(String title);
	public UserComments addComment(UserComments cmnt);
	public UserRatingStars giveRatings(UserRatingStars urating);
	public List<FlixShow> findbyShowYear(int year);
	public List<Genre> findAllGenre(); 
	public List<FlixShow> findByGenreType(String type);
	public FlixShow findOne(String id);
	public FlixShow findByTitle(String title);
	public FlixShow create(FlixShow show);
	public FlixShow update(FlixShow show);
	public void delete(FlixShow show);
	/*
	public Show findByReleasedYear(int year);
	public Show findBy(int year);*/

}
