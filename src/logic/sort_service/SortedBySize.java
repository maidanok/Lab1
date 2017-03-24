package logic.sort_service;

import datalayer.datamodel.Track;




public class SortedBySize extends SortedBy {
    @Override
    public int compare(Track arg1, Track arg2) {
        return arg1.getSize().compareTo(arg2.getSize());
    }
}
