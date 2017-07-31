package praxis.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall554 {

    public static void main(String[] args) {
        Integer[][] wall = {
                { 1, 2, 2, 1 },
                { 3, 1, 2 },
                { 1, 3, 2 },
                { 2, 4 },
                { 3, 1, 2 },
                { 1, 3, 1, 1 }
        };

        List<List<Integer>> list = twoDArrayToList(wall);

        System.out.println(leastBricks(list));

    }

    public static <T> List<List<T>> twoDArrayToList(T[][] arrays) {

        List<List<T>> list = new ArrayList<>();
        for (T[] arr : arrays) {
            List<T> l = Arrays.asList(arr);
            list.add(l);

        }

        return list;

    }

    public static int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0)
            return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map);
        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
                System.out.println(map);
            }
        }
        return wall.size() - count;
    }

}
