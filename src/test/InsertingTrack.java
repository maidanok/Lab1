package test;

import datalayer.datamodel.Rock;
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

        Track track = new Rock();
        List<Track> myTrack = new ArrayList<>();
/*
        track.setName("Cold Water");
        track.setSinger("Theory Of A Deadman");
        track.setSize("00:03:02");
        track.setRating(5);
        trackStorage.addTrack(track);
*/


        for (int i = 0; i < trackStorage.getAllTrack().size(); i++) {
            System.out.println(trackStorage.getAllTrack().get(i));
        }
        System.out.println(trackStorage.getSize());

        trackStorage.playTracks();
    }
}
