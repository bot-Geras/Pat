package com.example.patapp.HelperClasses.HomeAdapter;

public class MostViewedHelperClass {

    int image;
    String title, review;

    public MostViewedHelperClass(int image, String title, String review) {
        this.image = image;
        this.title = title;
        this.review = review;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getReview() {
        return review;
    }
}
