package logic.filter;

import datalayer.datamodel.Track;
import datalayer.storage.TrackStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pasha on 23.03.2017.
 */
public class FiltratorImpl implements Filtrator {
    private TrackStorage storage;

    public FiltratorImpl(TrackStorage storage) {
        this.storage = storage;
    }

    public void setStorage(TrackStorage storage) {
        this.storage = storage;
    }

    @Override
    public List<Track> filter(Filter filter) {
        List<Track> tracks = storage.getAllTrack();
        List<Track> result = new ArrayList<>();
        for (Track track : tracks) {
            if (filter.isSatisfy(track)) {
                result.add(track);
            }
        }
        return result;
    }

    @Override
    public void filter(Filter filter, List<Track> destTrack) {
        List<Track> srcTrack = storage.getAllTrack();
        for (Track track : srcTrack) {
            if (filter.isSatisfy(track)) {
                destTrack.add(track);
            }
        }

    }
}

