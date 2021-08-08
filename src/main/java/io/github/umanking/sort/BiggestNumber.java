package io.github.umanking.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 가장큰수
 */
public class BiggestNumber {
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{6, 10, 2}));
        System.out.println(solution2(new int[]{3, 30, 34, 5, 9}));
    }

    public static String solution(int[] numbers) {
        String answer = "";

        // 문자열로 배열에 담는다.
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        // 정렬에 이용한다.
        List<Integer> collect1 = Arrays.stream(new int[]{3, 2, 4, 1})
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Arrays.sort(strings, (o1, o2) -> {
            int i = (o2 + o1).compareTo(o1 + o2);
            System.out.println("o1 = " + o1 + ", o2= " + o2);
            System.out.println("기준: " + o2 + o1 + ", 비교:" + o1 + o2 + "결과 :" + (i > 0));
            return i;
        });



        List<String> collect = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2+o1).compareTo(o1 + o2))
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

        StringBuilder result = new StringBuilder();
        for (String s : collect) {
            result.append(s);
        }
        return result.charAt(0) == '0' ? "0" : result.toString();

    }

    public static String solution2(int[] numbers) {
        List<String> collect = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2+o1).compareTo(o1 + o2))
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        for (String s : collect) {
            result.append(s);
        }

        return result.charAt(0) == '0' ? "0" : result.toString();
    }
}
