public class Node {

    private final int x;

    private final int y;
    private final char Direction;

    public Node(int x, int y, char Direction) {

        this.x = x;
        this.y = x;
        this.Direction = Direction;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return Direction;
    }
}
