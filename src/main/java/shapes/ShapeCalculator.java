package shapes;

import shapes.services.ShapeService;
import shapes.entities.Shape;
import shapes.entities.ShapeType;

public class ShapeCalculator {

    public static void main(String[] args){
        // Exit if no args passed
        if(args.length == 0){
            System.out.println("No arguments passed to app");
            System.exit(1);
        }

        // Some output for user
        System.out.println("Shape type passed: " + args[0]);
        System.out.println("Measure (eg radius/width/edge) length passed: " + args[1]);

        // Get enum for shape type passed in and parse double from
        ShapeType shapeArg = parseShapeType(args[0]);
        double measure = parseMeasure(args[1]);

        // Run calculator app for shape and measure
        double volume = runCalculatorApplication(shapeArg, measure);

        // Output on console
        System.out.println("Volume: " + volume);
        System.exit(0);
    }

    public static ShapeType parseShapeType(String shapeType){
        // Get enum for shape type passed in
        ShapeType shapeArg = null;

        try {
            shapeArg = ShapeType.valueOf(shapeType.toUpperCase());
        } catch(IllegalArgumentException e) {
            System.out.println("Argument passed are not supported by app - shapes " +
                    "allowed are: SPHERE, CUBE, TETRAHEDRON");
            System.out.println("Shape type passed: " + shapeType);
            System.exit(1);
        }

        return shapeArg;
    }

    public static double parseMeasure(String measureArg){
        // Get measure double from args
        double measure = 0;

        try {
            measure = Double.parseDouble(measureArg);
        } catch(IllegalArgumentException e) {
            System.out.println("Argument passed for measure is non integer/double type");
            System.out.println("Measure (eg radius/width/edge) length passed: " + measureArg);
            System.exit(1);
        }

        return measure;
    }

    public static double runCalculatorApplication(ShapeType shapeArg, double measure){
        // Get shape object from factory method
        Shape shape = ShapeService.getShapeObject(shapeArg, measure);

        // Calculate volume of shape
        return shape.calculateVolume();
    }

}
