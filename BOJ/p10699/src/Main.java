import java.time.LocalDate;

/*
문제
서울의 오늘 날짜를 출력하는 프로그램을 작성하시오.

입력
입력은 없다.

출력
서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.
 */
public class Main {
    public static void main(String[] args) {
      System.out.println(LocalDate.now());
  }
}

