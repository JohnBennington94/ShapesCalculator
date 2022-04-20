package shapes;

import services.ShapeService;
import shapes.entities.Shape;
import shapes.entities.ShapeType;

public class ShapeCalculator {

    public static void main(String[] args){
        // Get enum for shape type passed in
        ShapeType shapeArg = null;
        double measure = 0;

        // Exit if no args passed
        if(args.length == 0){
            System.out.println("No arguments passed to app");
            System.exit(1);
        }

        try {
            shapeArg = ShapeType.valueOf(args[0]);
            measure = Double.parseDouble(args[1]);
        } catch(IllegalArgumentException e) {
            System.out.println("Arguments passed are not supported by app - shapes " +
                    "allowed are: SPHERE, CUBE, TETRAHEDRON");
            System.out.println("Shape type passed: " + args[0]);
            System.out.println("Measure (eg radius/width/edge length passed: " + args[1]);
            System.exit(1);
        }

        // Some output for user
        System.out.println("Shape type passed:" + args[0]);
        System.out.println("Measure (eg radius/width/edge length passed:" + args[1]);

        // Get shape object from factory method
        Shape shape = ShapeService.getShapeObject(shapeArg, measure);

        // Calculate volume of shape
        double volume = shape.calculateVolume();

        // Output on console
        System.out.println("Volume: " + volume);
        System.exit(0);
    }

}
