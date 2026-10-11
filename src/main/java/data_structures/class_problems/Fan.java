package data_structures.class_problems;

// Smart fan that supports scheduling only.
public class Fan extends Device implements Schedulable {

    public Fan(String id) { super(id); }

    @Override
    public void schedule(String time) {
        System.out.println(getId() + " scheduled " + time);
    }
}
