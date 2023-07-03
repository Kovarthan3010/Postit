package com.projectposter.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.projectposter.DAO.Poster;
import com.projectposter.Exceptions.PosterNotUpdatedException;
import com.projectposter.Exceptions.PostingNotFoundException;

public interface PosterService {

	List < Poster > postings();
	String post(Poster poster);
	String deletebyid(long id) throws PostingNotFoundException;
	Optional<Poster> postingbyId(long id) throws PostingNotFoundException;
	Optional<List<Poster>> postingbytitle(String title) throws PostingNotFoundException;
	Optional<List<Poster>> postingbyauthor(String author) throws PostingNotFoundException;
	String update(Poster poster) throws PosterNotUpdatedException;
	List<String> getallTitle() throws PostingNotFoundException;
	List<String> getallAuthors() throws PostingNotFoundException;
	void increaserating(long id);
}
