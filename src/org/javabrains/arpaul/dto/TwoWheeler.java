package org.javabrains.arpaul.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {

	private String sterringHandle;

	public String getSterringHandle() {
		return sterringHandle;
	}

	public void setSterringHandle(String sterringHandle) {
		this.sterringHandle = sterringHandle;
	}
	
}
