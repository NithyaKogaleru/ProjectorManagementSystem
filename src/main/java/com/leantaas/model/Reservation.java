package com.leantaas.model;

import java.util.Date;

/**
 * @author Nithya Kogaleru POJO for reservation availability.
 */
public class Reservation {

	private boolean isAvailable;
	private Date startTime;
	private Date endTime;
	private Projector projector;

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Projector getProjector() {
		return projector;
	}

	public void setProjector(Projector projector) {
		this.projector = projector;
	}
}
