package com.projectposter.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectposter.DAO.Poster;
import com.projectposter.Error.ErrorMessage;
import com.projectposter.Exceptions.PosterNotUpdatedException;
import com.projectposter.Exceptions.PostingNotFoundException;
import com.projectposter.Service.PosterService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Validated
@RestController
@CrossOrigin(origins="http://localhost:3000")

public class PosterController {

	@Autowired
	PosterService posterservice;
	@Autowired
	ErrorMessage errormsg;
	
	@PostMapping(value="/post",consumes="application/json")
	public String post(@Valid @RequestBody Poster poster,Errors errors)
	{
	
	  poster.setPostedOnDate(LocalDate.now());
	  poster.setPostedOnTime(LocalTime.now());
      return posterservice.post(poster);
	  
	}
	@DeleteMapping(value="/deletebyId/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable("id") 
	@Pattern(regexp="[0-9]",message = "{Id should always be a number}")
	long id) throws PostingNotFoundException
	{
		String response=posterservice.deletebyid(id);
		return ResponseEntity.ok(response);
	}
	
	
	//GetMapping
	
	//Get all postings in DB
	
	
	@GetMapping(value="/postings",produces="application/json")
	public ResponseEntity<List<Poster>> postings()
	{
		
		List<Poster> response=posterservice.postings();
		return ResponseEntity.ok(response);
	}
	@GetMapping(value="/postingsById/{id}",produces="application/json")
	public ResponseEntity<Optional<Poster>> postingbyId(@PathVariable("id") 
	@Pattern(regexp="[0-9]",message = "{Id should always be a number}")
	long id) throws PostingNotFoundException
	{
		Optional<Poster> response=posterservice.postingbyId(id);
		return ResponseEntity.ok(response);
		
	}
	@GetMapping(value="/postingsByTitle")
	public ResponseEntity<Optional<List<Poster>>> postingsByTitle(@RequestParam("title") String title) throws PostingNotFoundException
	{
		Optional<List<Poster>> response=posterservice.postingbytitle(title);
		return ResponseEntity.ok(response);
	}
	@GetMapping(value="/postingsByAuthor")
	public ResponseEntity<Optional<List<Poster>>> postingsByAuthor(@RequestParam("author") String author) throws PostingNotFoundException
	{
		Optional<List<Poster>> response=posterservice.postingbyauthor(author);
		return ResponseEntity.ok(response);
		
	}
	
	
	//Get all titles alone as list of string
	
	@GetMapping(value="/titles")
	public ResponseEntity<List<String>> getAllTitle() throws PostingNotFoundException
	{
		List<String> result=posterservice.getallTitle();
		return ResponseEntity.ok(result);
	}
	
	
	//Get all author names as List of string
	@GetMapping(value="/authors")
	public ResponseEntity<List<String>> getallAuthors() throws PostingNotFoundException
	{
		List<String> response=posterservice.getallAuthors();
		return ResponseEntity.ok(response);
	}
	@PutMapping(value="/update")
	public ResponseEntity<String> update(@Valid @RequestBody Poster poster,Errors errors) throws PosterNotUpdatedException
	{
		
		poster.setPostedOnDate(LocalDate.now());
		poster.setPostedOnTime(LocalTime.now());
		String response=posterservice.update(poster);
		return ResponseEntity.ok(response);
		 
	}  
	
	//Put mapping for increasing rating
	
	@PutMapping(value="/update/rating/{id}")
	public void increaserating(@PathVariable("id") long id)
	{
		posterservice.increaserating(id);
	}
}
