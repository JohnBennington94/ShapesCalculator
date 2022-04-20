package shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import services.ShapeService;
import shapes.entities.Cube;
import shapes.entities.ShapeType;
import shapes.entities.Sphere;
import shapes.entities.Tetrahedron;

class ShapeServiceTest {

    @ParameterizedTest
    @CsvSource({"1, 4.19", "5, 523.81"})
    @DisplayName("Calculate volume of sphere works as expected")
    void calculateSphereVolumeWithRadius(double radius, double expectedValue){
        Sphere sphere = (Sphere)ShapeService.getShapeObject(ShapeType.SPHERE, radius);
        assert sphere.calculateVolume() == expectedValue;
    }

    @ParameterizedTest
    @CsvSource({"1, 1.00", "5, 125.00"})
    @DisplayName("Calculate volume of cube works as expected")
    void calculateCubeVolumeWithWidth(double width, double expectedValue){
        Cube cube = (Cube) ShapeService.getShapeObject(ShapeType.CUBE, width);
        assert cube.calculateVolume() == expectedValue;
    }

    @ParameterizedTest
    @CsvSource({"1, 0.12", "5, 14.73"})
    @DisplayName("Calculate volume of tetrahedron works as expected")
    void calculateTetrahedronVolumeWithEdge(double edge, double expectedValue){
        Tetrahedron tetrahedron = (Tetrahedron)ShapeService.getShapeObject(ShapeType.TETRAHEDRON, edge);
        assert tetrahedron.calculateVolume() == expectedValue;
    }
}