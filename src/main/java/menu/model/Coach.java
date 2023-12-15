package menu.model;

import menu.constant.Menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    // 이름 쉼표로 나눠서 담기
    public Map<String, List<String>> splitName(String nameList) {
        Map<String, List<String>> coachInfo = new LinkedHashMap<>();
        List<String> dislikeMenu = null;
        String lastWord = String.valueOf(nameList.charAt(nameList.length() - 1));
        if (!nameList.contains(",") || nameList.contains(" ") || lastWord.equals(",")) {
            System.out.println("[EROOR] 코치는 최소 2명, 최대 5명까지 공백없이 쉼표로 구분하여 입력해주세요.");
            throw new IllegalArgumentException();
        }
        String[] tempName = nameList.split(",");
        for (String name : tempName) {
            checkName(name);
            coachInfo.put(name, dislikeMenu);
        }
        return coachInfo;
    }

    // 이름 유효성 검사 - 2~4글자
    private void checkName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            System.out.println("[EROOR] 이름은 최소 2글자, 최대 4글자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // 못 먹는 음식 쉼표로 담기
    public List<String> selectDislike(String dislike) {
        List<String> dislikeMenu = new ArrayList<>();
        if (dislike.length() > 1) {
            String lastWord = String.valueOf(dislike.charAt(dislike.length() - 1));
            if (dislike.contains(" ") || lastWord.equals(",")) {
                System.out.println("[EROOR] 올바른 메뉴를 공백없이 쉼표로 구분하여 최대 2개 입력해주세요.");
                throw new IllegalArgumentException();
            }
            if (dislike.contains(",")) {
                dislikeMenu = checkCount(dislike, dislikeMenu);
                return dislikeMenu;
            }
            dislikeMenu.add(dislike);
        }
        return dislikeMenu;
    }

    // 메뉴 개수 확인
    private List<String> checkCount(String dislike, List<String> dislikeMenu) {
        String[] tempMenu = dislike.split(",");
        if (tempMenu.length > 2) {
            System.out.println("[EROOR] 올바른 메뉴를 공백없이 쉼표로 구분하여 최대 2개 입력해주세요.");
            throw new IllegalArgumentException();
        }
        for (String eachMenu : tempMenu) {
            checkMenu(eachMenu);
            dislikeMenu.add(eachMenu);
        }
        return dislikeMenu;
    }

    // 메뉴 유효성 검사
    private void checkMenu(String eachMenu) {
        for (Menu menu : Menu.values()) {
            if(!menu.getMENULIST().contains(eachMenu)) {
                System.out.println("[EROOR] 올바른 메뉴를 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
    }
}
