package com.pokemonteambuilder.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotEmpty(message="Please Enter a team title")
	@Size(min = 1, max = 32, message="Title must be at 1 character long")
	private String title;
	
	private String pokemon1;
	
	private String pokemon2;
	
	private String pokemon3;
	
	private String pokemon4;
	
	private String pokemon5;
	
	private String pokemon6;
	
	
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="user_id")
//    private User user;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	public Team() {
	}

	public Team(String title, String pokemon1, String pokemon2, String pokemon3, String pokemon4, String pokemon5, String pokemon6, User user) {
		this.title = title;
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
		this.pokemon3 = pokemon3;
		this.pokemon4 = pokemon4;
		this.pokemon5 = pokemon5;
		this.pokemon6 = pokemon6;
//		this.user = user;
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

	public String getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(String pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public String getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(String pokemon2) {
		this.pokemon2 = pokemon2;
	}
	
	public String getPokemon3() {
		return pokemon3;
	}

	public void setPokemon3(String pokemon3) {
		this.pokemon3 = pokemon3;
	}
	
	public String getPokemon4() {
		return pokemon4;
	}

	public void setPokemon4(String pokemon4) {
		this.pokemon4 = pokemon4;
	}
	
	public String getPokemon5() {
		return pokemon5;
	}

	public void setPokemon5(String pokemon5) {
		this.pokemon5 = pokemon5;
	}
	
	public String getPokemon6() {
		return pokemon6;
	}

	public void setPokemon6(String pokemon6) {
		this.pokemon6 = pokemon6;
	}

//	public User getUser() {
//		return user;
//	}

//	public void setUser(User user) {
//		this.user = user;
//	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
