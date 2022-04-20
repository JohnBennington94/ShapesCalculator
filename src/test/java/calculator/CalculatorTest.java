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
    @DisplayName("parseShapeType method exits with code 1 when incorrect arg passed")
    void parseShapeTypeUnsupportedReturnsExitOne() throws Exception {
        int status = SystemLambda.catchSystemExit(() -> {
            ShapeCalculator.parseShapeType("test");
        });
        assert status == 1;
    }

    @Test
    @DisplayName("parseMeasure method exits with code 1 when non int/double arg passed")
    void parseMeasureUnsupportedReturnsExitOne() throws Exception {
        int status = SystemLambda.catchSystemExit(() -> {
            ShapeCalculator.parseMeasure("test");
        });
        assert status == 1;
    }

    @Test
    @DisplayName("main method exits with code 1 when no args passed")
    void emptyArgsReturnsExitOne() throws Exception {
        int status = SystemLambda.catchSystemExit(() -> {
            ShapeCalculator.main(new String[0]);
        });
        assert status == 1;
    }

}