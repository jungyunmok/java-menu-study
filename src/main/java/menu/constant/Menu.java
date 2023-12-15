package menu.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Menu {
    JPN(1, "일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOR(2, "한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHN(3, "중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASN(4, "아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WST(5, "양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int NUMBER;
    private final String CATEGORY;
    private final List<String> MENULIST;

    Menu(int NUMBER, String CATEGORY, List<String> MENULIST) {
        this.NUMBER = NUMBER;
        this.CATEGORY = CATEGORY;
        this.MENULIST = MENULIST;
    }

    public int getNUMBER() {
        return NUMBER;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public List<String> getMENULIST() {
        return MENULIST;
    }
}
