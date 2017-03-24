package datalayer.storage;

import datalayer.datamodel.Track;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TrackStorageImpl implements TrackStorage {
    private DataConnector dataConnector = new DataConnectorImpl();
    private List <Track> myTracks =new ArrayList<>();

    public TrackStorageImpl() throws IOException, ClassNotFoundException {
        myTracks =this.getAllTrack();

    }
    public TrackStorageImpl(List<Track> myTracks) {
        this.myTracks = myTracks;
    }

    //выдача полного списка треков
    @Override
    public List<Track> getAllTrack() throws IOException, ClassNotFoundException {
        List<Track> allTrack = new ArrayList<>();
        allTrack = (List<Track>) dataConnector.readData();
        return allTrack;
    }

    @Override
    public LocalTime getSize() throws IOException, ClassNotFoundException {
        LocalTime size;
        size=LocalTime.parse("00:00:00", DateTimeFormatter.ISO_LOCAL_TIME);
        for (Track track: myTracks){
            size=size.plusMinutes(track.getSize().getMinute()).plusSeconds(track.getSize().getSecond());
        }
        return size;
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
