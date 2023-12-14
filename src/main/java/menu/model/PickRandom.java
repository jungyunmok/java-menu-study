package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class PickRandom {
    // 추천할 카테고리 선택하기
    public int selectCategory() {
        int number = Randoms.pickNumberInRange(1,5);
        return number;
    }

    // 추천할 메뉴 선택하기 - 이미 2번 추천했거나 싫어하는 메뉴 제외
    public String selectMenu(List<String> menuList, List<String> menuHistory, List<String> dislikeMenu)  {
        String menu;
        do {
            menu = Randoms.shuffle(menuList).get(0);
        } while(dislikeMenu.contains(menu) && Collections.frequency(menuHistory,menu) >= 2);
        return menu;
    }
}
