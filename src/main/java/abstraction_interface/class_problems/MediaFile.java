package abstraction_interface.class_problems;

// Abstract base class representing a media file with an assigned file ID.
public abstract class MediaFile {
    private static int fileCounter = 0;
    private final String fileId;

    public MediaFile() {
        fileCounter++;
        this.fileId = "MF-" + (1000 + fileCounter);
    }

    public abstract String getFormatInfo();

    public String getFileId() {
        return fileId;
    }

    // Static polymorphic launcher across mixed Playable items
    public static void launchAll(Playable[] items) {
        if (items == null) return;
        for (Playable item : items) {
            if (item != null) {
                System.out.println(item.play());
            }
        }
    }
}
