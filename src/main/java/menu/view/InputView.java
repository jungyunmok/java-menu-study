package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String read() {
        System.out.println("");
        String input = Console.readLine();
        return input;
    }
}
