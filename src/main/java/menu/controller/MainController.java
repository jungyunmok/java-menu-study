package menu.controller;

import menu.model.Coach;
import menu.view.InputView;

import java.util.List;

public class MainController {
    InputView inputView;
    Coach coach;
    
    // 점심 메뉴 추천 시작
    public void startMenu() {
        
    }

    // 코치 이름 입력
    public List<String> setName() {
        String names = inputView.readName();
        List<String> coachNames = null;
        try {
            coachNames = coach.validateCoach(names);
        } catch (IllegalArgumentException e) {
            setName();
        }
        return coachNames;
    }
    
    // 코치별 못먹는 음식 입력
}
