package io.egen.api.service;

import java.util.List;

//import io.egen.api.entity.Genre;
import io.egen.api.entity.FlixShow;
import io.egen.api.entity.Genre;
import io.egen.api.entity.UserComments;
//import io.egen.api.entity.UserComments;
import io.egen.api.entity.UserRatingStars;

public interface ShowService
{

	public List<FlixShow> findAllShowList();
	public List<FlixShow> findTypeList(String sType);
	public FlixShow create(FlixShow show);
	public FlixShow update(String titleId,FlixShow show);
	public void delete(String titleId);
	public FlixShow displayTitleDetails(String title);
	public List<FlixShow> topRatedMoviesAndSeries();
	public List<FlixShow> sortByField(String fieldName);
	public Genre createGenre(Genre genreType);
	public String showTitleAverageRating(String title);
	public List <UserComments> showComments(String title);
	public UserComments addComment(UserComments cm);
	public UserRatingStars giveRatings(UserRatingStars urating);
	public List<FlixShow> findbyShowYear(int year);
	public List<Genre> findAllGenre(); 
	public List<FlixShow> findByGenreType(String type);
	
	//public Genre createGenre(Genre genreType);
	//public Show findByReleasedYear(int year);
}
