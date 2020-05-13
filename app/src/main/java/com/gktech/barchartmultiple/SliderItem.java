package com.gktech.barchartmultiple;

public class SliderItem {

    private String description;

    public SliderItem(String description, int imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
    }

    private int imageUrl;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
