package test;

import datalayer.datamodel.Rock;
import datalayer.datamodel.Track;

/**
 * Created by Admin on 24.03.2017.
 */
public class TestNewTrack {

    public static void main(String[] args) {
        Track track = new Rock();
        track.setName("name");
        track.setSinger("singer");
        track.setSize("03:40:20");
        track.setRating(3);

        System.out.println(track);
    }
}
