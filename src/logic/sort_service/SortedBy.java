package logic.sort_service;

import datalayer.datamodel.Track;

import java.util.Comparator;

public abstract class SortedBy implements Comparator<Track> {

    @Override
    public abstract int compare(Track o1, Track o2);

}