import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static int target;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        br.close();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursive(0);

    }

    private static void recursive(int n) throws Exception {
        System.out.println(repeat("____", n) + "\"재귀함수가 뭔가요?\"");

        if(target == n) {
            System.out.println(repeat("____", n) + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(repeat("____", n) + "라고 답변하였지.");
            // bw.write();
            return;
        }

        System.out.println(repeat("____", n) + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(repeat("____", n) + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(repeat("____", n) + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        recursive(n + 1);
        System.out.println(repeat("____", n) + "라고 답변하였지.");
    }

    public static String repeat(String str, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(str);
        }
        return builder.toString();
    }

}