package shapes.entities;


public abstract class Shape {

    private double measure;
    private double piValue = 3.14285714286;

    public Shape(double radius){
        this.setMeasure(radius);
    }

    abstract public double calculateVolume();

    public double roundDoubleToTwoDecimalsPlaces(double value){
        return (double)Math.round(value * 100d) / 100d;
    }

    public double getMeasure() {
        return measure;
    }

    public void setMeasure(double measure) {
        this.measure = measure;
    }

    public double getPiValue() {
        return piValue;
    }

    public void setPiValue(double piValue) {
        this.piValue = piValue;
    }
}
