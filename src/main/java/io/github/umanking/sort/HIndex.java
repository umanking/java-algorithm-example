package io.github.umanking.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * h index
 */
public class HIndex {
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution2(new int[]{1, 4, 7, 9, 10}));
        System.out.println(solution2(new int[]{4}));
        
        
    }

    public static int solution(int[] citations) {
        List<Integer> result = Arrays.stream(citations)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);

        int res = 0;
        for (int i = 0; i < result.size(); i++) {
            Integer value = result.get(i);
            int min = Integer.min(value, result.size() - i);
            res = Integer.max(res, min);
        }
        return res;
    }
    public static int solution2(int[] citations) {
        List<Integer> list = Arrays.stream(citations)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int smaller = Math.min(list.get(i), list.size() - i);
            result = Math.max(result, smaller);
        }

        return result;
    }
}
