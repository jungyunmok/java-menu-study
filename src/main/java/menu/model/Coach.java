package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    private Map<String, List<String>> coachInfo = new HashMap<>();

    // 인원 수 이름 검사 후 저장
    public String[] validateCoach(String names) {
        String[] coachNames = names.split(",");
        if(coachNames.length < 2 || coachNames.length > 5) {
            System.out.println("[ERROR] 식사는 최소 2명, 최대 5명 까지 가능합니다.");
            throw new IllegalArgumentException();
        }
        for(String name : coachNames) {
            if(name.length() < 2 || name.length() > 4) {
                System.out.println("[ERROR] 코치 이름은 2~4글자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
        return coachNames;
    }

    // 코치별 먹지 못하는 음식 저장
    public Map<String, List<String>> dislikeFood(String name, List<String> dislike) {
        coachInfo.put(name, dislike);
        return coachInfo;
    }
}
