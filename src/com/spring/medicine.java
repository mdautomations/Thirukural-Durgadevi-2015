package com.spring;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class medicine{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent	 
		private String medicinename;
		@Persistent	 
		private String medicineid;
		@Persistent	 
		private String composition;	
		@Persistent	 
		private String expiry;
		@Persistent	 
		private String quantity;
		
		
		public String getkey() {
			return key;
		}
		public void setkey(String key) {
			this.key = key;
		}
		public String getmedicinename() {
			return medicinename;
		}
		public void setmedicinename(String medicinename) {
			this.medicinename = medicinename;
		}
		public String getmedicineid() {
			return medicineid;
		}
		public void setmedicineid(String medicineid) {
			this.medicineid = medicineid;
		}
		public String getcomposition() {
			return composition;
		}
		public void setcomposition(String composition) {
			this.composition = composition;
		}
		public String getexpiry() {
			return expiry;
		}
		public void setexpiry(String expiry) {
			this.expiry = expiry;
		}
		public String getquantity() {
			return quantity;
		}
		public void setquantity(String quantity) {
			this.quantity = quantity;
		}
//		public String getCountry() {
//			return country;
//		}
//		public void setCountry(String country) {
//			this.country = country;
//		}
//		
	}

