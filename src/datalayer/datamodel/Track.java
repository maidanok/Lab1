package datalayer.datamodel;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Track implements Serializable {

    private String name;
    private String singer;
    private LocalTime size;
    private Integer rating;
    String style;
    String melody;

    public String getStyle() {
        return style;
    }

    public String getMelody() {
        return melody;
    }

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

    public LocalTime getSize() {
        return size;
    }

    public void setSize(String string) {
        this.size = LocalTime.parse(string, DateTimeFormatter.ISO_LOCAL_TIME);
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
