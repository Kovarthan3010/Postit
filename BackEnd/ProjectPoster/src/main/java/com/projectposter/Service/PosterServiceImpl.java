package com.projectposter.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectposter.DAO.Poster;
import com.projectposter.DAO.PosterRepo;
import com.projectposter.Exceptions.PosterNotUpdatedException;
import com.projectposter.Exceptions.PostingNotFoundException;

@Service
public class PosterServiceImpl implements PosterService {

	@Autowired
	PosterRepo posterrepo;
	@Override
	public List<Poster> postings() {
		// TODO Auto-generated method stub
		return posterrepo.findAll();
	}
	@Override
	@Transactional
	public String post(Poster poster) {
		// TODO Auto-generated method stub
		 posterrepo.save(poster);
		 return "Poster added successfully";
	}
	@Override
	@Transactional
	public String deletebyid(long id) throws PostingNotFoundException{
		// TODO Auto-generated method stub
		Optional<Poster> post=posterrepo.findById(id);
		if(post.isEmpty())
		{
			throw new PostingNotFoundException("Posting with Id : "+id+" doesnot exist . So delete action failed!!!");
		}
		posterrepo.deleteById(id);
		return "Poster deleted successfully";
		
	}
	@Override
	public Optional<Poster> postingbyId(long id) throws PostingNotFoundException {
		// TODO Auto-generated method stub
		Optional<Poster> poster=posterrepo.findById(id);
		if(!poster.isPresent())
		{
			throw new PostingNotFoundException("Posting with Id : "+id+" doesnot exist");
		}
		else
		{
		return posterrepo.findById(id);
		}
	}
	@Override
	public Optional<List<Poster>> postingbytitle(String title) throws PostingNotFoundException {
		// TODO Auto-generated method stub
		Optional<List<Poster>> response=posterrepo.findByTitle(title);
		if(response.get().size()==0)
		{
			throw new PostingNotFoundException("Posting with given title :"+title+" is not present!!!");
		}
		else
		{
			return response;
		}
		
	}
	@Override
	public Optional<List<Poster>> postingbyauthor(String author) throws PostingNotFoundException {
		// TODO Auto-generated method stub
		Optional<List<Poster>> response=posterrepo.findByAuthor(author);
		if(response.get().size()==0)
		{
			throw new PostingNotFoundException("Postings written by author :"+author+" doesnot exist!!!");
		}
		else
		{
			return response;
		}
		
	}
	@Override
	@Transactional
	public String update(Poster poster) throws PosterNotUpdatedException {
		// TODO Auto-generated method stub
		Optional<Poster> post=posterrepo.findById(poster.getId());
		if(post.isPresent())
		{
	    posterrepo.deleteById(poster.getId());
		posterrepo.save(poster);
		}
		else
		{
			throw new PosterNotUpdatedException("Poster with ID " +poster.getId()+" is not present . Please check the Id!!!");
		}
	    return "Poster updated successfully:)!!!";
	}
	@Override
	public List<String> getallTitle() throws PostingNotFoundException {
		// TODO Auto-generated method stub
		Optional<List<String>> result=posterrepo.findAllTitle();
		
		if(result.isEmpty())
		{
			throw new PostingNotFoundException("There are no posts available");
		}
		else {
			List<String> finalresult=result.get();
		return finalresult;
		}
	}
	@Override
	public List<String> getallAuthors() throws PostingNotFoundException {
		// TODO Auto-generated method stub
		Optional<List<String>> result=posterrepo.getallAuthors();
		if(result.isEmpty())
		{
			throw new PostingNotFoundException("There are no posts available");
		}
		else
		{
			List<String> finalresult=result.get();
			return finalresult;
		}
		
	}
	@Override
	@Transactional
	public synchronized void increaserating(long id) {
		// TODO Auto-generated method stub
//		Optional<Poster> poster=posterrepo.findById(id);
//		
//		Poster post=new Poster();
//		
//		
//		post.setAuthor(poster.get().getAuthor());
//		post.setItems(poster.get().getItems());
//		post.setPostedOnDate(poster.get().getPostedOnDate());
//		post.setPostedOnTime(poster.get().getPostedOnTime());
//		post.setRating(poster.get().getRating()+1);
//		post.setTitle(poster.get().getTitle());
//		
//		posterrepo.deleteById(id);
//		
//
//		
//		posterrepo.save(post);
		
		posterrepo.increaselikecount(id);	}

}
