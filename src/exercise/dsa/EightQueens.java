package exercise.dsa;

public class EightQueens {

    private static boolean valid(int[] queue, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queue[i] == col || Math.abs(row - i) == Math.abs(col - queue[i]))
                return false;
        }
        return true;
    }

    private static void printQueue(int[] queue) {
        for (int aQueue : queue) {
            for (int j = 0; j < queue.length; j++) {
                if (aQueue == j) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void eightQueens(int[] queue, int row) {
        if (row >= queue.length) {
            printQueue(queue);
            return;
        }
        for (int col = 0; col < queue.length; col++) {
            if (valid(queue, row, col)) {
                queue[row] = col;
                eightQueens(queue, row + 1);
            }
        }
    }

    public static void eightQueens(int[] queue) {
        eightQueens(queue, 0);
    }

    public static void main(String[] args) {
        EightQueens.eightQueens(new int[5]);
    }

}
