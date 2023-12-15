package menu.controller;

import menu.model.Coach;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class MainController {
    InputView inputView;
    OutputView outputView;
    Coach coach;

    // 시작
    public void start() {
        outputView.printStart();




        outputView.printEnd();
    }

    // 코치 이름 입력
    private Map<String, List<String>> coachName() {
        String nameList = inputView.readName();
        Map<String, List<String>> coachInfo = null;
        try {
            coachInfo = coach.splitName(nameList);
        } catch (IllegalArgumentException e) {
            coachName();
        }
        return coachInfo;
    }




}
