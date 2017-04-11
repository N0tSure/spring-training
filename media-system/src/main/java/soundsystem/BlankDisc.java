package soundsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created by cresh on 13.01.17.
 */
public class BlankDisc implements CompactDisk {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlankDisc.class);
    private String title;

    @Value("${white.artist}")
    private String artist;
    private List<String> tracks;

    public BlankDisc() {}

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        LOGGER.info("Playing {} by {}", title, artist);
        tracks.forEach(track -> LOGGER.info("Track: {}", track));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
