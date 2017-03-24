package logic.filter;

import datalayer.datamodel.Track;

import java.time.LocalTime;

/**
 * Created by Pasha on 23.03.2017.
 */
public class SizeFilter extends Filter{
    private LocalTime minSize;
    private LocalTime maxSize;

    public SizeFilter(LocalTime minSize, LocalTime maxSize) throws Exception {
        if (minSize.getSecond()>=0&&maxSize.getSecond()>minSize.getSecond()) {
            this.minSize = minSize;
            this.maxSize = maxSize;
        } else {
            System.out.println("Проверьте правильность введенных параметров");
            throw new  Exception();
        }
    }

    @Override
    public boolean isSatisfy(Track track) {
        LocalTime syze=track.getSize();
        return (syze.getSecond()>=minSize.getSecond()&&syze.getSecond()<=maxSize.getSecond());
    }
}
