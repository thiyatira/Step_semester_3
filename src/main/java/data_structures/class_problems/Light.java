package data_structures.class_problems;

// Smart light that supports dimming and scheduling.
public class Light extends Device implements Dimmable, Schedulable {

    public Light(String id) { super(id); }

    @Override
    public void dim(int percent) {
        System.out.println(getId() + " dimmed to " + percent);
    }

    @Override
    public void schedule(String time) {
        System.out.println(getId() + " scheduled " + time);
    }
}
