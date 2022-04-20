package shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shapes.entities.Cube;
import shapes.entities.Sphere;
import shapes.entities.Tetrahedron;

class ShapeTest {

    @ParameterizedTest
    @CsvSource({"1, 4.19", "5, 523.81"})
    @DisplayName("Calculate volume of sphere works as expected")
    void calculateSphereVolumeWithRadius(int radius, double expectedValue){
        Sphere sphere = new Sphere(radius);
        assert sphere.calculateVolume() == expectedValue;
    }

    @ParameterizedTest
    @CsvSource({"1, 1.00", "5, 125.00"})
    @DisplayName("Calculate volume of cube works as expected")
    void calculateCubeVolumeWithWidth(int width, double expectedValue){
        Cube cube = new Cube(width);
        assert cube.calculateVolume() == expectedValue;
    }

    @ParameterizedTest
    @CsvSource({"1, 0.12", "5, 14.73"})
    @DisplayName("Calculate volume of tetrahedron works as expected")
    void calculateTetrahedronVolumeWithEdge(int edge, double expectedValue){
        Tetrahedron tetrahedron = new Tetrahedron(edge);
        assert tetrahedron.calculateVolume() == expectedValue;
    }
}