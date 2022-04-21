package shapes;

import java.util.Scanner;
import shapes.services.ShapeService;
import shapes.entities.Shape;
import shapes.entities.ShapeType;

public class ShapeCalculator {

    public static void main(String[] args){

        System.out.println("Welcome to the shape volume calculator program!");

        // Using Scanner for Getting Input from User
        Scanner input = new Scanner(System.in);

        // While loop to keep application running able to serve user input
        while(true) {

            // Prompt user for a shape to calculate volume
            System.out.println("Please enter a shape (Sphere, Cube, Tetrahedron) or 'exit' to stop the program:");

            // Check if text passed is a supported shape type, continue to next loop if unsupported (restart flow)
            ShapeType shapeArg = parseShapeType(input.nextLine());
            if(shapeArg == null){
                continue;
            }

            double measure = getMeasureInputFromScanner(input);

            // Run calculator app for shape and measure
            double volume = runCalculatorApplication(shapeArg, measure);

            // Output on console - while loop returns back to start
            System.out.println("Volume of " + shapeArg + " with measure " + measure + " => " + volume);

        }

    }

    public static void checkIsExit(String input){
        String exit = "EXIT";
        if(input.toUpperCase().equals(exit)){
            System.out.println("Exit called, stopping program...");
            System.exit(0);
        }
    }

    public static double getMeasureInputFromScanner(Scanner input){
        double measure = 0;
        while(measure == 0) {
            System.out.println("Please enter a measure (int/double) or 'exit' to stop the program:");

            // Parse double from input if possible, if not prompt again for input
            measure = parseMeasure(input.nextLine());
        }
        return measure;
    }

    public static ShapeType parseShapeType(String shapeType){
        // Get enum for shape type passed in
        ShapeType shapeArg = null;

        checkIsExit(shapeType);

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

        checkIsExit(measureArg);

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
