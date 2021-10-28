package labTwo.MovingObjects;

import java.util.Arrays;
import java.util.Objects;

public class MovablesCollection {
    private Movable[] movable = new Movable[0];
    private static int x_MAX = 0;
    private static int y_MAX = 0;

    public MovablesCollection(int x_MAX, int y_MAX) {
        MovablesCollection.x_MAX = x_MAX;
        MovablesCollection.y_MAX = y_MAX;
    }

    public static void setxMax(int xMax) {
        x_MAX = xMax;
    }

    public static void setyMax(int yMax) {
        y_MAX = yMax;
    }

    public static boolean validateXAxis(int x) {
        return x >= 0 && x < x_MAX;
    }

    public static boolean validateYAxis(int y) {
        return y >= 0 && y < y_MAX;
    }

    public static boolean validateXAxisRadius(int x, int radius) {
        if (!validateXAxis(x))
                return false;
        else {
            return validateXAxis(x + radius);
        }
    }

    public static boolean validateYAxisRadius(int y, int radius) {
        if (!validateYAxis(y))
            return false;
        else {
            return validateXAxis(y + radius);
        }
    }

    public void addMovableObject(Movable m) {
        try {
            if (m instanceof MovablePoint) {
                if (validateYAxis(m.getCurrentXPosition())
                        && validateYAxis(m.getCurrentYPosition())) {
                    movable = Arrays.copyOf(movable, movable.length + 1);
                    for (int i = 0; i < movable.length; i++) {
                        if (movable[i] == null)
                            movable[i] = m;
                    }
                } else throw new MovableObjectNotFittableException(m.getCurrentXPosition(), m.getCurrentYPosition());
            }
            if (m instanceof MovableCircle) {
                if (movableCircleChecker(m)) {
                    movable = Arrays.copyOf(movable, movable.length + 1);
                    for (int i = 0; i < movable.length; i++) {
                        if (movable[i] == null)
                            movable[i] = m;
                    }
                } else
                    throw new MovableObjectNotFittableException(m.getCurrentXPosition(), m.getCurrentYPosition(), ((MovableCircle) m).getRadius());
            }
        } catch (MovableObjectNotFittableException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean movableCircleChecker(Movable m) {
        return m.getCurrentXPosition() >= ((MovableCircle) m).getRadius()
                && m.getCurrentYPosition() >= ((MovableCircle) m).getRadius()
                && validateXAxis(m.getCurrentXPosition() + ((MovableCircle) m).getRadius())
                && validateYAxis(m.getCurrentYPosition() + ((MovableCircle) m).getRadius());
    }

    public void moveObjectsFromTypeWithDirection(TYPE type, DIRECTION direction) {
        if(Objects.equals(type.toString(), "POINT")) {
            for(int i = 0; i < movable.length; i++) {
                if(movable[i] instanceof MovablePoint) {
                    moveObject(direction, i);
                }
            }
        }
        else if(Objects.equals(type.toString(), "CIRCLE")) {
            for(int i = 0; i < movable.length; i++) {
                if (movable[i] instanceof  MovableCircle){
                    moveObject(direction, i);
                }
            }
        }



    }

    private void moveObject(DIRECTION direction, int i) {
        switch (direction) {
            case UP:
                try {
                    movable[i].moveUp();
                } catch (ObjectCanNotBeMovedException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case DOWN:
                try {
                    movable[i].moveDown();
                } catch (ObjectCanNotBeMovedException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case LEFT:
                try {
                    movable[i].moveLeft();
                } catch (ObjectCanNotBeMovedException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case RIGHT:
                try {
                    movable[i].moveRight();
                } catch (ObjectCanNotBeMovedException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Collection of movable objects with size ").append(movable.length).append(":\n");
        for (Movable movable : movable) {
            stringBuilder.append(movable).append("\n");
        }
        return stringBuilder.toString();
    }
}
