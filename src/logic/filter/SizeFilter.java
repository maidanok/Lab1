package logic.filter;

import datalayer.datamodel.Track;

import java.time.LocalTime;

/**
 * Created by Pasha on 23.03.2017.
 */
public class SizeFilter implements Filter {
    private LocalTime minSize;
    private LocalTime maxSize;

    public SizeFilter(LocalTime minSize, LocalTime maxSize) throws Exception {
        if (minSize.isAfter(LocalTime.MIN) && minSize.isBefore(maxSize)) {
            this.minSize = minSize;
            this.maxSize = maxSize;
        } else {
            System.out.println("Проверьте правильность введенных параметров");
            throw new Exception();
        }
    }

    @Override
    public boolean isSatisfy(Track track) {
        LocalTime syze = track.getSize();
        return (syze.isBefore(maxSize) && syze.isAfter(minSize));
    }
}
