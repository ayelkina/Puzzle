package ayelkina.Model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(Position position) {
        int distanceBetweenX =  this.x > position.x ? this.x - position.x : position.x - this.x;
        int distanceBetweenY =  this.y > position.y ? this.y - position.y : position.y - this.y;

        return distanceBetweenX + distanceBetweenY;
    }
}
