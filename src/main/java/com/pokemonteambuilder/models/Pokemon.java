package com.pokemonteambuilder.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pokemon")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nameEnglish;
	
	private String nameJapanese;
	
	private String nameFrench;
	
	private String nameGerman;
	
	private String nameKorean;
	
	private String pokedexNumber;
	
	private String genderRatio;
	
	private String type;
	
	private String ability1;
	
	private String ability2;
	
	private String ability3;
	
	private String classification;
	
	private String height;
	
	private String weight;
	
	private String hp;
	
	private String attack;
	
	private String defense;
	
	private String specialAttack;
	
	private String specialDefense;
	
	private String speed;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="team_id")
	private Box pokemonTeam;

	public Pokemon(String nameEnglish, String nameJapanese, String nameFrench, String nameGerman, String nameKorean,
			String pokedexNumber, String genderRatio, String type, String ability1, String ability2, String ability3,
			String classification, String height, String weight, String hp, String attack, String defense,
			String specialAttack, String specialDefense, String speed) {
		this.nameEnglish = nameEnglish;
		this.nameJapanese = nameJapanese;
		this.nameFrench = nameFrench;
		this.nameGerman = nameGerman;
		this.nameKorean = nameKorean;
		this.pokedexNumber = pokedexNumber;
		this.genderRatio = genderRatio;
		this.type = type;
		this.ability1 = ability1;
		this.ability2 = ability2;
		this.ability3 = ability3;
		this.classification = classification;
		this.height = height;
		this.weight = weight;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
	}
	
	
	public Pokemon() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public String getNameJapanese() {
		return nameJapanese;
	}

	public void setNameJapanese(String nameJapanese) {
		this.nameJapanese = nameJapanese;
	}

	public String getNameFrench() {
		return nameFrench;
	}

	public void setNameFrench(String nameFrench) {
		this.nameFrench = nameFrench;
	}

	public String getNameGerman() {
		return nameGerman;
	}

	public void setNameGerman(String nameGerman) {
		this.nameGerman = nameGerman;
	}

	public String getNameKorean() {
		return nameKorean;
	}

	public void setNameKorean(String nameKorean) {
		this.nameKorean = nameKorean;
	}

	public String getPokedexNumber() {
		return pokedexNumber;
	}

	public void setPokedexNumber(String pokedexNumber) {
		this.pokedexNumber = pokedexNumber;
	}

	public String getGenderRatio() {
		return genderRatio;
	}

	public void setGenderRatio(String genderRatio) {
		this.genderRatio = genderRatio;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAbility1() {
		return ability1;
	}

	public void setAbility1(String ability1) {
		this.ability1 = ability1;
	}

	public String getAbility2() {
		return ability2;
	}

	public void setAbility2(String ability2) {
		this.ability2 = ability2;
	}

	public String getAbility3() {
		return ability3;
	}

	public void setAbility3(String ability3) {
		this.ability3 = ability3;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getDefense() {
		return defense;
	}

	public void setDefense(String defense) {
		this.defense = defense;
	}

	public String getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(String specialAttack) {
		this.specialAttack = specialAttack;
	}

	public String getSpecialDefense() {
		return specialDefense;
	}

	public void setSpecialDefense(String specialDefense) {
		this.specialDefense = specialDefense;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	
	
	
	
	
	

}
