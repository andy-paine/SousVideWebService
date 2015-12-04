package Util;

import com.google.gson.annotations.Expose;

import java.time.Duration;

/**
 * Created by andy on 05/10/15.
 */
public class Stage {
    @Expose private Double temperature;
    @Expose private int duration;

    public Stage(Double temperature, int minutes) {
        this.temperature = temperature;
        this.duration = minutes;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Duration getDuration() {
        return Duration.ofMinutes(this.duration);
    }

    public void setDuration(int minutes) {
        this.duration = minutes;
    }
}
