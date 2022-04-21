package shapes;

import java.util.Scanner;
import shapes.services.ShapeService;
import shapes.entities.Shape;
import shapes.entities.ShapeType;

public class ShapeCalculator {

    public static void main(String[] args){

        String exit = "exit";

        System.out.println("Welcome to the shape volume calculator program!");

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        // While loop to keep application running able to serve user input
        while(true) {

            // Prompt user for a shape to calculate volume
            System.out.println("Please enter a shape (Sphere, Cube, Tetrahedron) or 'exit' to stop the program:");
            String shape = in.nextLine();
            if(shape.equals(exit)){
                System.out.println("Exit called, stopping program...");
                System.exit(0);
            }

            ShapeType shapeArg = parseShapeType(shape);
            if(shapeArg == null){
                continue;
            }

            double measure = 0;
            while(measure == 0) {
                System.out.println("Please enter a measure (int/double format):");
                String measureInput = in.nextLine();
                measure = parseMeasure(measureInput);
            }

            // Run calculator app for shape and measure
            double volume = runCalculatorApplication(shapeArg, measure);

            // Output on console - while loop returns back to start
            System.out.println("Volume of " + shapeArg + " with measure " + measure + " => " + volume);

        }

    }

    public static ShapeType parseShapeType(String shapeType){
        // Get enum for shape type passed in
        ShapeType shapeArg = null;

        try {
            shapeArg = ShapeType.valueOf(shapeType.toUpperCase());
        } catch(IllegalArgumentException e) {
            System.out.println("Argument passed: " + shapeType + " is not supported by app - shapes " +
                    "allowed are: SPHERE, CUBE, TETRAHEDRON");
        }

        return shapeArg;
    }

    public static double parseMeasure(String measureArg){
        // Get measure double from args
        double measure = 0;

        try {
            measure = Double.parseDouble(measureArg);
        } catch(IllegalArgumentException e) {
            System.out.println("Argument passed: " + measureArg + " is non integer/double type");
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
