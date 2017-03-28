package logic.filter;

import datalayer.datamodel.Track;

/**
 * Created by Pasha on 23.03.2017.
 */
public interface Filter {

    boolean isSatisfy(Track track);

}
