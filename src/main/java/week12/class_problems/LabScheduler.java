package week12.class_problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// Schedules jobs in round-robin order with a fixed quantum.
public class LabScheduler {
    private final int quantum;
    private final Queue<Job> jobs = new ArrayDeque<>();

    public LabScheduler(int quantum) {
        if (quantum < 1 || quantum > 100) {
            throw new IllegalArgumentException("Quantum must be between 1 and 100");
        }
        this.quantum = quantum;
    }

    public void addJob(String name, int duration) {
        if (name == null || name.isBlank() || duration < 1 || duration > 10000 || jobs.size() >= 1000) {
            throw new IllegalArgumentException("Invalid job or too many jobs");
        }
        jobs.add(new Job(name, duration));
    }

    public void run() {
        long time = 0;
        boolean firstSlice = true;
        List<String> finishes = new ArrayList<>();
        while (!jobs.isEmpty()) {
            Job job = jobs.remove();
            long start = time;
            int duration = Math.min(quantum, job.remaining);
            time += duration;
            job.remaining -= duration;
            System.out.print((firstSlice ? "" : " ") + job.name + "(" + start + "-" + time + ")");
            firstSlice = false;
            if (job.remaining == 0) {
                finishes.add(job.name + " " + time);
            } else {
                jobs.add(job);
            }
        }
        System.out.println();
        System.out.println("finish " + String.join(", ", finishes));
    }

    // Holds the remaining time of a queued job.
    private static class Job {
        private final String name;
        private int remaining;

        Job(String name, int remaining) {
            this.name = name;
            this.remaining = remaining;
        }
    }
}
