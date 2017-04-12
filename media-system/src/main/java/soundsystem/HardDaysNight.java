package soundsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HardDaysNight implements Controllable, CompactDisk {
    private static final Logger LOGGER = LoggerFactory.getLogger(HardDaysNight.class);
    private String title;
    private String artist;
    private List<String> tracks;


    public HardDaysNight(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void playTrack(int trackNumber) {
        LOGGER.info("Playing track #{}, {} by {}", trackNumber, tracks.get(trackNumber), artist);
    }

    @Override
    public void play() {
        LOGGER.info("Playing {} by {}", title, artist);
        tracks.forEach(track -> LOGGER.info("Track: {}", track));
    }
}
