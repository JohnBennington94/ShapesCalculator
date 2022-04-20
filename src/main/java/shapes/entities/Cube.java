package shapes.entities;

public class Cube extends Shape {

    public Cube(int width) {
        super(width, "Cube");
    }

    @Override
    public double calculateVolume() {
        int width = this.getMeasure();

        // volume == r^3
        double volume=(width*width*width);
        System.out.println("Volume of the "+this.getShapeName()+"="+volume);

        // Round volume to 2 decimal places
        return this.roundDoubleToTwoDecimalsPlaces(volume);
    }


}
