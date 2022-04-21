package shapes.services;

import shapes.entities.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ShapeService {

    public static Shape getShapeObject(ShapeType shapeType, double measure){
        switch(shapeType){
            case SPHERE:
                return new Sphere(measure);
            case CUBE:
                return new Cube(measure);
            case TETRAHEDRON:
                return new Tetrahedron(measure);
            default:
                throw new NotImplementedException();
        }
    }

}
