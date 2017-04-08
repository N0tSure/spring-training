package soundsystem;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created by cresh on 13.01.17.
 */
public class BlankDisc implements CompactDisk {
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
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Playing %1$s by %2$s\n", title, artist));
        tracks.forEach(track ->
                builder.append(String.format("-Track: %s\n", track)));
        System.out.println(builder.toString());
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
