import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 이 테스트코드는 <a href="https://github.com/PENEKhun/Baekjoon-java-starter">Baekjoon-java-starter </a>를
 * 사용하여 생성되었습니다.
 *
 * @Author : PENEKhun
 */
public class TestHelper {

  public static void main(String[] args) {
    TestCase[] testCases = new TestCase[]{
        new TestCase(
// input
"""
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
""",
// output
"""
3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
"""),
new TestCase(
// input
"""
5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28
""",
// output
"""
28 27 26 25
22 9 15 19
16 8 21 13
10 14 20 7
4 3 2 1
"""),
new TestCase(
// input
"""
2 2 3
1 1
1 1
""",
// output
"""
1 1
1 1
"""),

    };

    int passedCases = 0;

    for (int i = 0; i < testCases.length; i++) {
      TestCase testCase = testCases[i];

      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      PrintStream printStream = new PrintStream(outputStream);
      PrintStream printOut = System.out;
      System.setOut(printStream);
      System.setIn(new ByteArrayInputStream(testCase.input.getBytes()));

      try {
        Main.main(new String[0]);
      } catch (Exception e) {
        System.setOut(printOut);
        printFail(i + 1, testCase, "Exception 발생");
        e.printStackTrace();
      }

      String output = outputStream.toString();
      System.setOut(printOut);
      if (output.equals(testCase.expectedOutput)) {
        passedCases++;
        continue;
      } else {
        printFail(i + 1, testCase,
            red("""
                [실제 값]
                %s
                """.formatted(output)));
      }
    }

    System.out.println("테스트 완료 (" + passedCases + " / " + testCases.length + ")");
    if (passedCases == testCases.length) {
      System.out.println("주어진 케이스에 대해 잘 동작하고 있습니다.");
    }
  }

  public static void printFail(int caseNumber, TestCase testCase, String message) {
    System.out.printf("""
        ====== %s ======
        [입력 값]
        %s
        [기대 값]
        %s
        """, red(caseNumber + " 번째 케이스 실패"), testCase.input, testCase.expectedOutput);

    System.out.println(message);
  }

  public static String red(String message) {
    return "\u001B[31m%s\u001B[0m".formatted(message);
  }

  public static class TestCase {

    public String input;
    public String expectedOutput;

    public TestCase(String input, String expectedOutput) {
      this.input = input;
      this.expectedOutput = expectedOutput;
    }
  }
}
