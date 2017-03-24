package test;

import datalayer.datamodel.Track;
import datalayer.storage.TrackStorage;
import datalayer.storage.TrackStorageImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pasha on 23.03.2017.
 */
public class InsertingTrack {
    public static void main(String[] args) throws Exception {
        TrackStorage trackStorage = new TrackStorageImpl();

        Track track = new Track();
        List<Track> myTrack=new ArrayList<>();
/*
        track.setName("Nuthin' But A 'G' Thang");
        track.setSinger("Snoop Dogg & Dr. Dre");
        track.setStyle("рэп");
        track.setSize("00:03:55");
        track.setRating(5);
        myTrack.add(track);
        trackStorage.addTrack(track);

*/
        for (int i = 0; i < trackStorage.getAllTrack().size(); i++) {
            System.out.println(trackStorage.getAllTrack().get(i));
        }
        System.out.println(trackStorage.getSize());
    }
}
