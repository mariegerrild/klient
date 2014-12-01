package model;

import java.sql.Date;

import org.joda.time.DateTime;

public class Appointment {

	private int calendarId;
	private String title;
	private Date startDate;
	private Date endDate;
	private String note;
	private String location;
	private boolean active;
	private int userId;

	public int getCalendarid() {
		return calendarId;
	}
	public void setCalendarid(int calendarId) {
		this.calendarId = calendarId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}