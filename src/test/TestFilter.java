package test;

import datalayer.datamodel.Track;
import datalayer.storage.TrackStorage;
import datalayer.storage.TrackStorageImpl;
import logic.filter.Filtrator;
import logic.filter.FiltratorImpl;
import logic.filter.StyleFilter;
import logic.sort_service.SortedBySize;

import java.util.List;

/**
 * Created by Pasha on 23.03.2017.
 */
public class TestFilter {
    public static void main(String[] args) throws Exception {
        TrackStorage trackStorage = new TrackStorageImpl();
        Filtrator filtrator= new FiltratorImpl(trackStorage);
        List <Track> filterTrack = filtrator.filter(new StyleFilter("рок"));
        filterTrack.sort(new SortedBySize());



        System.out.println("Печатаем весь список");
        for (int i = 0; i < trackStorage.getAllTrack().size(); i++) {
            System.out.println(trackStorage.getAllTrack().get(i));
        }

        System.out.println();
        System.out.println("Печатаем фильтрованный список");
        for (Track track:filterTrack){
            System.out.println(track);
        }
    }
}
