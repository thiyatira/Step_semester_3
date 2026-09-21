package abstraction_interface.assigment_problems;

// Report generator implementing Exportable directly.
public class ReportGenerator implements Exportable {
    private String reportName;

    public ReportGenerator(String reportName) {
        if (reportName == null || reportName.trim().isEmpty()) {
            throw new IllegalArgumentException("Report name cannot be blank.");
        }
        this.reportName = reportName.trim();
    }

    @Override
    public String exportData() {
        DataExporter.recordExport();
        return "Exported report: " + reportName;
    }

    public String getReportName() {
        return reportName;
    }
}
