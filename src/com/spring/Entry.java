package com.spring;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Entry{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent	 
		private String email;
		@Persistent	 
		private String patientID;
		@Persistent	 
		private String name;	
		@Persistent	 
		private String password;
		@Persistent	 
		private String special;
		@Persistent	 
		private String location;
		@Persistent	 
		private int age;
	    @Persistent	 
	    private String country;	   
		@Persistent
		private String zip;
		@Persistent
		private String blood;	
		@Persistent
		private String ailment;
		@Persistent	 
	    private String doctor;	   
		@Persistent
		private String date;
		@Persistent
		private String weight;	
		@Persistent
		private String pressure;
		@Persistent
		private String surgery;
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
		public String getSpecial() {
			return special;
		}
		public void setSpecial(String special) {
			this.special = special;
		}
		public String getPatientID() {
			return patientID;
		}
		public void setpatientID(String patientID) {
			this.patientID = patientID;
		}
		public String getemail() {
			return name;
		}
		public void setemail(String email) {
			this.email = email;
		}
		public String getpassword() {
			return name;
		}
		public void setpassword(String password) {
			this.password = password;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public String getBlood() {
			return blood;
		}
		public void setBlood(String blood) {
			this.blood = blood;
		}
		public String getProblem() {
			return ailment;
		}
		public void setProblem(String ailment) {
			this.ailment = ailment;
		}
		public String getDoctor() {
			return doctor;
		}
		public void setDoctor(String doctor) {
			this.doctor = doctor;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getWeight() {
			return weight;
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}
		public String getPressure() {
			return pressure;
		}
		public void setPressure(String pressure) {
			this.pressure = pressure;
		}
		public String getSurgery() {
			return surgery;
		}
		public void setSurgery(String surgery) {
			this.surgery = surgery;
		}
		public String getKey() {
			return key;
			}
		public void setKey(String key) {
			this.key = key;
		}
		public int getage() {
			return age;
		}
		public void setage(int age) {
			this.age = age;
		}
	}

