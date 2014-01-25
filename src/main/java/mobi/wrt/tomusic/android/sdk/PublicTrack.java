package mobi.wrt.tomusic.android.sdk;

import java.io.Serializable;

public class PublicTrack implements Serializable {

    private String trackName;

    private String artistName;

    private String url;

    private Long duration;

    public PublicTrack(String trackName, String artistName) {
        this.trackName = trackName;
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
