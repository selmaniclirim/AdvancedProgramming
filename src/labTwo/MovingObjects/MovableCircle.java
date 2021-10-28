package labTwo.MovingObjects;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int radius, MovablePoint movingPoint) {
        this.radius = radius;
        this.center = movingPoint;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        this.center.moveUp();
        if (!MovablesCollection.validateYAxisRadius(getCurrentYPosition(), radius))
            throw new ObjectCanNotBeMovedException(getCurrentXPosition(), getCurrentYPosition(), radius);
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        this.center.moveDown();
        if (!MovablesCollection.validateYAxisRadius(getCurrentYPosition(), radius))
            throw new ObjectCanNotBeMovedException(getCurrentXPosition(), getCurrentYPosition(), radius);
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        this.center.moveRight();
        if (!MovablesCollection.validateXAxisRadius(getCurrentXPosition(), radius))
            throw new ObjectCanNotBeMovedException(getCurrentXPosition(), getCurrentYPosition(), radius);
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        this.center.moveLeft();
        if (!MovablesCollection.validateXAxisRadius(getCurrentXPosition(), radius))
            throw new ObjectCanNotBeMovedException(getCurrentXPosition(), getCurrentYPosition(), radius);
    }

    @Override
    public int getCurrentXPosition() {
        return this.center.getCurrentXPosition();
    }

    @Override
    public int getCurrentYPosition() {
        return this.center.getCurrentYPosition();
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Movable circle with center coordinates " +
                "(%d,%d) and radius %d", getCurrentXPosition(), getCurrentYPosition(), this.radius);
    }
}
