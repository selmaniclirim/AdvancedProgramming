package labTwo.MovingObjects;

public class MovablePoint implements Movable {
    private int xCoordinates;
    private int yCoordinates;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int xCoordinates, int yCoordinates, int xSpeed, int ySpeed) {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        if (MovablesCollection.validateYAxis(yCoordinates + ySpeed))
            this.yCoordinates += ySpeed;
        else throw new ObjectCanNotBeMovedException(xCoordinates, yCoordinates + ySpeed);
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        if (MovablesCollection.validateYAxis(yCoordinates - ySpeed))
            this.yCoordinates -= ySpeed;
        else throw new ObjectCanNotBeMovedException(xCoordinates, yCoordinates - ySpeed);
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        if (MovablesCollection.validateXAxis(xCoordinates + xSpeed))
            this.xCoordinates += xSpeed;
        else throw new ObjectCanNotBeMovedException(xCoordinates + xSpeed, yCoordinates);
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        if (MovablesCollection.validateXAxis(xCoordinates - xSpeed))
            this.xCoordinates -= xSpeed;
        else throw new ObjectCanNotBeMovedException(xCoordinates - xSpeed, yCoordinates);
    }

    @Override
    public int getCurrentXPosition() {
        return this.xCoordinates;
    }

    @Override
    public int getCurrentYPosition() {
        return this.yCoordinates;
    }

    @Override
    public String toString() {
        return String.format("Movable point with coordinates (%d,%d)", getCurrentXPosition(), getCurrentYPosition());
    }
}
