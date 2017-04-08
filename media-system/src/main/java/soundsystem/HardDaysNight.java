package soundsystem;

import org.springframework.stereotype.Component;

//@Component
public class HardDaysNight implements CompactDisk {
    private String title = "Hard Days Night";
    private String artist = "The Beatles";

    public HardDaysNight() {}

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
