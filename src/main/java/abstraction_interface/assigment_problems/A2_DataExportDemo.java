package abstraction_interface.assigment_problems;

// Demonstration of Exportable interface, independent class implementations, and centralized export counting.
public class A2_DataExportDemo {
    public static void main(String[] args) {
        ReportGenerator r = new ReportGenerator("Sales Q1");
        System.out.println(r.exportData());

        UserProfile u = new UserProfile("jane_doe");
        System.out.println(u.exportData());

        // Upcasting: ReportGenerator stored as Exportable interface type
        Exportable ref = r;

        // Batch export across polymorphic Exportable array
        Exportable[] items = {ref, u};
        DataExporter.exportAll(items);

        System.out.println("Total Exports Recorded: " + DataExporter.getTotalExports());
    }
}
