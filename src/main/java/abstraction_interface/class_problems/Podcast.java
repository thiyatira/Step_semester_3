package abstraction_interface.class_problems;

// Podcast implementing Playable directly (CAN-DO) with no MediaFile ancestry.
public class Podcast implements Playable {
    private String showName;
    private int episodeNumber;

    public Podcast(String showName, int episodeNumber) {
        if (showName == null || showName.trim().isEmpty()) {
            throw new IllegalArgumentException("Show name cannot be blank.");
        }
        if (episodeNumber <= 0) {
            throw new IllegalArgumentException("Episode number must be positive.");
        }
        this.showName = showName.trim();
        this.episodeNumber = episodeNumber;
    }

    @Override
    public String play() {
        return "Streaming episode " + episodeNumber + " of " + showName;
    }

    @Override
    public String play(int fromSecond) {
        int minutes = fromSecond / 60;
        int seconds = fromSecond % 60;
        return "Streaming episode " + episodeNumber + " of " + showName + " from " + String.format("%d:%02d", minutes, seconds);
    }

    @Override
    public String pause() {
        return "Paused podcast: " + showName;
    }

    public String getShowName() {
        return showName;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }
}
