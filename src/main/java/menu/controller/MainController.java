package menu.controller;

import menu.constant.Days;
import menu.constant.Menu;
import menu.model.Coach;
import menu.model.Random;
import menu.model.Recommend;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    InputView inputView;
    OutputView outputView;
    Coach coach;
    Random random;
    Recommend recommend;

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

    // 코치별 못 먹는 음식 입력
    private Map<String, List<String>> coachTaste(Map<String, List<String>> coachInfo) {
        List<String> dislikeMenu = null;
        try {
            for (String key : coachInfo.keySet()) {
                String dislike = inputView.readMenu(key);
                dislikeMenu = coach.selectDislike(dislike);
                coachInfo.put(key, dislikeMenu);
            }
        } catch (IllegalArgumentException e) {
            coachTaste(coachInfo);
        }
        return coachInfo;
    }

    // 추천 카테고리 정하기
    private List<String> fixedCategory() {
        List<String> categoryHistory = null;
        do {
            int category = random.pickCategory();
            categoryHistory = recommend.saveCategory(category);
        } while (categoryHistory.size() == Days.DAYS.length);
        return categoryHistory;
    }

    // 추천 메뉴 정하기
    private Map<String, List<String>> fixedMenu(Map<String, List<String>> coachInfo, List<String> categoryHistory) {
        Map<String, List<String>> menuHistory = recommend.getMenuHistory();
        for (String category : categoryHistory) {
            for (String key : coachInfo.keySet()) {
                String menu = random.pickMenu(recommend.correctMenulist(category), menuHistory.get(key), coachInfo.get(key));
                menuHistory = recommend.saveMenuHistory(key, menu);
            }
        }
        return menuHistory;
    }

    // 결과 출력하기
    private void result(List<String> categoryHistory,Map<String, List<String>> menuHistory) {
        outputView.printDays();
        outputView.printCategory(categoryHistory);
        for(String key : menuHistory.keySet()) {
            outputView.printMenu(key, menuHistory.get(key));
        }
    }
}
