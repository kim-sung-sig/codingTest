class Solution {
    private static final int[] MONTH_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final Day[] DAYS_OF_WEEK = {Day.FRI, Day.SAT, Day.SUN, Day.MON, Day.TUE, Day.WED, Day.THU};

    // 해당 a 월 b일 이고 2016년 1월 1일은 금요일 일때, 요일을 구하는 프로그램을 만들어보자
    public String solution(int a, int b) {
        int totalDays = 0;
        for (int i = 1; i < a; i++) {
            totalDays += MONTH_DAYS[i];
        }
        totalDays += b - 1; // 1월 1일이 금요일이므로, 1월 1일은 0번째 날로 계산

        return DAYS_OF_WEEK[totalDays % 7].name();
    }

    enum Day {
        SUN,MON,TUE,WED,THU,FRI,SAT
    }
}