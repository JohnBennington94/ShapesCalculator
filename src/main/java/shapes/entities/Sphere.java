package shapes.entities;

public class Sphere extends Shape {

    public Sphere(int radius) {
        super(radius, "Sphere");
    }

    @Override
    public double calculateVolume() {
        int radius = this.getMeasure();
        double piValue = this.getPiValue();

        // volume == 4/3 pi r^3
        double volume=(4.0/3.0)*piValue*(radius*radius*radius);
        System.out.println("Volume of the "+this.getShapeName()+"="+volume);

        // Round volume to 2 decimal places
        return this.roundDoubleToTwoDecimalsPlaces(volume);
    }

}
