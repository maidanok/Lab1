package datalayer.datamodel;

import java.io.Serializable;

public class Track implements Serializable {

    private String name;
    private String singer;
    private String style;
    private Integer size;
    private Integer rating;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Track [name=" + name + ", singer=" + singer + ", style=" + style + 
               ", size=" + size + ", rating=" + rating + "]";
    }

}
