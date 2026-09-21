package abstraction_interface.assigment_problems;

// UserProfile entity implementing Exportable directly.
public class UserProfile implements Exportable {
    private String username;

    public UserProfile(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be blank.");
        }
        this.username = username.trim();
    }

    @Override
    public String exportData() {
        DataExporter.recordExport();
        return "Exported profile: " + username;
    }

    public String getUsername() {
        return username;
    }
}
