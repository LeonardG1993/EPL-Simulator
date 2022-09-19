package com.revature.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "team_id")
	private int teamId;
	
	@NotNull
	private String name;
	
	@NotNull
	private int points;
	
	@NotNull
	private int wins;
	
	@NotNull
	private int draws;
	
	@NotNull
	private int losses;
	
	@NotNull
	private double winRate;
	
	@NotNull
	private double drawRate;
	
	@NotNull
	private double lossRate;

	public Team(@NotNull String name, @NotNull double winRate, @NotNull double drawRate, @NotNull double lossRate) {
		super();
		this.name = name;
		this.winRate = winRate;
		this.drawRate = drawRate;
		this.lossRate = lossRate;
	}
	
	

}
