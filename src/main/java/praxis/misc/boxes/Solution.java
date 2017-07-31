package praxis.misc.boxes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        Box[] boxes = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3),
                new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3) };

        Solution.solutionRecursive(Arrays.asList(boxes));
        Solution.solutionRecursiveMemoization(Arrays.asList(boxes));

        Solution.solutionIterative(Arrays.asList(boxes));
    }

    public static void solutionRecursive(List<Box> boxes) {

        Collections.sort(boxes, new BoxComparator());
        int maxHeight = solutionRecursive(boxes, 0, null);

        System.out.println(maxHeight);

    }

    public static int solutionRecursive(List<Box> boxes, int index, Box bottom) {

        if (index == boxes.size()) {
            return 0;
        } else {
            int heightWithBox = 0;

            Box newBottom = boxes.get(index);
            if (bottom == null || newBottom.canBeAbove(bottom)) {
                heightWithBox = solutionRecursive(boxes, index + 1, newBottom) + newBottom.getHeight();
            }
            int heightWithoutBox = solutionRecursive(boxes, index + 1, bottom);

            return Math.max(heightWithBox, heightWithoutBox);
        }

    }

    public static void solutionRecursiveMemoization(List<Box> boxes) {

        Collections.sort(boxes, new BoxComparator());
        int[] cache = new int[boxes.size()];
        // Arrays.fill(cache, -1);
        int maxHeight = solutionRecursiveMemoization(boxes, 0, null, cache);
        System.out.println(Arrays.toString(cache));

        System.out.println(maxHeight);

    }

    public static int solutionRecursiveMemoization(List<Box> boxes, int index, Box bottom, int[] cache) {

        if (index == boxes.size()) {
            return 0;
        } else {

            Box newBottom = boxes.get(index);
            int heightWithBottom = 0;
            if (newBottom.canBeAbove(bottom)) {

                if (cache[index] == 0) {
                    cache[index] = solutionRecursiveMemoization(boxes, index + 1, newBottom, cache) + newBottom.getHeight();
                }
                heightWithBottom = cache[index];
            }

            int heightWithoutBottom = solutionRecursiveMemoization(boxes, index + 1, bottom, cache);
            return Math.max(heightWithBottom, heightWithoutBottom);
        }
    }

    public static int solutionRecursiveMemoization1(List<Box> boxes, int index, Box bottom, int[] cache) {

        if (index >= boxes.size()) {
            return 0;
        } else if (cache[index] != -1) {
            return cache[index];
        } else {
            Box newBottom = boxes.get(index);
            int heightWithBottom = 0;
            if (newBottom.canBeAbove(bottom)) {
                heightWithBottom = solutionRecursiveMemoization1(boxes, index + 1, boxes.get(index), cache) + newBottom.getHeight();
            }

            int heightWithoutBottom = solutionRecursiveMemoization1(boxes, index + 1, bottom, cache);
            System.out.println("->" + bottom + " - " + newBottom);
            System.out.println(Arrays.toString(cache));
            System.out.println(index + " - " + heightWithBottom + " - " + heightWithoutBottom);
            cache[index] = Math.max(heightWithBottom, heightWithoutBottom);
            System.out.println(Arrays.toString(cache));
            System.out.println("--------");
            return cache[index];
        }
    }

    public static void solutionIterative(List<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());

        int maxHeight = 0;

        for (int i = 0; i < boxes.size(); ++i) {
            int height = solutionIterative(boxes, i);
            maxHeight = (height > maxHeight) ? height : maxHeight;
        }

        System.out.println(maxHeight);

    }

    public static int solutionIterative(List<Box> boxes, int bottomIndex) {

        int maxHeight = 0;

        Box bottom = boxes.get(bottomIndex);
        for (int i = bottomIndex + 1; i < boxes.size(); ++i) {
            Box box = boxes.get(i);
            if (box.canBeAbove(bottom)) {

                int height = solutionIterative(boxes, i);
                maxHeight = (height > maxHeight) ? height : maxHeight;
            }
        }

        return maxHeight + bottom.getHeight();

    }

}
