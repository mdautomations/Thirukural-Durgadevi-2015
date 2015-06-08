package com.spring;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Search{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent	 
		private String name;	
		@Persistent	 
		private String searchedTerm;	
	  
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
		public String getsearchedTerm() {
			return searchedTerm;
		}
		public void searchedTerm(String searchedTerm) {
			this.searchedTerm = searchedTerm;
		}
		public String getkey() {
			return key;
		}
		public void setkey(String key) {
			this.key = key;
		}
		
	}

