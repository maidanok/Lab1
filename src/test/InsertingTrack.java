package test;

import datalayer.datamodel.Track;
import datalayer.storage.TrackStorage;
import datalayer.storage.TrackStorageImpl;

import java.io.IOException;
import java.util.List;

/**
 * Created by Pasha on 23.03.2017.
 */
public class InsertingTrack {
    public static void main(String[] args) throws Exception {
        TrackStorage trackStorage = new TrackStorageImpl();

        Track track = new Track();
/*
        track.setName("Снег");
        track.setSinger("Tracktor Bowling");
        track.setStyle("рок");
        track.setSize(548);
        track.setRating(5);

        trackStorage.addTrack(track);

*/
        for (int i = 0; i < trackStorage.getAllTrack().size(); i++) {
            System.out.println(trackStorage.getAllTrack().get(i));
        }
    }
}
