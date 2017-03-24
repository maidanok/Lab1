package logic.sort_service;

import java.util.Comparator;
import datalayer.datamodel.Track;

public abstract class SortedBy implements Comparator<Track> {

	@Override
	public abstract int compare(Track o1, Track o2);
	
}