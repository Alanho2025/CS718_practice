package practiceNine;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * Questions for Lab 09 Exercise Five, involving sorting a bunch of shapes.
 */
public class ExerciseFive {

    /**
     * This method should take the given array of Shapes, and add each one to a TreeSet.
     *
     * Since we're adding to a TreeSet, there should be no duplicates.
     *
     * When we print out the shapes, we should see that they are ordered by perimeter, in ascending order.
     *
     * @param shapes the shapes to sort using a TreeSet.
     */
    private void sortedSetExample(Shape[] shapes) {

        Set<Shape> shapeSet = new TreeSet<>();

        for (int i = 0; i < shapes.length; i++) {

            Shape s = shapes[i];
            shapeSet.add(s);
        }


        // Print out the result. Do not edit below this line.
        NumberFormat formatter = new DecimalFormat("#.##");
        System.out.println("Number of shapes in set: " + shapeSet.size());
        for(Shape s : shapeSet) {

            System.out.println(" - " + s + " has a perimeter of: " + formatter.format(s.getPerimeter()) + "cm");

        }
    }

    /**
     * This method should take the given array of Shapes, and add each one to an ArrayList.
     *
     * We should then sort the ArrayList using the Collections.sort method, supplying a Comparator which sorts by
     * the number of sides (ascending) then by area (descending).
     *
     * @param shapes
     */
    private void comparatorExample(Shape[] shapes) {

        List<Shape> shapeList = new ArrayList<>();

        for (int i = 0; i < shapes.length; i++) {
            Shape s = shapes[i];
            shapeList.add(s);
        }

        // Complete this Comparator, which should order shapes by their number of sides (ascending order),
        // THEN by area (descending order).
        Comparator<Shape> shapeComparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {

                if (o1.getNumSides() == o2.getNumSides()) {

                    return Double.valueOf(o2.getArea()).compareTo(o1.getArea());

                } else {
                    return o1.getNumSides() - o2.getNumSides();
                }
            }
        };

        // Sort shapeList using the Collections.sort method and shapeComparator
        Collections.sort(shapeList, shapeComparator);

        // Print out the result. Do not edit below this line.
        NumberFormat formatter = new DecimalFormat("#.##");
        System.out.println("Number of shapes in list: " + shapeList.size());
        for(Shape s : shapeList) {

            System.out.println(" - " + s + " has " + s.getNumSides() + " sides and an area of: " + formatter.format(s.getArea()) + "cm^2");

        }
    }

    /**
     * Main program flow. Do not edit.
     */
    private void start() {

        Shape[] shapes = new Shape[10];

        shapes[0] = new RegularPolygon(4, 5);
        shapes[1] = new Circle(4);
        shapes[2] = new Rectangle(4, 5);
        shapes[3] = new Circle(3);
        shapes[4] = new Rectangle(3, 10);
        shapes[5] = new RegularPolygon(6, 2);
        shapes[6] = new Rectangle(4, 5);
        shapes[7] = new Circle(4);
        shapes[8] = new RegularPolygon(8, 2);
        shapes[9] = new Rectangle(10, 9);

        sortedSetExample(shapes);
        System.out.println();
        comparatorExample(shapes);
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        new ExerciseFive().start();
    }
}
