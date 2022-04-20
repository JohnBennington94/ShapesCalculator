package services;

import shapes.entities.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ShapeService {

    public static Shape getShapeObject(Enum shapeType, double measure){
        if(shapeType == ShapeType.SPHERE){
            return new Sphere(measure);
        } else if(shapeType == ShapeType.CUBE){
            return new Cube(measure);
        } else if(shapeType == ShapeType.TETRAHEDRON){
            return new Tetrahedron(measure);
        } else {
            throw new NotImplementedException();
        }
    }

}
