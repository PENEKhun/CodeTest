import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 이 테스트코드는 <a href="https://github.com/PENEKhun/Baekjoon-java-starter">Baekjoon-java-starter </a>를 사용하여 생성되었습니다.
 * @Author : PENEKhun
 */
public class TestHelper {

  public static class TestCase {
    public String input;
    public String expectedOutput;

    public TestCase(String input, String expectedOutput) {
      this.input = input;
      this.expectedOutput = expectedOutput;
    }
  }
public static void main(String[] args) {
  TestCase[] testCases = new TestCase[]{
new TestCase(
// input
"""
20 30 10
""",
// output
"""
20
"""),
new TestCase(
// input
"""
30 30 10
""",
// output
"""
30
"""),
new TestCase(
// input
"""
40 40 40
""",
// output
"""
40
"""),
new TestCase(
// input
"""
20 10 10
""",
// output
"""
10
"""),
      };

      int passedCases = 0;

      for (int i = 0; i < testCases.length; i++) {
        TestCase testCase = testCases[i];

        System.out.println("========================================");
        System.out.println("입력 값: " + testCase.input);
        System.out.println("기대 값: " + testCase.expectedOutput);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream printOut = System.out;
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream(testCase.input.getBytes()));

        try {
          Main.main(new String[0]);
        } catch (Exception e) {
          printFail(i + 1, testCase, e.getMessage());
          continue;
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
          ====== %s ======%n
          [입력 값]
          %s
          [기대 값]
          %s%n
          """, red(caseNumber + " 번째 케이스 실패 "), testCase.input, testCase.expectedOutput);

      System.out.println(message);
    }

    public static String red(String message) {
      return "\u001B[31m%s\u001B[0m".formatted(message);
    }
  }
