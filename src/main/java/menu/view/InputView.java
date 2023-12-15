package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // 코치 이름 입력
    public String readName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        return input;
    }
}
