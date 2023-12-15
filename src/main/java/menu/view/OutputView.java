package menu.view;

import menu.constant.Days;

public class OutputView {
    // 서비스 시작 문구
    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    // 메뉴 추천 결과 - 요일 출력
    public void printDays() {
        System.out.print("\n[ 구분 ");
        for(String day : Days.DAYS) {
            System.out.print("| "+day);
        }
        System.out.print(" ]");
    }

    // 메뉴 추천 결과 - 카테고리 출력

    // 메뉴 추천 결과 - 코치별 추천 메뉴 출력

    // 서비스 종료 문구
    public void printEnd() {
        System.out.println("\n추천을 완료했습니다.");
    }
}
