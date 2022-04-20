package shapes.entities;

public class Cube extends Shape {

    public Cube(double width) {
        super(width);
    }

    @Override
    public double calculateVolume() {
        double width = this.getMeasure();

        // volume == r^3
        double volume=(width*width*width);

        // Round volume to 2 decimal places
        return this.roundDoubleToTwoDecimalsPlaces(volume);
    }


}
