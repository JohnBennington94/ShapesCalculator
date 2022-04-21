package calculator;

import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import shapes.entities.ShapeType;
import shapes.ShapeCalculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Tag("UnitTest")
class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "SPHERE, 1, 4.19",
            "SPHERE, 5, 523.60",
            "CUBE, 1, 1.00",
            "CUBE, 5, 125.00",
            "TETRAHEDRON, 1, 0.12",
            "TETRAHEDRON, 5, 14.73"
    })
    @DisplayName("Volume calculator app calculates volume as expected")
    void calculationAppReturnsExpectedVolumeAnswer(String shape, double measure, double expectedValue){
        ShapeType shapeType = ShapeCalculator.parseShapeType(shape);
        double actualVolume = ShapeCalculator.runCalculatorApplication(shapeType, measure);
        assert actualVolume == expectedValue;
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "SPHERE",
            "sphere",
            "SPherE",
    })
    @DisplayName("parseShapeType returns expected enum - Sphere")
    void parseShapeTypeReturnsCorrectSphereEnum(String shape){
        ShapeType shapeType = ShapeCalculator.parseShapeType(shape);
        assert shapeType == ShapeType.SPHERE;
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "CUBE",
            "cube",
            "cuBE"
    })
    @DisplayName("parseShapeType returns expected enum - Cube")
    void parseShapeTypeReturnsCorrectCubeEnum(String shape){
        ShapeType shapeType = ShapeCalculator.parseShapeType(shape);
        assert shapeType == ShapeType.CUBE;
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "TETRAHEDRON",
            "tetrahedron",
            "tETRaHEDron"
    })
    @DisplayName("parseShapeType returns expected enum - Tetrahedron")
    void parseShapeTypeReturnsCorrectTetrahedronEnum(String shape){
        ShapeType shapeType = ShapeCalculator.parseShapeType(shape);
        assert shapeType == ShapeType.TETRAHEDRON;
    }

    @Test
    @DisplayName("parseShapeType method returns a null when unsupported shape passed")
    void parseShapeTypeUnsupportedReturnsNull() {
        ShapeType shapeType = ShapeCalculator.parseShapeType("test");
        assert shapeType == null;
    }

    @ParameterizedTest
    @CsvSource({
            "6.2, 6.2",
            "5, 5.0"
    })
    @DisplayName("parseMeasure returns double from a string input")
    void parseMeasureReturnsDoubleFromString(String measure, double expectedMeasure){
        double actualMeasure = ShapeCalculator.parseMeasure(measure);
        assert actualMeasure == expectedMeasure;
    }

    @Test
    @DisplayName("parseMeasure method returns 0 when non int/double arg passed")
    void parseMeasureUnsupportedReturnsZero() {
        double result = ShapeCalculator.parseMeasure("test");
        assert result == 0;
    }

    @Test
    @DisplayName("main method exits with code 0 when 'exit' is input")
    void exitInputReturnsExitOne() throws Exception {
        int status = SystemLambda.catchSystemExit(() -> {
            // Set input to 'exit'
            String input = "exit";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // Call main
            ShapeCalculator.main(new String[0]);
        });
        assert status == 0;
    }

}