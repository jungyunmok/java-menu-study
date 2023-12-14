package menu.controller;

import menu.model.Coach;
import menu.model.Menu;
import menu.model.PickRandom;
import menu.view.InputView;

import java.util.List;
import java.util.Map;

public class MainController {
    InputView inputView;
    Coach coach;
    Menu menu;
    PickRandom pickRandom;
    
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
    public Map<String, List<String>> setDislike(List<String> coachNames) {
        List<String> dislikeMenu = null;
        Map<String, List<String>> coachInfo = null;
        for(String name : coachNames) {
            String dislike = inputView.readDislike(name);
            try {
                dislikeMenu = menu.dislikekMenu(dislike);
                coachInfo = coach.dislikeFood(name, dislikeMenu);
            } catch (IllegalArgumentException e) {
                setDislike(coachNames);
            }
        }
        return coachInfo;
    }

}
