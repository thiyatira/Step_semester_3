package string.class_problems;

/**
 * Week 2 Practice - Problem 3: File Extension Validator
 * Validates uploaded files against allowed extensions (pdf, docx, zip).
 */
public class FileExtensionValidator {

    private static final String[] ALLOWED_EXTENSIONS = {"pdf", "docx", "zip"};

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1).toLowerCase();

        for (String allowed : ALLOWED_EXTENSIONS) {
            if (allowed.equals(extension)) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        String[] testFiles = {"Assignment1.PDF", "notes.txt", "report.DOCX", "project.zip", "noextension"};

        for (String file : testFiles) {
            System.out.printf("File: %-18s -> %s%n", file, validateFileExtension(file));
        }
    }
}
