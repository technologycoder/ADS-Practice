package praxis.misc.boxes;

public class Box {
    private int width;

    private int height;

    private int length;

    public Box(int width, int height, int length) {

        super();
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public boolean canBeAbove(Box box) {

        return (box == null || (this.getHeight() < box.getHeight() &&
                this.getLength() < box.getLength() &&
                this.getWidth() < box.getWidth()));

    }

    @Override
    public String toString() {

        return "Box [width=" + width + ", height=" + height + ", length=" + length + "]";
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {

        this.width = width;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {

        this.height = height;
    }

    public int getLength() {

        return length;
    }

    public void setLength(int length) {

        this.length = length;
    }

}
