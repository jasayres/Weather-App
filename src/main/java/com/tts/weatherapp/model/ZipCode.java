package com.tts.weatherapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZipCode {
    

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long search_id;
    private String zipCode;

    public ZipCode(){}

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return zipCode ;
    }
    


}
