package labTwo.MovingObjects;

public class MovableObjectNotFittableException extends Exception{
    public MovableObjectNotFittableException(int x, int y) {
        super(String.format("Movable point with coordinates (%d,%d) can " +
                "not be fitted into the collection", x, y));
    }
    public MovableObjectNotFittableException(int x, int y, int radius) {
        super(String.format("Movable circle with center (%d,%d) and radius %d can " +
                "not be fitted into the collection", x,y,radius));
    }
}
