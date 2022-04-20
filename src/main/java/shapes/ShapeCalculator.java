package shapes;
import shapes.entities.Sphere;

public class ShapeCalculator {

    public static void main(String[] args){

        Sphere myShape = new Sphere(1);
        System.out.println(myShape.calculateVolume());

    }

}
