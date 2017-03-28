package logic.sort_service;


import datalayer.datamodel.Track;

public class SortedByStyle extends SortedBy {

    @Override
    public int compare(Track arg1, Track arg2) {
        return arg1.getStyle().compareTo(arg2.getStyle());
    }
}
