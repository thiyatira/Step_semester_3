package abstraction_interface.class_problems;

// Interface defining capability for media and audio streams that can be played and paused.
public interface Playable {
    String play();
    String play(int fromSecond);
    String pause();
}
