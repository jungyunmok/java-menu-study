package menu.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    // 메뉴 시작 문구
    public void startRecommend() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    // 추천 결과 출력
    public void printResult() {
        System.out.println("\n메뉴 추천 결과입니다.");
    }

    // 요일 출력
    public void printDays(String[] days) {
        System.out.print("[ 구분");
        for (String day : days) {
            System.out.print(" | " + day);
        }
        System.out.print(" ]");
    }

    // 추천 카테고리 출력
    public void printCategory(List<String> categoryHistory) {
        System.out.print("\n[ 카테고리");
        for (String category : categoryHistory) {
            System.out.print(" | " + category);
        }
        System.out.print(" ]");

    }

    // 코치와 추쳔 메뉴 출력
    public void printMenu(String coachName, List<String> menuHistory) {
        System.out.print("\n[ " + coachName);
        for (String menu : menuHistory) {
            System.out.print(" | " + menu);
        }
        System.out.print(" ]");
    }

    // 서비스 종료 문구
    public void endRecommend() {
        System.out.println("\n추천을 완료했습니다.");
    }
}
