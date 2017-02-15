package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.FlixShow;
import io.egen.api.entity.Genre;
import io.egen.api.entity.UserComments;
import io.egen.api.entity.UserRatingStars;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.ShowRepository;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	private ShowRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<FlixShow> findAllShowList() {
		return repository.findAllShowList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlixShow> findTypeList(String sType) {
		return repository.findTypeList(sType);
	}

	@Override
	@Transactional
	public FlixShow create(FlixShow show) {
		FlixShow existingTitle = repository.findByTitle(show.getTitle());
		if (existingTitle != null) {
			throw new BadRequestException("Title already Exist");
		}
		return repository.create(show);

	}

	@Override
	@Transactional
	public Genre createGenre(Genre genreType) {
		Genre existingGenre = repository.findGenreType(genreType.getgType());
		if (existingGenre != null) {
			throw new BadRequestException("Type already Exist");
		}
		return repository.createGenre(genreType);
	}

	@Override
	@Transactional
	public FlixShow update(String showId, FlixShow show) {
		FlixShow existingTitle = repository.findOne(showId);
		if (existingTitle == null) {
			throw new EntityNotFoundException("Title does not exist");
		}
		return repository.update(show);

	}

	@Override
	@Transactional
	public void delete(String showId) {
		FlixShow existingTitle = repository.findOne(showId);
		if (existingTitle == null) {
			throw new EntityNotFoundException("Title does not exist");
		}
		repository.delete(existingTitle);

	}

	@Override
	@Transactional(readOnly = true)
	public FlixShow displayTitleDetails(String titleId) {
		return repository.findByTitle(titleId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlixShow> topRatedMoviesAndSeries() {
		return repository.topRatedMoviesAndSeries();
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlixShow> sortByField(String fieldName) {
		return repository.sortByField(fieldName);
	}

	@Override
	@Transactional(readOnly = true)
	public String showTitleAverageRating(String title) {
		return repository.showTitleAverageRating(title);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserComments> showComments(String title) {
		return repository.showComments(title);
	}

	@Override
	@Transactional
	public UserComments addComment(UserComments cmnt) {
		return repository.addComment(cmnt);
	}

	@Override
	@Transactional
	public UserRatingStars giveRatings(UserRatingStars urating) {
		return repository.giveRatings(urating);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlixShow> findbyShowYear(int year) {
		return repository.findbyShowYear(year);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Genre> findAllGenre() {
		return repository.findAllGenre();
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlixShow> findByGenreType(String type) {
		return repository.findByGenreType(type);
	}

}
