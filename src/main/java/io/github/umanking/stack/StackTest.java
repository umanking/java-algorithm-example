package io.github.umanking.stack;

import java.util.*;
import java.util.stream.Collectors;

public class StackTest {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // 각 작업마다 몇일이 걸릴것인가, 변환한다,
        // 위에서 구한 날짜를 가지고, 비교해서 리턴 배열을 만든다.
        //이전값이 <= 다음값, 배포 나감
        // 이전값 > 다음값이 더 작다면, 배포 안나감 (ount 값 +1 증가.)

        Queue<Integer> queue = new LinkedList<>();
        // int[] array = new int[progresses.length];

        int[] array = new int[progresses.length];
        int[] result = new int[progresses.length];
        for (int i =0 ; i < progresses.length; i++){
            int p = progresses[i];
            int s = speeds[i];
            int day = getDay(p, s);
            queue.offer(day);
            array[i] = day;
        }

        System.out.println(queue);

        // 7보다 큰 수가 나올때 까지의 index 총계를 삽입한다.
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int count = 1;
            Integer base = queue.poll();
            System.out.println("base = " + base);
            for (Integer nextVal : queue) {
                System.out.println("nextVal = " + nextVal);
                if (base > nextVal) {
                    System.out.println("카운트 증가 ");
                    count++;
                    break;
                }else{
                    break;
                }
            }

            result[i] = count;
        }





        //이전값이 <= 다음값, 배포 나감
        // 이전값 > 다음값이 더 작다면, 배포 안나감 (ount 값 +1 증가.)
        return result;
    }

    private static int getDay(int p, int s){
        int n = 1;

        // 100같거나 클때까지
        // n=1 60, n=2 90 , n=3
        while (p + (s * n) < 100){
            n++;

        }
        return n;
    }

}
