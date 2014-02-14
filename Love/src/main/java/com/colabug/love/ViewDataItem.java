package com.colabug.love;

public class ViewDataItem
{
    private String title = "Error";
    private int imageId = 0;

    public ViewDataItem (String title,
                         int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle ()
    {
        return title;
    }

    public int getImageId ()
    {
        return imageId;
    }
}
