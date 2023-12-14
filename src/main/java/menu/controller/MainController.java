package menu.controller;

import menu.model.Coach;
import menu.model.Days;
import menu.model.Menu;
import menu.model.PickRandom;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class MainController {
    InputView inputView;
    OutputView outputView;
    Coach coach;
    Menu menu;
    PickRandom pickRandom;

    // 점심 메뉴 추천 시작
    public void startMenu() {
        outputView.startRecommend();


        outputView.endRecommend();
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
        for (String name : coachNames) {
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

    // 카테고리 선택하고 그에 맞는 메뉴 반환하기
    private List<String> pickCategory() {
        int category = pickRandom.selectCategory();
        List<String> menuList = null;
        try {
            menuList = menu.pickCategory(category);
        } catch (IllegalArgumentException e) {
            pickCategory();
        }
        return menuList;
    }

    // 추천 메뉴 반환하기
    private List<String> pickMenu(List<String> menuList, List<String> dislikeMenu) {
        List<String> menuHistory = null;
        do {
            String pickedMenu = pickRandom.selectMenu(menuList, menuHistory, dislikeMenu);
            menuHistory = menu.saveMenu(pickedMenu);
        } while (menuHistory.size() < Days.DAYS.length);
        return menuHistory;
    }

    // 결정된 추천 카테고리 출력하기
    public void fixedCategory() {
        outputView.printResult();
        outputView.printDays(Days.DAYS);
        List<String> categoryHistory = null;
        do {
            categoryHistory = pickCategory();
        } while (categoryHistory.size() < Days.DAYS.length);
        outputView.printCategory(categoryHistory);
    }

    // 결정된 추천 메뉴 출력하기

}
