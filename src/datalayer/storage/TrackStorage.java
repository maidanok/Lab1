package datalayer.storage;

import java.io.IOException;
import java.util.List;

import datalayer.datamodel.Track;

public interface TrackStorage {
    List<Track> getAllTrack() throws Exception;

    void addTrack(Track track) throws IOException, ClassNotFoundException;

    void saveAllTrack(List<Track> myTracks) throws IOException, ClassNotFoundException;
}
