package com.schoolcasa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table
public class Messages {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String subject;
	    private String message;
	    private String sender;
	    private String reciever;
	    private int    apartmentId;
	    private int    readFlag; 
	    private int    userId;
	    
	    
	    @CreatedDate
	    private Date timestamp;
	    
	    


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public String getSubject() {
			return subject;
		}


		public void setSubject(String subject) {
			this.subject = subject;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		public String getSender() {
			return sender;
		}


		public void setSender(String sender) {
			this.sender = sender;
		}


		public String getReciever() {
			return reciever;
		}


		public void setReciever(String reciever) {
			this.reciever = reciever;
		}


		public Date getTimestamp() {
			return timestamp;
		}


		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}


		public int getApartmentId() {
			return apartmentId;
		}


		public void setApartmentId(int apartmentId) {
			this.apartmentId = apartmentId;
		}


		public int getReadFlag() {
			return readFlag;
		}


		public void setReadFlag(int readFlag) {
			this.readFlag = readFlag;
		}
	    
		
	    

}
