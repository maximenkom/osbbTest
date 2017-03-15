package com.osbbTest.dto;

import javax.persistence.Column;

public class UserDTO {
	
		private Long houseId;

	    private String firstname;	    
	  
	    private String lastname; 
	    
	    private String password;	   
		
	    private String email;
	    
	    private boolean enabled;		

		private int roomNumber;		
		

		public UserDTO(Long house_id, String firstname, String lastname, String password, String email,	int roomNumber) {
			super();
			this.houseId = house_id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.password = password;
			this.email = email;
			this.roomNumber = roomNumber;
		}

		public UserDTO() {		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		
		public Long getHouseId() {
			return houseId;
		}

		public void setHouseId(Long houseId) {
			this.houseId = houseId;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getRoomNumber() {
			return roomNumber;
		}

		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}	
		
		

}
