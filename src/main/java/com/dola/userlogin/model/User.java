package com.dola.userlogin.model;

public class User {
	 	private long id;
     
	    private String username;
	     
	    private String password;
	     
	    private String fullName;
	    private String dateOfBirth;
	    private String sex;
	    private String aboutYourself;
	     
	    public User(){
	        id=0;
	    }
	     
	    public User(long id, String username, String password, String fullName, String dateOfBirth, String sex, String aboutYourself){
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.fullName = fullName;
	        this.dateOfBirth = dateOfBirth;
	        this.sex = sex;
	        this.aboutYourself = aboutYourself;
	    }
	 
	   
	 
	 
	 
	    public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

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

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getAboutYourself() {
			return aboutYourself;
		}

		public void setAboutYourself(String aboutYourself) {
			this.aboutYourself = aboutYourself;
		}

		@Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (id ^ (id >>> 32));
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof User))
	            return false;
	        User other = (User) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }
	 
	    @Override
	    public String toString() {
	        return "User [id=" + id + ", username=" + username + ", address=" + fullName
	                + ", email=" + dateOfBirth + "]";
	    }
	     
}
