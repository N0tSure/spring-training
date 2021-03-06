package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 11.04.2017.
 * Count tracks
 * @author Artemis A. Sirosh
 */
@Aspect
@Component
public class TrackCounter {
    private Map<Integer, Integer> trackCount;

    public TrackCounter() {
        trackCount = new HashMap<>();
    }

    @Pointcut("execution(* soundsystem.Controllable.playTrack(int )) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCount.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCount.containsKey(trackNumber) ? trackCount.get(trackNumber) : 0;
    }
}
