package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Random {
    // 카테고리 추천
    public int pickCategory(List<String> categoryHistory) {
        int category = 0;
        do {
            category = Randoms.pickNumberInRange(1, 5);
        } while(Collections.frequency(categoryHistory, category) >= 2);
        return category;
    }

    // 메뉴 추천
    public String pickMenu(List<String> menuList, List<String> menuHistory, List<String> dislikeMenu) {
        String menu = "";
        do {
            menu = Randoms.shuffle(menuList).get(0);
        } while (menu.equals("") || dislikeMenu.contains(menu) || menuHistory.contains(menu));
        return menu;
    }
}