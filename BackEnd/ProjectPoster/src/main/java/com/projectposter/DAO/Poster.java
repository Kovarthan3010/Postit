package com.projectposter.DAO;

import java.time.LocalDate;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;

@Entity

@Table(name="Postertable")
@Valid
public class Poster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="Title",nullable=false)
	private String title;
	@Column(name="Author",nullable=false)
	private String author;
	@Column(name="Items",nullable=false)
	private String items;
	@Column(name="PostedonDate")
	
	private LocalDate postedOnDate;
	@Column(name="PostedonTime")
	
	private LocalTime postedOnTime;
	@Column(name="Rating")
		private int rating;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public LocalDate getPostedOnDate() {
		return postedOnDate;
	}
	public void setPostedOnDate(LocalDate postedOnDate) {
		this.postedOnDate = postedOnDate;
	}
	
	public LocalTime getPostedOnTime() {
		return postedOnTime;
	}
	public void setPostedOnTime(LocalTime postedOnTime) {
		this.postedOnTime = postedOnTime;
	}
}
