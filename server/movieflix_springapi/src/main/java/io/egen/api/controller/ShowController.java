//Show(Movies and TV Series) Rest controller class
package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.constants.MovieFlixConstants;
import io.egen.api.entity.FlixShow;
import io.egen.api.entity.Genre;
import io.egen.api.entity.UserComments;
import io.egen.api.entity.UserRatingStars;
import io.egen.api.service.ShowService;

@RestController
public class ShowController {
	@Autowired
	ShowService service;

	//findAllShowList() :: method called to find all shows(Movies & Series) List
	@RequestMapping(method = RequestMethod.GET, value = "flixshows")
	public List<FlixShow> findAllShowList() {
		return service.findAllShowList();
	}
	//findAllMovieList() :: method called to find all Movies list from the Catalog.
	@RequestMapping(method = RequestMethod.GET, value = "flixmovies")
	public List<FlixShow> findAllMovieList() {
		return service.findTypeList(MovieFlixConstants.Movies);
	}

	//findAllTVSeriesList() :: method called to find all TV Series list from the Catalog.
	@RequestMapping(method = RequestMethod.GET, value = "flixseries")
	public List<FlixShow> findAllTVSeriesList() {
		return service.findTypeList(MovieFlixConstants.SERIES);
	}

	//displayTitleDetails() :: method called to display Title Details.
	@RequestMapping(method = RequestMethod.GET, value = "flixshows/{title}")
	public FlixShow displayTitleDetails(@PathVariable("title") String title) {
		return service.displayTitleDetails(title);
	}
	//createShow() :: method called to Create new Title in catalog.
	@RequestMapping(method = RequestMethod.POST, value = "flixshows")
	public FlixShow createShow(@RequestBody FlixShow show) {
		return service.create(show);
	}

	//updateShow() :: method called to Update Title in catalog.
	@RequestMapping(method = RequestMethod.PUT, value = "flixshows/{showId}")
	public FlixShow updateShow(@PathVariable("showId") String showId, @RequestBody FlixShow show) {
		return service.update(showId, show);
	}
	//deleteShow() :: method called to Delete Title from catalog.
	@RequestMapping(method = RequestMethod.DELETE, value = "flixshows/{showId}")
	public void deleteShow(@PathVariable("showId") String showId) {
		service.delete(showId);
	}
	//topRatedMovies() :: method called to get list of top rated movies and Series.
	@RequestMapping(method = RequestMethod.GET, value = "flixtopshows")
	public List<FlixShow> topRatedMoviesAndSeries() {
		return service.topRatedMoviesAndSeries();
	}
	//topRatedMovies() :: method called to sort title by year, imdbrating & imdbvotes{Field Name}
	@RequestMapping(method = RequestMethod.GET, value = "flixshowsSortby/{fieldName}")
	public List<FlixShow> sortByField(@PathVariable("fieldName") String fieldName) {
		return service.sortByField(fieldName);
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "flixGenreType")
	public Genre createGenreType(@RequestBody Genre genteType) {
		return service.createGenre(genteType);
	}

	@RequestMapping(method = RequestMethod.GET, value = "titleAverageRating/{title}")
	public String showTitleAverageRating(@PathVariable("title") String title) {
		return service.showTitleAverageRating(title);
	}

	@RequestMapping(method = RequestMethod.GET, value = "userComments/{title}")
	public List<UserComments> showComments(@PathVariable("title") String title) {
		return service.showComments(title);
	}

	@RequestMapping(method = RequestMethod.POST, value = "commentOntitle")
	public UserComments addComment(@RequestBody UserComments commentVal) {
		return service.addComment(commentVal);
	}

	@RequestMapping(method = RequestMethod.POST, value = "rateshowtitle")
	public UserRatingStars giveRatings(@RequestBody UserRatingStars starRate) {
		return service.giveRatings(starRate);
	}

	@RequestMapping(method = RequestMethod.GET, value = "flixByYear/{year}")
	public List<FlixShow> findbyShowYear(@PathVariable("year") int year) {
		return service.findbyShowYear(year);
	}

	@RequestMapping(method = RequestMethod.GET, value = "flixByGenre/{gtype}")
	public List<FlixShow> findByGenreType(@PathVariable("gtype") String gtype) {
		return service.findByGenreType(gtype);
	}

	@RequestMapping(method = RequestMethod.GET, value = "genreaAll")
	public List<Genre> findAllGenreTypes() {
		return service.findAllGenre();
	}

}
