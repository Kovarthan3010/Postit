package com.projectposter.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterRepo extends JpaRepository<Poster,Long>{

	@Query
	Optional<List<Poster>> findByTitle(String title);
	
	@Query
	Optional<List<Poster>> findByAuthor(String author);
	
	@Query("select title t from Poster t ")
	Optional<List<String>> findAllTitle();
	
	@Query("select author a from Poster a")
	Optional<List<String>> getallAuthors();
	
    @Modifying
	@Query("update Poster R set R.rating=R.rating+1 where R.id=:posterid")
	void increaselikecount(long posterid);
}
