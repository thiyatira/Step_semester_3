package encapsulation.class_problems;

import java.util.Arrays;

/**
 * Week 5 Practice - Problem 3: Vitals Monitoring Encapsulation Guard Demo
 */
public class P3_VitalsMonitoringDemo {

    public static void main(String[] args) {
        // Silent rejection of invalid seed values
        PatientVitals v = new PatientVitals(new double[]{36.5, -2.0, 37.1});
        System.out.println("Readings after silent rejection: " + Arrays.toString(v.getAllReadings()));

        // Defensive copying proof
        double[] copy = v.getAllReadings();
        copy[0] = 999.0;
        System.out.println("Reading[0] after modifying copy: " + v.getAllReadings()[0] + " (unmodified)");
        System.out.println("Vitals average: " + v.getAverage());
    }
}
