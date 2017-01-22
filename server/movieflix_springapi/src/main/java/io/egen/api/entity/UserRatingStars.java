package io.egen.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="UserRatingStars.findAverageRating",query="SELECT avg(e.ratings) FROM UserRatingStars e group by e.ratedTitle having e.ratedTitle=:pTitleId")
	})
public class UserRatingStars 
{
	@Id
	private String ratingId;
	private String ratedTitle;
	private double ratings;
	
	public UserRatingStars() {
		this.ratingId = UUID.randomUUID().toString();
	}
	
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String getRatedTitle() {
		return ratedTitle;
	}

	public void setRatedTitle(String ratedTitle) {
		this.ratedTitle = ratedTitle;
	}
	
}
