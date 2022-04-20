package shapes.entities;

public class Tetrahedron extends Shape {

    public Tetrahedron(double edge) {
        super(edge, "Tetrahedron");
    }

    @Override
    public double calculateVolume() {
        double edge = this.getMeasure();

        // volume == r^3 / (6 * sq root (2))
        double volume=((edge*edge*edge)/(6*(Math.sqrt(2.0))));

        // Round volume to 2 decimal places
        return this.roundDoubleToTwoDecimalsPlaces(volume);
    }
}
