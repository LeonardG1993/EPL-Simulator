package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@RequiredArgsConstructor
@AllArgsConstructor
@Table (name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "user_id")
	private int id;
	
	@NotNull
	private String username;
	
	@NotNull
	@NonNull
	private String password;
	
	@NotNull
	@NonNull
	private int score;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Prediction> predictions = new ArrayList<>();

	public User(@NotNull String username, @NotNull @NonNull String password, @NotNull @NonNull int score) {
		super();
		this.username = username;
		this.password = password;
		this.score = score;
	}
	
	

}
