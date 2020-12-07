package com.example.service_novigrad.ui.customer;

public class RatingClass {
    private String message;
    private float stars;
    public RatingClass(){
    }
    public RatingClass(String message, float stars){
        this.message =message;
        this.stars = stars;
    }

    public String getMessage() {
        return message;
    }

    public float getStars() {
        return stars;
    }
}
