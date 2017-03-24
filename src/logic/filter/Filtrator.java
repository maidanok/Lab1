package logic.filter;

import datalayer.datamodel.Track;

import java.util.List;

/**
 * Created by Pasha on 23.03.2017.
 */
public interface Filtrator {

    List<Track> filter(Filter filter) throws Exception;

    void filter (Filter filter, List<Track> destTrack) throws Exception;


}
