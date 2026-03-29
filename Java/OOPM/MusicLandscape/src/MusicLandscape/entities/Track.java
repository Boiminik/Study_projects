package MusicLandscape.entities;

import java.util.Objects;

public class Track {
    private int duration;
    private Artist performer = new Artist();
    private String title;
    private Artist writer = new Artist();
    private int year;

    public Track() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int cnt = 0;
        for (int i = year; i != 0; i /= 10) {
            cnt++;
        }
        if (cnt == 4 && year >= 1900 && year <= 2999) {
            this.year = year;
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration >= 0) {
            this.duration = duration;
        }
    }

    public String getTitle() {
        if (title == null) {
            return "unknown title";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getWriter() {
        return writer;
    }

    public void setWriter(Artist writer) {
        if (writer != null) {
            this.writer = writer;
        }
    }
    public Artist getPerformer(){
        return performer;
    }
    public void setPerformer(Artist performer){
        if (performer != null){
            this.performer = performer;
        }
    }

    public boolean writerIsKnown(){
        return writer != null;
    }
    public String getString() {
        return String.format(
                "%10.10s by %10.10s performed by %10.10s (%02d:%02d)",
                Objects.requireNonNullElse(title, "unknown"),
                Objects.requireNonNullElse(writer, "unknown"),
                Objects.requireNonNullElse(performer, "unknown"),
                duration / 60,
                duration - ((duration / 60) * 60)
        );
    }
}
