package menu.model;

public class Days {
    private final String[] DAYS = {"월요일", "화요일", "수요일", "목요일", "금요일"};

    // 인덱스에 해당하는 요일 반환
    public String returnDay(int index) {
        return DAYS[index];
    }


}
