package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        return checkHorizontal(board) || checkVertical(board);
    }

    public static boolean checkHorizontal(int[][] board) {
        int count = 0;
        for (int[] i : board) {
            for (int j : i) {
                if (j == 0) {
                    count = 0;
                    break;
                } else {
                    count++;
                }
            }
            if (count == board.length) {
                return true;
            }
        }
        return count == board.length;
    }

    public static boolean checkVertical(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == 0) {
                    count = 0;
                    break;
                } else {
                    count++;
                }
            }
            if (count == board.length) {
                return true;
            }
        }
        return count == board.length;
    }
}
