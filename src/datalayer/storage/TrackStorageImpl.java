package datalayer.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datalayer.datamodel.Track;

public class TrackStorageImpl implements TrackStorage {
    DataConnector dataConnector = new DataConnectorImpl();


    //выдача полного списка треков
    @Override
    public List<Track> getAllTrack() throws IOException, ClassNotFoundException {
        List<Track> allTrack = new ArrayList<>();
        allTrack = (List<Track>) dataConnector.readData();
        return allTrack;
    }


    //добавление трека и выдача полного списка
    @Override
    public void addTrack(Track track) throws IOException, ClassNotFoundException {
        List<Track> allTrack = new ArrayList<>();
        allTrack = (List<Track>) dataConnector.readData();
        allTrack.add(track);
        dataConnector.saveData(allTrack);
    }


    //сохранение списка треков
    @Override
    public void saveAllTrack(List<Track> myTracks) throws IOException, ClassNotFoundException {
        dataConnector.saveData(myTracks);
    }

}
