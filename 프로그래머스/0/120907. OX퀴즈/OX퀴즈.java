class Solution {

    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        int i = 0;
        for (String q : quiz) {
            String[] parts = q.split(" = ");
            String expr = parts[0];
            int expect = Integer.parseInt(parts[1]);

            String[] tokens = expr.split(" ");
            int left = Integer.parseInt(tokens[0]);
            String operator = tokens[1];
            int right = Integer.parseInt(tokens[2]);

            int actual = operator.equals("+") ? left + right : left - right;

            answer[i++] = actual == expect ? "O" : "X";
        }
        return answer;
    }

}