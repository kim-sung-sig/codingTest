class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            String repeated = String.valueOf(i).repeat(count);
            left.append(repeated);
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left + "0" + right;
    }
}