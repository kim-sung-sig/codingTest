import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> result = new ArrayList<>();

        String[][] field = new String[3][3];
        String line;
        while (!(line = br.readLine()).equals("end")) {
            String[] firstRow = line.substring(0, 3).split("");
            String[] secondRow = line.substring(3, 6).split("");
            String[] thirdRow = line.substring(6, 9).split("");

            field[0] = firstRow; field[1] = secondRow; field[2] = thirdRow;

            // isValidTurn
            if (!isValidTurn(field)) {
                result.add("invalid");
                continue;
            }

            // ticTacToe
            if (ticTacToe(field)) result.add("valid");
            else result.add("invalid");

        }

        result.forEach(System.out::println);
    }

    static boolean isValidTurn(String[][] field) {
        int xCnt = count("X", field), oCnt = count("O", field);
        return xCnt == oCnt || xCnt == oCnt + 1;
    }

    // X 또는 O의 개수를 세는 함수
    static int count(String player, String[][] field) {
        int count = 0;
        for (String[] row : field) {
            for (String cell : row) {
                if (cell.equals(player)) count++;
            }
        }
        return count;
    }

    static boolean ticTacToe(String[][] field) {
        boolean xWin = false, oWin = false;

        // check rows
        for (String[] row : field) {
            String col1 = row[0], col2 = row[1], col3 = row[2];
            if (col1.equals(col2) && col2.equals(col3)) {
                if (col1.equals("X")) xWin = true;
                else if (col1.equals("O")) oWin = true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            String row1 = field[0][i], row2 = field[1][i], row3 = field[2][i];
            if (row1.equals(row2) && row2.equals(row3)) {
                if (row1.equals("X")) xWin = true;
                else if (row1.equals("O")) oWin = true;
            }
        }

        // diagonal 1
        String diag1_1 = field[0][0], diag1_2 = field[1][1], diag1_3 = field[2][2];
        if (diag1_1.equals(diag1_2) && diag1_2.equals(diag1_3) && !diag1_1.equals(".")) {
            if (diag1_1.equals("X")) xWin = true;
            else if (diag1_1.equals("O")) oWin = true;
        }

        // diagonal 2
        String diag2_1 = field[0][2], diag2_2 = field[1][1], diag2_3 = field[2][0];
        if (diag2_1.equals(diag2_2) && diag2_2.equals(diag2_3) && !diag2_1.equals(".")) {
            if (diag2_1.equals("X")) xWin = true;
            else if (diag2_1.equals("O")) oWin = true;
        }

        // 둘다 이겼을 경우
        if (xWin && oWin) return false;

        // 둘 중 하나만 이겼을 경우
        if (xWin && (count("X", field) == count("O", field) + 1)) return true;
        else if(xWin && (count("X", field) != count("O", field) + 1)) return false;

        if (oWin && (count("X", field) == count("O", field))) return true;
        else if (oWin && (count("X", field) != count("O", field))) return false;

        // 승부가 나지 않은 경우
        if (isFinished(field)) return true;
        else return false;
    }

    static boolean isFinished(String[][] field) {
        for (String[] row : field) for (String cell : row) if (cell.equals(".")) return false;
        return true;
    }

    static void print(String[][] field) {
        System.out.println("------");
        for (String[] row : field) {
            for (String cell : row) System.out.print(cell);
            System.out.println();
        }
        System.out.println("------");
    }

}