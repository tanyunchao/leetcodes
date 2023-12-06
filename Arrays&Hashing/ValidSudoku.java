import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] input = new char[][] {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println(isValidSudoku(input));
    }

    public static boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
        }

        ArrayList<HashSet<Character>> cols = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cols.add(new HashSet<>());
        }

        ArrayList<HashSet<Character>> boxes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    if (rows.get(i).contains(current)) {
                        return false;
                    } else {
                        rows.get(i).add(current);
                    }

                    if (cols.get(j).contains(current)) {
                        return false;
                    } else {
                        cols.get(j).add(current);
                    }

                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if (boxes.get(boxIndex).contains(current)) {
                        return false;
                    } else {
                        boxes.get(boxIndex).add(current);
                    }
                }
            }
        }
        return true;
    }

}
