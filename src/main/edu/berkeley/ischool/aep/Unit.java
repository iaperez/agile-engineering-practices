package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 2/14/14.
 */
public class Unit {


    public enum UnitType {LENGTH, VOLUME, TEMP}


    public static Unit Inches = new Unit(1.0, "Inches", UnitType.LENGTH);
    public static Unit Feet = new Unit(12.0, "Feet", UnitType.LENGTH);
    public static Unit Yards = new Unit(3 * 12.0, "Yards", UnitType.LENGTH);
    public static Unit Miles = new Unit(1760 * 3 * 12.0, "Miles", UnitType.LENGTH);

    public static Unit Tsp = new Unit(1.0, "Teaspoons", UnitType.VOLUME);
    public static Unit Tbsp = new Unit(3.0, "Tablespoons", UnitType.VOLUME);
    public static Unit Oz = new Unit(2 * 3.0, "Ounces", UnitType.VOLUME);
    public static Unit Cups = new Unit(8 * 2 * 3.0, "Miles", UnitType.VOLUME);

    public static Unit C = new TemperatureUnitC();
    public static Unit F = new TemperatureUnitF();

    private double ConversionFactor;
    protected String Name;
    protected UnitType type;

    public Unit(Double conversionFactor, String name, UnitType type) {
        ConversionFactor = conversionFactor;
        Name = name;
        this.type = type;
    }

    public double convertTo(Unit otherUnit, double value) throws Exception {
        if (otherUnit.type != this.type) throw new Exception();
        return value * ConversionFactor / otherUnit.ConversionFactor;
    }


    public boolean isCompatible(Unit unit) {
        return this.type == unit.type;
    }

    public static class TemperatureUnitC extends Unit {
        public TemperatureUnitC() {
            super(1.0, "C", UnitType.TEMP);
        }

        @Override
        public double convertTo(Unit otherUnit, double value) throws Exception {
            ITempConverter converter = TemperatureConverterFactory.CreateConverter(this, otherUnit);
            return converter.convert(value);
        }

    }

    public static class TemperatureUnitF extends Unit {
        public TemperatureUnitF() {
            super(1.0, "F", UnitType.TEMP);
        }

        @Override
        public double convertTo(Unit otherUnit, double value) throws Exception {
            ITempConverter converter = TemperatureConverterFactory.CreateConverter(this, otherUnit);
            return converter.convert(value);
        }
    }

    interface ITempConverter {
        double convert(double value);
    }

    static class FahrenheitToCelciusConverter implements ITempConverter {
        @Override
        public double convert(double value) {
            return (value - 32.0) * 5.0 / 9.0;
        }
    }

    static class CelsiusToFarenheitConverter implements ITempConverter {
        @Override
        public double convert(double value) {
            return (value * 9.0 / 5.0) + 32.0;
        }
    }

    static class sameUnit implements ITempConverter {
        @Override
        public double convert(double value) {
            return value;
        }
    }

    static class TemperatureConverterFactory {
        public static ITempConverter CreateConverter(Unit unitFrom, Unit unitTo) throws Exception {
            if (unitFrom instanceof TemperatureUnitF && unitTo instanceof TemperatureUnitC) {
                return new FahrenheitToCelciusConverter();
            } else if (unitFrom instanceof TemperatureUnitC && unitTo instanceof TemperatureUnitF) {
                return new CelsiusToFarenheitConverter();
            } else if (unitFrom.getClass() == unitTo.getClass())
                return new sameUnit();
            throw new Exception();
        }
    }

}
