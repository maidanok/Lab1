package datalayer.storage;

import datalayer.datamodel.Track;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public interface TrackStorage {
    List<Track> getAllTrack() throws Exception;

    LocalTime getSize() throws IOException, ClassNotFoundException;

    void addTrack(Track track) throws IOException, ClassNotFoundException;

    void saveAllTrack(List<Track> myTracks) throws IOException, ClassNotFoundException;


}
