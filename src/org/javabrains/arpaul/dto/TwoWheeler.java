package org.javabrains.arpaul.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {

	private String sterringHandle;

	public String getSterringHandle() {
		return sterringHandle;
	}

	public void setSterringHandle(String sterringHandle) {
		this.sterringHandle = sterringHandle;
	}
	
}
