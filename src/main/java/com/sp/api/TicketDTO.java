package com.sp.api;

public class TicketDTO {
	
	private String endUser;
	private String serviceProvider;
	private String ticketSummary;
	private int ticketID;
	public String getEndUser() {
		return endUser;
	}
	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public String getTicketSummary() {
		return ticketSummary;
	}
	public void setTicketSummary(String ticketSummary) {
		this.ticketSummary = ticketSummary;
	}
	@Override
	public String toString() {
		return "TicketDTO [endUser=" + endUser + ", serviceProvider=" + serviceProvider + ", ticketSummary="
				+ ticketSummary + ", ticketID=" + ticketID + "]";
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
}
