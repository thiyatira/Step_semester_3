package abstraction_interface.class_problems;

// Demonstration of Playable interface, overloaded play methods, MediaFile abstract class, and polymorphic launch.
public class P4_UniversalMediaDemo {
    public static void main(String[] args) {
        AudioFile a = new AudioFile("Morning Jazz");
        System.out.println(a.play());
        System.out.println(a.play(30));
        System.out.println(a.getFormatInfo());

        Podcast p = new Podcast("Tech Talk", 12);
        System.out.println(p.play());

        // Upcasting: AudioFile reference stored as Playable interface type
        Playable ref = a;
        System.out.println("Via Playable reference: " + ref.play());

        // Polymorphic launch of mixed Playable array
        Playable[] playlist = {ref, p};
        MediaFile.launchAll(playlist);
    }
}
