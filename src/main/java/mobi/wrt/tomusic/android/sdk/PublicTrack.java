package mobi.wrt.tomusic.android.sdk;

import java.io.Serializable;

public class PublicTrack implements Serializable {

    private String trackName;

    private String artistName;

    private String url;

    private Long duration;

    private Long vkOwnerId;

    private Long vkAudioId;

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

    public void setVkInfo(Long vkOwnerId, Long vkAudioId) {
        this.vkOwnerId = vkOwnerId;
        this.vkAudioId = vkAudioId;
    }

    public Long getVkOwnerId() {
        return vkOwnerId;
    }

    public Long getVkAudioId() {
        return vkAudioId;
    }
}
