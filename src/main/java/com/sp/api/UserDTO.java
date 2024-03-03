package com.sp.api;

public class UserDTO {
	private String username;
	private String password;
	private String jobTitle;
	private boolean enabled;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", jobTitle=" + jobTitle + ", enabled="
				+ enabled + "]";
	}

}
