package com.revature.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.openpojo.business.annotation.BusinessKey;

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
@Table(name = "predictions")
public class Prediction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "prediction_id")
	private int predictionId;
	
	@NotNull
	@OneToOne
	private Team first;
	
	@NotNull
	@OneToOne
	private Team second;
	
	@NotNull
	@OneToOne
	private Team third;
	
	@NotNull
	@OneToOne
	private Team fourth;
	
	@NotNull
	@BusinessKey
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Prediction(@NotNull Team first, @NotNull Team second, @NotNull Team third, @NotNull Team fourth,
			@NotNull User predictor) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.user = predictor;
	}
	
	

}
