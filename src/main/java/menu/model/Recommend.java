package menu.model;

import menu.constant.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recommend {
    private List<String> categoryHistory = new ArrayList<>();
    // 한 주에 2번 이하 중복되는 카테고리 추천 저장하기
    public List<String> saveCategory(int category) {
        for(Menu menu : Menu.values()) {
            if(menu.getNUMBER() == category && Collections.frequency(categoryHistory, menu.getCATEGORY()) < 2) {
                categoryHistory.add(menu.getCATEGORY());
            }
        }
        return categoryHistory;
    }

    //  중복되지 않는 메뉴 추천하기

}
