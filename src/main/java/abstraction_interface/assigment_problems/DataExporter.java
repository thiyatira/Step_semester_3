package abstraction_interface.assigment_problems;

// Central coordinator tracking total export operations and batch processing Exportable items.
public class DataExporter {
    private static int totalExports = 0;

    public static synchronized void recordExport() {
        totalExports++;
    }

    public static int getTotalExports() {
        return totalExports;
    }

    public static void exportAll(Exportable[] items) {
        if (items == null) return;
        for (Exportable item : items) {
            if (item != null) {
                System.out.println(item.exportData());
            }
        }
    }
}
