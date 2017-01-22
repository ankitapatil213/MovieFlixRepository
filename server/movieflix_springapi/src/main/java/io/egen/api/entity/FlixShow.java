package io.egen.api.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "FlixShow.findAll", query = "SELECT e FROM FlixShow e"),
		@NamedQuery(name = "FlixShow.showType", query = "SELECT e FROM FlixShow e where e.sType=:pType"),
		@NamedQuery(name = "FlixShow.findByTitle", query = "SELECT e FROM FlixShow e WHERE e.title=:title"),
		@NamedQuery(name = "FlixShow.topRated", query = "SELECT e.showId,e.title,e.poster FROM FlixShow e WHERE e.imdbRating >= :imdbRating"),
		@NamedQuery(name = "FlixShow.findbyYear", query = "SELECT e FROM FlixShow e WHERE e.sYear=:year"),
		@NamedQuery(name = "FlixShow.findByGenreType", query = "SELECT e FROM FlixShow e WHERE e.titleGenre LIKE CONCAT('%',:genre,'%')") })

public class FlixShow {
	@Id
	private String showId;
	@Column(unique = true)
	private String title;
	private int sYear;
	private String rated;
	private Date released;
	private String runtime;
	private String titleGenre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String sLanguage;
	private String country;
	private String awards;
	private String poster;
	private int metaScore;
	private float imdbRating;
	private long imdbVotes;
	private String imdbId;
	private String sType;

	@OneToMany
	private List<UserRatingStars> titleUserRating;

	@OneToMany
	private List<UserComments> titleComment;

	public FlixShow() {
		this.showId = UUID.randomUUID().toString();
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public Date getReleased() {
		return released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getTitleGenre() {
		return titleGenre;
	}

	public void setTitleGenre(String titleGenre) {
		this.titleGenre = titleGenre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public long getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public int getsYear() {
		return sYear;
	}

	public void setsYear(int sYear) {
		this.sYear = sYear;
	}

	public String getsLanguage() {
		return sLanguage;
	}

	public void setsLanguage(String sLanguage) {
		this.sLanguage = sLanguage;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public List<UserComments> getTitleComment() {
		return titleComment;
	}

	public void setTitleComment(List<UserComments> titleComment) {
		this.titleComment = titleComment;
	}

	public List<UserRatingStars> getTitleUserRating() {
		return titleUserRating;
	}

	public void setTitleUserRating(List<UserRatingStars> titleUserRating) {
		this.titleUserRating = titleUserRating;
	}
}
