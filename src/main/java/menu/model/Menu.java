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
    public List<String> pickCategory(int category) {
        int number = checkHistory(category);
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
    public int checkHistory(int category) {
        if(history.containsKey(category)) {
            if(history.get(category) >= 2) {
                throw new IllegalArgumentException();
            }
            history.put(category, history.get(category)+1);
        }
        history.put(category, 1);
        return category;
    }

    // 입력값(싫어하는 음식) 리스트에 담기
    public List<String> dislikekMenu(String dislike) {
        List<String> dislikeMenu = new ArrayList<>();
        if(dislike.contains(",") && dislike.contains(" ")) {
            try {
                String[] tempArr = dislike.split(",");
                dislikeMenu = Arrays.asList(tempArr);
                validateMenu(dislikeMenu);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[EROOR] 못 먹는 메뉴를 공백없이 쉼표로 구분하여 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
        return dislikeMenu;
    }
    
    // 존재하는 메뉴인지 검증
    private void validateMenu(List<String> dislikeMenu) {
        int count = 0;
        for(String menu : dislikeMenu) {
            if (japan.contains(menu) || korea.contains(menu) || china.contains(menu) || asian.contains(menu) || western.contains(menu)) {
                count++;
            }
        }
        if(count != dislikeMenu.size()) {
            System.out.println("[EROOR] 못 먹는 메뉴를 공백없이 쉼표로 구분하여 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    // 중복되는 메뉴인지 검증
}
