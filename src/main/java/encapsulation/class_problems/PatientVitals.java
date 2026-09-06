package encapsulation.class_problems;

import java.util.Arrays;

/**
 * Week 5 Practice - Problem 3: Vitals Monitoring Encapsulation Guard
 * Enforces strict encapsulation, range filtering, and defensive copying.
 */
public class PatientVitals {
    private double[] readings;
    private int count;

    public PatientVitals(double[] initialReadings) {
        this.readings = new double[initialReadings != null ? Math.max(initialReadings.length, 10) : 10];
        this.count = 0;

        if (initialReadings != null) {
            for (double reading : initialReadings) {
                // Reuses recordReading to ensure DRY range validation
                recordReading(reading);
            }
        }
    }

    public void recordReading(double reading) {
        // Silently reject physiologically impossible body temperature readings
        if (reading <= 0.0 || reading > 45.0) {
            return;
        }

        if (count >= readings.length) {
            readings = Arrays.copyOf(readings, readings.length * 2);
        }
        readings[count++] = reading;
    }

    public double getAverage() {
        if (count == 0) return 0.0;
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += readings[i];
        }
        return sum / count;
    }

    // Returns a defensive copy so caller cannot modify internal state
    public double[] getAllReadings() {
        return Arrays.copyOf(readings, count);
    }
}
