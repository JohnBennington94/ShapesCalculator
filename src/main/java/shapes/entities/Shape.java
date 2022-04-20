package shapes.entities;


public abstract class Shape {

    private double measure;
    private String shapeName;
    private double piValue = 3.14285714286;

    public Shape(double radius, String shapeName){
        this.measure = radius;
        this.shapeName = shapeName;
    }

    abstract public double calculateVolume();

    public double roundDoubleToTwoDecimalsPlaces(double value){
        return (double)Math.round(value * 100d) / 100d;
    }

    public double getMeasure() {
        return measure;
    }

    public void setMeasure(int measure) {
        this.measure = measure;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public double getPiValue() {
        return piValue;
    }

    public void setPiValue(double piValue) {
        this.piValue = piValue;
    }
}
