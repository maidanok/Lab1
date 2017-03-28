package datalayer.storage;

import datalayer.datamodel.Track;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TrackStorageImpl implements TrackStorage {
    private DataConnector dataConnector = DataConnectorImpl.getInstance();
    private List<Track> myTracks;

    public TrackStorageImpl() {
        try {
            myTracks = this.getAllTrack();
        } catch (NullPointerException e) {
            e.printStackTrace();
            myTracks = new ArrayList<>();
        }
    }

    public TrackStorageImpl(List<Track> myTracks) {
        this.myTracks = myTracks;
    }

    //выдача полного списка треков
    @Override
    public List<Track> getAllTrack() {
        try {
            myTracks = (List<Track>) dataConnector.readData();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return myTracks;
    }

    @Override
    public LocalTime getSize() {
        LocalTime size;
        size = LocalTime.parse("00:00:00", DateTimeFormatter.ISO_LOCAL_TIME);
        for (Track track : myTracks) {
            size = size.plusMinutes(track.getSize().getMinute()).plusSeconds(track.getSize().getSecond());
        }
        return size;
    }


    //добавление трека и выдача полного списка
    @Override
    public void addTrack(Track track) {
        List<Track> allTrack = new ArrayList<>();
        allTrack = (List<Track>) dataConnector.readData();
        allTrack.add(track);
        dataConnector.saveData(allTrack);
    }


    //сохранение списка треков
    @Override
    public void saveAllTrack(List<Track> myTracks) {
        dataConnector.saveData(myTracks);
    }

    @Override
    public void playTracks() {
        for (Track track : myTracks) {
            System.out.println(track.getMelody());
        }
    }


}
