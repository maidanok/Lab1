package logic.filter;

import datalayer.datamodel.Track;

/**
 * Created by Pasha on 23.03.2017.
 */
public class StyleFilter extends Filter {
    private String style;

    public StyleFilter(String style) {
        this.style = style;
    }

    @Override
    public boolean isSatisfy(Track track) {
        return style.equals(track.getStyle());
    }
}
