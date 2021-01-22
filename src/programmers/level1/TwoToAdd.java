package programmers.level1;

import java.util.Set;
import java.util.TreeSet;

//https://programmers.co.kr/learn/courses/30/lessons/68644
//코딩테스트 연습 > 월간 코드 챌린지 시즌1 > 두 개 뽑아서 더하기
public class TwoToAdd {
    public static void main(String[] args) {
        TwoToAdd.solution(new int[]{2,1,3,4,1}); //[2,3,4,5,6,7]
        TwoToAdd.solution(new int[]{2,5,7,9,12}); //[2,5,7,9,12]
    }

    public static int[] solution(int[] numbers) {

        //HashSet에서 TreeSet으로 변경한 이유는 TreeSet은 add시 마다 자동으로 정렬되기 때문이다.
        //HashSet과 비교시 확실히 수행시간이 줄었다.
        Set<Integer> set = new TreeSet<>();
        for (int i=0; i<numbers.length-1; i++){
            for (int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;

        /*
        아래 코드 문제인 정렬을 추가한 것으로 모든 테스트 케이스는 통과한다.
        Set<Integer> set = new HashSet();
        for (int i=0; i<numbers.length-1; i++){
            for (int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();
        return answer;*/

/*      아래 코드는 틀린 코드이다.
        문제 조건에 오름 차순으로 return 해야 하는 정렬하는 로직이 없기 때문
        Set<Integer> set = new HashSet();
        for (int i=0; i<numbers.length-1; i++){
            for (int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;*/
    }
}
