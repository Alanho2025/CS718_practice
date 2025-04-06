package practiceNine;

/**
 * Represents a Shape.
 *
 * Make this class implement the Comparable&lt;Shape&gt; interface
 */
public abstract class Shape implements Comparable<Shape> {

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract int getNumSides();

    /**
     * Gets the name of this shape. By default, just returns the class name.
     *
     * <p>Notes:</p>
     * <ul>
     *     <li>{@link #getClass()} returns a {@link Class} object representing an object's class.</li>
     *     <li>{@link Class#getSimpleName()} returns the name of the class, as written in the *.java file.</li>
     *     <li>{@link Class#getName()} reutnrs the name of the class, including the package name.</li>
     * </ul>
     * @return the shape's name.
     */
    public String getName() {
        return getClass().getSimpleName();
    }

    protected abstract String getDataString();

    @Override
    public String toString() {
        return getName() + " [" + getDataString() + "]";
    }

    public boolean hasSmallerAreaThan(Shape other) {

        return this.getArea() < other.getArea();

    }

    @Override
    public int compareTo(Shape other) {
        return Double.valueOf(getPerimeter()).compareTo(other.getPerimeter());
    }
}
