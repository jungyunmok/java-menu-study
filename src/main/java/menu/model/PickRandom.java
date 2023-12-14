package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PickRandom {
    // 추천할 카테고리 선택하기
    public int selectCategory() {
        int number = Randoms.pickNumberInRange(1, 5);
        return number;
    }

    // 추천할 메뉴 선택하기 - 이미 2번 추천했거나 싫어하는 메뉴 제외
    public String selectMenu(String name, List<String> menuList, Map<String, List<String>> menuHistory, List<String> dislikeMenu) {
        String pickedMenu = "";
        List<String> history = menuHistory.get(name);
        while (pickedMenu.equals("") || dislikeMenu.contains(pickedMenu) || (menuHistory.containsKey(name) && Collections.frequency(history, pickedMenu) >= 2)) {
            pickedMenu = Randoms.shuffle(menuList).get(0);
        }
        return pickedMenu;
    }
}
