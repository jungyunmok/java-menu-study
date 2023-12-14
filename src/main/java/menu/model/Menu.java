package menu.model;

import java.util.*;

public class Menu {
    private Map<String, List<String>> allMenu = new HashMap<>() {{
        put("일식", new ArrayList<>(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")));
        put("한식", new ArrayList<>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")));
        put("중식", new ArrayList<>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")));
        put("아시안", new ArrayList<>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")));
        put("양식", new ArrayList<>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")));
    }};
    private List<String> categoryHistory = new ArrayList<>();

    private Map<String, List<String>> menuHistory = new LinkedHashMap<>();

    // 뽑은 숫자에 따라 카테고리 결정
    public List<String> pickCategory(int categoryNumber) {
        String categoryName = "양식";
        if (categoryNumber == 1) {
            categoryName = "일식";
        } else if (categoryNumber == 2) {
            categoryName = "한식";
        } else if (categoryNumber == 3) {
            categoryName = "중식";
        } else if (categoryNumber == 4) {
            categoryName = "아시안";
        }
        return checkHistory(categoryName);
    }

    // 2회를 초과하는 추천 카테고리인지 검증
    private List<String> checkHistory(String categoryName) {
        if (categoryHistory.contains(categoryName)) {
            if (Collections.frequency(categoryHistory, categoryName) >= 2) {
                throw new IllegalArgumentException();
            }
        }
        categoryHistory.add(categoryName);
        return categoryHistory;
    }

    // 해당 카테고리에 해당하는 메뉴 반환하기
    public List<String> returnMenuList(String category) {
        return allMenu.get(category);
    }

    // 입력값(싫어하는 음식) 리스트에 담기
    public List<String> dislikekMenu(String dislike) {
        List<String> dislikeMenu = new ArrayList<>();
        try {
            if (dislike.contains(",")) {
                dislikeMenu = twoDislike(dislike);
            } else if (dislike.length() > 1) {
                dislikeMenu.add(dislike);
            }
            validateMenu(dislikeMenu);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[EROOR] 올바른 메뉴를 공백없이 쉼표로 구분하여 최대 2개까지 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return dislikeMenu;
    }

    // 안 먹는 음식이 2개인 경우
    private List<String> twoDislike(String dislike) {
        List<String> dislikeMenu;
        String temp = String.valueOf(dislike.charAt(dislike.length() - 1));
        if (temp.equals(",")) throw new ArrayIndexOutOfBoundsException();
        String[] tempArr = dislike.split(",");
        dislikeMenu = Arrays.asList(tempArr);
        return dislikeMenu;
    }


    // 안먹는 메뉴가 존재하는 메뉴인지 검증
    private void validateMenu(List<String> dislikeMenu) {
        if (dislikeMenu.size() > 2) {
            System.out.println("[EROOR] 못 먹는 메뉴는 최대 2개까지 입력가능합니다.");
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (String menu : dislikeMenu) {
            count += correctMenu(menu);
        }
        if (count != dislikeMenu.size()) {
            System.out.println("[EROOR] 올바른 메뉴를 공백없이 쉼표로 구분하여 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    // 기존 메뉴와 비교하기
    private int correctMenu(String menu) {
        int count = 0;
        for(String key : allMenu.keySet()) {
            if(allMenu.get(key).contains(menu)) {
                count++;
            }
        }
        return count;
    }

    // 추천 메뉴를 담기
    public Map<String, List<String>> saveMenu(String name, String pickedMenu) {
        List<String> menuList = new ArrayList<>();
        if(menuHistory.containsKey(name)) {
            menuList = menuHistory.get(name);
        }
        menuList.add(pickedMenu);
        menuHistory.put(name, menuList);
        return menuHistory;
    }
}
