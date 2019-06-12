package ayelkina.Model;

public class Element {
    protected int number;
    protected Position position;
    protected Position aimPosition;

    public Element() {
    }

    public Element(int number) {
        this.number = number;
    }

    public Element(int number, Position position) {
        this.number = number;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getAimPosition() {
        return aimPosition;
    }

    public void setAimPosition(Position aimPosition) {
        this.aimPosition = aimPosition;
    }
}
