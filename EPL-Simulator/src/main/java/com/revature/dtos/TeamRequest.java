package com.revature.dtos;

import javax.validation.constraints.NotNull;
import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
	
	private int teamId;
	
	@NotNull
	@BusinessKey
	private String name;
	
	@NotNull
	@BusinessKey
	private int points;
	
	@NotNull
	@BusinessKey
	private int wins;
	
	@NotNull
	@BusinessKey
	private int draws;
	
	@NotNull
	@BusinessKey
	private int losses;
	
	@NotNull
	@BusinessKey
	private double winRate;
	
	@NotNull
	@BusinessKey
	private double drawRate;
	
	@NotNull
	@BusinessKey
	private double lossRate;
	
	@Override
    public String toString() { return BusinessIdentity.toString(this); }

    @Override
    public boolean equals(final Object o) { return BusinessIdentity.areEqual(this, o); }

    @Override
    public int hashCode() { return BusinessIdentity.getHashCode(this); }

}
