package menu.model;

import menu.constant.Menu;

import java.util.*;

public class Recommend {
    private List<String> categoryHistory = new ArrayList<>();

    private Map<String, List<String>> menuHistory = new LinkedHashMap<>();

    public void setMenuHistory(Map<String, List<String>> coachInfo) {
        for(String key : coachInfo.keySet()) {
            List<String> tempList = new ArrayList<>();
            menuHistory.put(key, tempList);
        }
    }

    public Map<String, List<String>> getMenuHistory() {
        return menuHistory;
    }

    // 한 주에 2번 이하 중복되는 카테고리 추천 저장하기
    public List<String> saveCategory(int category) {
        for (Menu menu : Menu.values()) {
            if (menu.getNUMBER() == category && Collections.frequency(categoryHistory, menu.getCATEGORY()) < 2) {
                categoryHistory.add(menu.getCATEGORY());
            }
        }
        return categoryHistory;
    }

    // 추천한 메뉴 저장하기
    public Map<String, List<String>> saveMenuHistory(String key, String menu) {
        List<String> pickedMenus = menuHistory.get(key);
        pickedMenus.add(menu);
        menuHistory.put(key, pickedMenus);
        return menuHistory;
    }

    // 카테고리에 맞는 메뉴 가져오기
    public List<String> correctMenulist(String category) {
        List<String> menuList = null;
        for (Menu menu : Menu.values()) {
            if (menu.getCATEGORY().equals(category)) {
                menuList = menu.getMENULIST();
            }
        }
        return menuList;
    }
}