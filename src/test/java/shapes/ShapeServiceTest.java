package shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shapes.entities.*;
import shapes.services.ShapeService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Tag("UnitTest")
class ShapeServiceTest {

    @ParameterizedTest
    @ValueSource(doubles = {2, 5.99})
    @DisplayName("Shape factory generates expected sphere object")
    void shapeFactoryReturnsExpectedSphereObject(double measure) {
        Shape shape = ShapeService.getShapeObject(ShapeType.SPHERE, measure);
        assert shape.getMeasure() == measure;
        assert shape instanceof Sphere;
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.9, 10})
    @DisplayName("Shape factory generates expected cube object")
    void shapeFactoryReturnsExpectedCubeObject(double measure) {
        Shape shape = ShapeService.getShapeObject(ShapeType.CUBE, measure);
        assert shape.getMeasure() == measure;
        assert shape instanceof Cube;
    }

    @ParameterizedTest
    @ValueSource(doubles = {999, 5.9})
    @DisplayName("Shape factory generates expected tetrahedron object")
    void shapeFactoryReturnsExpectedTetrahedronObject(double measure) {
        Shape shape = ShapeService.getShapeObject(ShapeType.TETRAHEDRON, measure);
        assert shape.getMeasure() == measure;
        assert shape instanceof Tetrahedron;
    }

    @Test
    @DisplayName("Shape factory throws NotImplementedException for unexpected Enum")
    void shapeFactoryThrowsExceptionForUnexpectedEnum() {
        NotImplementedException thrown = Assertions.assertThrows(NotImplementedException.class, () -> {
            ShapeService.getShapeObject(null, 6.0);
        });
    }

}