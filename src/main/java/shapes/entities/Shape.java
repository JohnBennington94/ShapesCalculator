package shapes.entities;

abstract class Shape {

    private int measure;
    private String shapeName;
    private double piValue = 3.14285714286;

    public Shape(int radius, String shapeName){
        this.measure = radius;
        this.shapeName = shapeName;
    }

    abstract public double calculateVolume();

    public double roundDoubleToTwoDecimalsPlaces(double value){
        return (double)Math.round(value * 100d) / 100d;
    }

    public int getMeasure() {
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
