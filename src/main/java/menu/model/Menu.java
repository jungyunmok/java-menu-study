package menu.model;

import java.util.*;

public class Menu {
    private List<String> japan = new ArrayList<>(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
    private List<String> korea = new ArrayList<>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
    private List<String> china = new ArrayList<>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
    private List<String> asian = new ArrayList<>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
    private List<String> western = new ArrayList<>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    private Map<Integer, Integer> history = new HashMap<>();

    // 뽑은 숫자에 따라 카테고리 결정
    public List<String> pickCategory(int number) {
        if (number == 1) {
            return japan;
        } else if (number == 2) {
            return korea;
        } else if (number == 3) {
            return china;
        } else if (number == 4) {
            return asian;
        }
        return western;
    }

    // 2회를 초과하는 추천 카테고리인지 검증

    // 존재하는 메뉴인지 검증

    // 중복되는 메뉴인지 검증
}
