package com.Rajeswari2000.BankingSystem.dto;

public class Credentials {
	 private int userId;
	  private String password;
	  
	  public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public Credentials(int userId, String password) {
			super();
			this.userId = userId;
			this.password = password;
		}
		@Override
		public String toString() {
			return "Credentials [userId=" + userId + ", password=" + password + "]";
		}
}
