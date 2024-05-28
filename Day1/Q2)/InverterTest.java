abstract class Inverter {
    protected double current;
    protected double operatingVoltage;

    public Inverter(double current, double operatingVoltage) {
        this.current = current;
        this.operatingVoltage = operatingVoltage;
    }

    public double getPowerRating() {
        return current * operatingVoltage;
    }
}

abstract class SolarInverter extends Inverter {
    protected boolean hasBattery;
    protected boolean isGridOn;

    public SolarInverter(double current, double operatingVoltage, boolean hasBattery, boolean isGridOn) {
        super(current, operatingVoltage);
        this.hasBattery = hasBattery;
        this.isGridOn = isGridOn;
    }

    public boolean hasBattery() {
        return hasBattery;
    }

    public boolean isGridOn() {
        return isGridOn;
    }
}

class PCU extends SolarInverter {
    public PCU(double current, double operatingVoltage) {
        super(current, operatingVoltage, true, false);
    }

    @Override
    public String toString() {
        return "PCU Inverter: Power Rating = " + getPowerRating() + "W, Has Battery = " + hasBattery() + ", Is Grid On = " + isGridOn();
    }
}

class GTI extends SolarInverter {
    public GTI(double current, double operatingVoltage) {
        super(current, operatingVoltage, false, true);
    }

    @Override
    public String toString() {
        return "GTI Inverter: Power Rating = " + getPowerRating() + "W, Has Battery = " + hasBattery() + ", Is Grid On = " + isGridOn();
    }
}

class Regalia extends SolarInverter {
    public Regalia(double current, double operatingVoltage, boolean hasBattery) {
        super(current, operatingVoltage, hasBattery, false);
    }

    @Override
    public String toString() {
        return "Regalia Inverter: Power Rating = " + getPowerRating() + "W, Has Battery = " + hasBattery() + ", Is Grid On = " + isGridOn();
    }
}

abstract class NonSolarInverter extends Inverter {
    protected boolean hasBattery;

    public NonSolarInverter(double current, double operatingVoltage, boolean hasBattery) {
        super(current, operatingVoltage);
        this.hasBattery = hasBattery;
    }

    public boolean hasBattery() {
        return hasBattery;
    }
}

class Zelio extends NonSolarInverter {
    public Zelio(double current, double operatingVoltage) {
        super(current, operatingVoltage, true);
    }

    @Override
    public String toString() {
        return "Zelio Inverter: Power Rating = " + getPowerRating() + "W, Has Battery = " + hasBattery();
    }
}

class iCruze extends NonSolarInverter {
    public iCruze(double current, double operatingVoltage) {
        super(current, operatingVoltage, true);
    }

    @Override
    public String toString() {
        return "iCruze Inverter: Power Rating = " + getPowerRating() + "W, Has Battery = " + hasBattery();
    }
}

public class InverterTest {
    public static void main(String[] args) {
        Inverter pcu = new PCU(10, 230);
        Inverter gti = new GTI(12, 230);
        Inverter regalia = new Regalia(15, 230, true);
        Inverter zelio = new Zelio(20, 230);
        Inverter iCruze = new iCruze(25, 230);

        System.out.println(pcu);
        System.out.println(gti);
        System.out.println(regalia);
        System.out.println(zelio);
        System.out.println(iCruze);
    }
}
