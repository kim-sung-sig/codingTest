import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals("end")) {

            // ticTacToe
            if (ticTacToe(line)) sb.append("valid\n");
            else sb.append("invalid\n");

        }
        System.out.println(sb);
    }

    static boolean ticTacToe(String line) {
        int xWin = 0, oWin = 0, xCnt = 0, oCnt = 0;
        boolean isDone = true;

        char[][] field = new char[3][3];

        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) {
            field[i][j] = line.charAt(i * 3 + j);
            if (field[i][j] == 'X') xCnt++;
            else if (field[i][j] == 'O') oCnt++;
            else isDone = false;
        }

        // check rows, columns
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                if (field[i][0] == 'X') xWin++;
                else if (field[i][0] == 'O') oWin++;
            }
            if (field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
                if (field[0][i] == 'X') xWin++;
                else if (field[0][i] == 'O') oWin++;
            }
        }

        // diagonal 1
        if (field[0][0] != '.' && field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            if (field[0][0] == 'X') xWin++;
            else if (field[0][0] == 'O') oWin++;
        }

        // diagonal 2
        if (field[2][0] != '.' && field[2][0] == field[1][1] && field[1][1] == field[0][2]) {
            if (field[2][0] == 'X') xWin++;
            else if (field[2][0] == 'O') oWin++;
        }

        if (xWin >= 1 && oWin >= 1) return false;

        if (xWin >= 1 && xCnt != oCnt + 1) return false;

        if (oWin >= 1 && xCnt != oCnt) return false;

        if (xWin + oWin == 0) if (!(xCnt == oCnt + 1) || !isDone) return false;

        return true;
    }

}