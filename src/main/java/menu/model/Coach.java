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

}
