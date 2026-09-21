package abstraction_interface.class_problems;

// AudioFile extending MediaFile (IS-A) and implementing Playable (CAN-DO).
public class AudioFile extends MediaFile implements Playable {
    private String title;

    public AudioFile(String title) {
        super();
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = title.trim();
    }

    @Override
    public String getFormatInfo() {
        return "Audio file, ID: " + getFileId();
    }

    @Override
    public String play() {
        return "Playing audio: " + title;
    }

    @Override
    public String play(int fromSecond) {
        int minutes = fromSecond / 60;
        int seconds = fromSecond % 60;
        return "Playing audio: " + title + " from " + String.format("%d:%02d", minutes, seconds);
    }

    @Override
    public String pause() {
        return "Paused audio: " + title;
    }

    public String getTitle() {
        return title;
    }
}
