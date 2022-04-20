package shapes.entities;

public class Tetrahedron extends Shape {

    public Tetrahedron(int edge) {
        super(edge, "Tetrahedron");
    }

    @Override
    public double calculateVolume() {
        int edge = this.getMeasure();

        // volume == r^3 / (6 * sq root (2))
        double volume=((edge*edge*edge)/(6*(Math.sqrt(2.0))));
        System.out.println("Volume of the "+this.getShapeName()+"="+volume);

        // Round volume to 2 decimal places
        return this.roundDoubleToTwoDecimalsPlaces(volume);
    }
}
