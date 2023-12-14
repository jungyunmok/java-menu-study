package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // 메뉴 추천을 받을 코치의 이름 입력
    public String readName() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
        String names = Console.readLine();
        return names;
    }

    // 각 코치가 못 먹는 메뉴 입력
    public String readDislike(String name) {
        System.out.println("\n"+name+"(이)가 못 먹는 메뉴를 입력해 주세요.");
        String dislike = Console.readLine();
        return dislike;
    }
}
