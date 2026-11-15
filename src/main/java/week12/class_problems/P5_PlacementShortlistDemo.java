package week12.class_problems;

// Demonstrates stable ranking, best climbs, and shortlist queries.
public class P5_PlacementShortlistDemo {
    public static void main(String[] args) {
        PlacementShortlist.Candidate[] candidates = {
            new PlacementShortlist.Candidate("Asha", new int[] {60, 55, 70, 72, 68, 80}),
            new PlacementShortlist.Candidate("Ravi", new int[] {70, 72, 65, 60, 75, 78}),
            new PlacementShortlist.Candidate("Neha", new int[] {50, 65, 62, 70, 74, 84}),
            new PlacementShortlist.Candidate("Kiran", new int[] {80, 70, 66, 72, 70, 60}),
            new PlacementShortlist.Candidate("Mohan", new int[] {55, 60, 58, 64, 70, 73})
        };
        PlacementShortlist shortlist = new PlacementShortlist(candidates);
        System.out.println("Shortlist:");
        int rank = 1;
        for (PlacementShortlist.Candidate candidate : shortlist.getCandidates()) {
            System.out.printf("%d. %s %d | best climb %+d (test %d to %d)%n", rank++,
                    candidate.getName(), candidate.getTotal(), candidate.getGain(),
                    candidate.getStartTest(), candidate.getEndTest());
        }
        for (int cutoff : new int[] {405, 410}) {
            System.out.printf("CUTOFF %d: %d candidates%n", cutoff, shortlist.countAtLeast(cutoff));
        }
        for (int target : new int[] {785, 900}) {
            PlacementShortlist.Candidate[] pair = shortlist.findPair(target);
            String result = pair.length == 0 ? "no pair" : pair[0].getName() + " + " + pair[1].getName();
            System.out.printf("PAIR %d: %s%n", target, result);
        }
    }
}
