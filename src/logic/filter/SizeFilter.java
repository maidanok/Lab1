package logic.filter;

import datalayer.datamodel.Track;

/**
 * Created by Pasha on 23.03.2017.
 */
public class SizeFilter extends Filter{
    private Integer minSize;
    private Integer maxSize;

    public SizeFilter(Integer minSize, Integer maxSize) throws Exception {
        if (minSize>=0&&maxSize>minSize) {
            this.minSize = minSize;
            this.maxSize = maxSize;
        } else {
            System.out.println("Проверьте правильность введенных параметров");
            throw new  Exception();
        }
    }

    @Override
    public boolean isSatisfy(Track track) {
        Integer syze=track.getSize();
        return (syze>=minSize&&syze<=maxSize);
    }
}
