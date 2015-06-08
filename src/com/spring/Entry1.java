package com.spring;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Entry1{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent	 
		private String doctoremail;
		@Persistent	 
		private String doctorID;
		@Persistent	 
		private String doctorname;	
		@Persistent	 
		private String specialization;
		@Persistent	 
		private String address;
		
		
		public String getkey() {
			return key;
		}
		public void setkey(String key) {
			this.key = key;
		}
		public String getdoctoremail() {
			return doctoremail;
		}
		public void setdoctoremail(String doctoremail) {
			this.doctoremail = doctoremail;
		}
		public String getdoctorID() {
			return doctorID;
		}
		public void setdoctorID(String doctorID) {
			this.doctorID = doctorID;
		}
		public String getdoctorname() {
			return doctorname;
		}
		public void setdoctorname(String doctorname) {
			this.doctorname = doctorname;
		}
		public String getspecialization() {
			return specialization;
		}
		public void setspecialization(String specialization) {
			this.specialization = specialization;
		}
		public String getaddress() {
			return address;
		}
		public void setLocation(String address) {
			this.address = address;
		}
//		public String getCountry() {
//			return country;
//		}
//		public void setCountry(String country) {
//			this.country = country;
//		}
//		
	}

