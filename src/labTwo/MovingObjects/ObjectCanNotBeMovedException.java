package labTwo.MovingObjects;

public class ObjectCanNotBeMovedException extends Exception {

    public ObjectCanNotBeMovedException(int xCoordinate, int yCoordinate) {
        super(String.format("Point (%d,%d) is out of bounds", xCoordinate, yCoordinate));
    }
    public ObjectCanNotBeMovedException(int xCoordinate, int yCoordinate, int radius) {
        super(String.format("Movable circle with center (%d,%d) and radius %d " +
                "can not be fitted into the collection", xCoordinate, yCoordinate, radius));
    }
}
