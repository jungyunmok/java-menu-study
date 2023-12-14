package menu.model;

import java.util.*;

public class Coach {
    private Map<String, List<String>> coachInfo = new LinkedHashMap<>();

    // 인원 수 이름 검사 후 저장
    public List<String> validateCoach(String names) {
        List<String > coachNames = validateName(names);
        if(coachNames.size() < 2 || coachNames.size() > 5) {
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

    // 배열 예외처리
    private List<String> validateName(String names) {
        List<String > coachNames = new ArrayList<>();
        try {
            String temp = String.valueOf(names.charAt(names.length()-1));
            if(temp.equals(",")) throw new IllegalArgumentException();
            String[] tempNames = names.split(",");
            coachNames = Arrays.asList(tempNames);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[ERROR] 코치 이름은 공백없이 쉼표로 구분하며 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return coachNames;
    }

    // 코치별 먹지 못하는 음식 저장
    public Map<String, List<String>> dislikeFood(String name, List<String> dislikeMenu) {
        coachInfo.put(name, dislikeMenu);
        return coachInfo;
    }
}
