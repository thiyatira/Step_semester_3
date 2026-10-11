package data_structures.class_problems;

import java.util.Arrays;

// Sorted-array library platform with binary-search lookup and capability dispatch.
public class LibraryPlatform {
    private Resource[] resources = new Resource[100];
    private int count = 0;

    public void add(Resource r) {
        int idx = binarySearch(r.getId());
        if (idx >= 0) { System.out.println("duplicate rejected"); return; }
        int ins = -idx - 1;
        System.arraycopy(resources, ins, resources, ins + 1, count - ins);
        resources[ins] = r;
        count++;
        System.out.println(r.getId() + " added");
    }

    public Resource find(String resourceId) {
        int idx = binarySearch(resourceId);
        if (idx >= 0) {
            System.out.println(resourceId + " found at index " + idx);
            return resources[idx];
        }
        System.out.println(resourceId + " not found");
        return null;
    }

    public void reserve(String resourceId, String memberId) {
        Resource r = getOrReport(resourceId);
        if (r == null) return;
        if (r instanceof Reservable res) res.reserve(memberId);
        else System.out.println(resourceId + " rejected: reserve unsupported");
    }

    public void download(String resourceId) {
        Resource r = getOrReport(resourceId);
        if (r == null) return;
        if (r instanceof Downloadable d) d.download();
        else System.out.println(resourceId + " rejected: download unsupported");
    }

    private Resource getOrReport(String id) {
        int idx = binarySearch(id);
        if (idx < 0) { System.out.println(id + " not found"); return null; }
        return resources[idx];
    }

    private int binarySearch(String id) {
        int lo = 0, hi = count - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = resources[mid].getId().compareTo(id);
            if (cmp == 0) return mid;
            if (cmp < 0)  lo = mid + 1;
            else          hi = mid - 1;
        }
        return -(lo + 1);
    }
}
