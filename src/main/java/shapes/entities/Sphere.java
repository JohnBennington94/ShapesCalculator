package shapes.entities;

public class Sphere extends Shape {

    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public double calculateVolume() {
        double radius = this.getMeasure();
        double piValue = this.getPiValue();

        // volume == 4/3 pi r^3
        double volume=(4.0/3.0)*piValue*(radius*radius*radius);

        // Round volume to 2 decimal places
        return this.roundDoubleToTwoDecimalsPlaces(volume);
    }

}
