package com.schoolcasa.model;

import javax.persistence.*;

@Entity
@Table
public class Preferences {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String foodPref;
    private String studyTime;
    private String isSmoking;
    private String isPetFriendly;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getFoodPref() {
		return foodPref;
	}

	public void setFoodPref(String foodPref) {
		this.foodPref = foodPref;
	}

	public String getIsStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getIsSmoking() {
		return isSmoking;
	}

	public void setSmoking(String isSmoking) {
		this.isSmoking = isSmoking;
	}

	public String getIsPetFriendly() {
		return isPetFriendly;
	}

	public void setPetFriendly(String isPetFriendly) {
		this.isPetFriendly = isPetFriendly;
	}

   
}
