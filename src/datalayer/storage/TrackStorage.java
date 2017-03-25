package datalayer.storage;

import datalayer.datamodel.Track;

import java.time.LocalTime;
import java.util.List;

public interface TrackStorage {
    List<Track> getAllTrack();

    LocalTime getSize();

    void addTrack(Track track);

    void saveAllTrack(List<Track> myTracks);

    void playTracks();


}
