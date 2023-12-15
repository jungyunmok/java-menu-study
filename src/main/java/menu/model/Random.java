package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Random {
    // 카테고리 추천
    public int pickCategory() {
        int category = Randoms.pickNumberInRange(1, 5);
        return category;
    }

    // 메뉴 추천
    public String pickMenu(List<String> menuList, List<String> pickedMenus, List<String> dislikeMenu) {
        String menu = "";
        do {
            menu = Randoms.shuffle(menuList).get(0);
        } while (menu.equals("") || dislikeMenu.contains(menu) || pickedMenus.contains(menu));
        return menu;
    }
}
