package system_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class A3_SmartLabDemo {
    public static void main(String[] args) {
        List<SmartDevice> labDevices = new ArrayList<>();

        SmartDevice labAc = new SmartDevice("Lab AC");
        labAc.addCapability(new PowerCapability());
        labAc.addCapability(new TemperatureCapability());
        labDevices.add(labAc);

        SmartDevice ceilingLight1 = new SmartDevice("Ceiling Light 1");
        ceilingLight1.addCapability(new PowerCapability());
        ceilingLight1.addCapability(new BrightnessCapability());
        labDevices.add(ceilingLight1);

        SmartDevice ceilingLight2 = new SmartDevice("Ceiling Light 2");
        ceilingLight2.addCapability(new PowerCapability());
        ceilingLight2.addCapability(new BrightnessCapability());
        labDevices.add(ceilingLight2);

        SmartDevice projector = new SmartDevice("Projector");
        projector.addCapability(new PowerCapability());
        labDevices.add(projector);

        labAc.executeAction("Temperature", 12);

        projector.addCapability(new BrightnessCapability());
        projector.executeAction("Brightness", 70);

        Scene lectureMode = new Scene("Lecture Mode");
        lectureMode.addAction("Power", "ON");
        lectureMode.addAction("Temperature", 22);
        lectureMode.addAction("Brightness", 40);

        lectureMode.applyTo(labDevices);
    }
}
