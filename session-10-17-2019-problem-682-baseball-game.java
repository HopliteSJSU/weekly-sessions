/**
 * Question: 682. Baseball Game 
 * Link: https://leetcode.com/problems/baseball-game/
 * Hoplite Session: 10/17/2019
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * N is the length of input
 * 
 * Approach: Use stack to maintain the scores.
 * 
 */

class Solution {
    public int calPoints(String[] ops) {
        if (ops.length == 0)
            return 0;

        Stack<Integer> scores = new Stack();
        int pointSum = 0;

        for (String operation : ops) {
            switch (operation) {
            case "D": // New score is double previous score
                if (!scores.isEmpty()) {
                    int previousScore = scores.peek();
                    int newScore = previousScore * 2;
                    scores.add(newScore);
                    pointSum += newScore;
                }
                break;
            case "+": // New score is sum of last two scores
                if (!scores.isEmpty()) {
                    int lastScore = scores.pop();
                    int secondLastScore = scores.peek();
                    int newScore = lastScore + secondLastScore;
                    pointSum += newScore;
                    scores.add(lastScore);
                    scores.add(newScore);
                }
                break;
            case "C": // Invalidate last score
                if (!scores.isEmpty()) {
                    int previousScore = scores.pop();
                    pointSum -= previousScore;
                }
                break;
            default:
                try { // New scores
                    int newScore = Integer.parseInt(operation);
                    pointSum += newScore;
                    scores.add(newScore);
                } catch (Exception e) {
                }
                break;
            }
        }
        return pointSum;
    }
}