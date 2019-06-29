package com.revature.pojo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ReimburseForm {

	private Integer formId;

	private Integer employeeID;

	private Date startDate;
	
	private Date endDate;

	private Time form_time;

	private String address;

	private String description;

	private Double course_cost;

	private String grading_format;
	
	private String passing_grade;

	private String events;

	private String justification;

	private String event_attachment;

	public ReimburseForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimburseForm(Integer formId, Integer employeeID, Date startDate, Date endDate, Time form_time, String address,
			String description, Double course_cost, String grading_format, String passing_grade, String events,
			String justification, String event_attachment) {
		super();
		this.formId = formId;
		this.employeeID = employeeID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.form_time = form_time;
		this.address = address;
		this.description = description;
		this.course_cost = course_cost;
		this.grading_format = grading_format;
		this.passing_grade = passing_grade;
		this.events = events;
		this.justification = justification;
		this.event_attachment = event_attachment;
	}

	public ReimburseForm(Integer employeeID, Date startDate, Date endDate, String events, String address,
			String description, Double course_cost, String grading_format, String passing_grade, String justification) {
		super();
		this.employeeID = employeeID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.description = description;
		this.course_cost = course_cost;
		this.grading_format = grading_format;
		this.passing_grade = passing_grade;
		this.events = events;
		this.justification = justification;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setForm_date(Date form_date) {
		this.startDate = form_date;
	}

	public Time getForm_time() {
		return form_time;
	}

	public void setForm_time(Time form_time) {
		this.form_time = form_time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCourse_cost() {
		return course_cost;
	}

	public void setCourse_cost(Double course_cost) {
		this.course_cost = course_cost;
	}

	public String getGrading_format() {
		return grading_format;
	}

	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}

	public String getPassing_grade() {
		return passing_grade;
	}

	public void setPassing_grade(String passing_grade) {
		this.passing_grade = passing_grade;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getEvent_attachment() {
		return event_attachment;
	}

	public void setEvent_attachment(String event_attachment) {
		this.event_attachment = event_attachment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((course_cost == null) ? 0 : course_cost.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employeeID == null) ? 0 : employeeID.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((event_attachment == null) ? 0 : event_attachment.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((formId == null) ? 0 : formId.hashCode());
		result = prime * result + ((form_time == null) ? 0 : form_time.hashCode());
		result = prime * result + ((grading_format == null) ? 0 : grading_format.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((passing_grade == null) ? 0 : passing_grade.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimburseForm other = (ReimburseForm) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (course_cost == null) {
			if (other.course_cost != null)
				return false;
		} else if (!course_cost.equals(other.course_cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (event_attachment == null) {
			if (other.event_attachment != null)
				return false;
		} else if (!event_attachment.equals(other.event_attachment))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (formId == null) {
			if (other.formId != null)
				return false;
		} else if (!formId.equals(other.formId))
			return false;
		if (form_time == null) {
			if (other.form_time != null)
				return false;
		} else if (!form_time.equals(other.form_time))
			return false;
		if (grading_format == null) {
			if (other.grading_format != null)
				return false;
		} else if (!grading_format.equals(other.grading_format))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (passing_grade == null) {
			if (other.passing_grade != null)
				return false;
		} else if (!passing_grade.equals(other.passing_grade))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimburseForm [formId=" + formId + ", employeeID=" + employeeID + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", form_time=" + form_time + ", address=" + address + ", description="
				+ description + ", course_cost=" + course_cost + ", grading_format=" + grading_format
				+ ", passing_grade=" + passing_grade + ", events=" + events + ", justification=" + justification
				+ ", event_attachment=" + event_attachment + "]";
	}
	
	

}
