package com.revature.dtos;

import javax.validation.constraints.NotNull;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;
import com.revature.models.Team;
import com.revature.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PredictionRequest {
	
	
	private int predictionId;
	
	@NotNull
	@BusinessKey
	private Team first;
	
	@NotNull
	@BusinessKey
	private Team second;
	
	@NotNull
	@BusinessKey
	private Team third;
	
	@NotNull
	@BusinessKey
	private Team fourth;
	
	@NotNull
	@BusinessKey
	private User user;
	
	@Override
    public String toString() { return BusinessIdentity.toString(this); }

    @Override
    public boolean equals(final Object o) { return BusinessIdentity.areEqual(this, o); }

    @Override
    public int hashCode() { return BusinessIdentity.getHashCode(this); }

}
