package test;

import java.io.IOException;
import java.util.List;

import datalayer.datamodel.Track;
import datalayer.storage.TrackStorage;
import datalayer.storage.TrackStorageImpl;
import logic.sort_service.SortedBySize;

public class testTrack {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        TrackStorage trackStorage = new TrackStorageImpl();
        List<Track> myTrack = null;
        try {
            myTrack = trackStorage.getAllTrack();
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < myTrack.size(); i++) {
            System.out.println(myTrack.get(i));
        }

        System.out.println();

        myTrack.sort(new SortedBySize());

        for (int i = 0; i < myTrack.size(); i++) {
            System.out.println(myTrack.get(i));
        }


        trackStorage.saveAllTrack(myTrack);
    }

}
