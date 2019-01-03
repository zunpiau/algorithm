package codewars;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Finder {

    static boolean pathFinder(String maze) {
        if (".".equals(maze)) return true;
        boolean[] used = new boolean[maze.length()];
        int n = maze.indexOf('\n');
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        used[0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 1 && node.y == n - 1) return true;
            addIfValid(node.x + 1, node.y, n, used, maze, queue);
            addIfValid(node.x - 1, node.y, n, used, maze, queue);
            addIfValid(node.x, node.y + 1, n, used, maze, queue);
            addIfValid(node.x, node.y - 1, n, used, maze, queue);
        }
        return false;
    }

    private static void addIfValid(int x, int y, int n, boolean[] used, String maze, Queue<Node> queue) {
        int pos = y * (n + 1) + x;
        if (x >= n || y >= n || x < 0 || y < 0 || used[pos] || maze.charAt(pos) == 'W') return;
        queue.add(new Node(x, y));
        used[pos] = true;
    }

    @Test
    public void sampleTests() {

        String a = ".W.\n" +
                   ".W.\n" +
                   "...",

                b = ".W.\n" +
                    ".W.\n" +
                    "W..",

                c = "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    "......",

                d = "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    ".....W\n" +
                    "....W.",

                e = ".........WWWW.\n" +
                    "...W...W.W....\n" +
                    "W.W...WW......\n" +
                    "....W.W...W...\n" +
                    "W.W.....W...W.\n" +
                    "W......W......\n" +
                    "..W.W....WWWW.\n" +
                    "...W..........\n" +
                    ".W......WWW...\n" +
                    ".......WW...W.\n" +
                    ".W..W.....W.WW\n" +
                    ".W.W...W...WW.\n" +
                    "W..WWW.WW.W...\n" +
                    ".....WWW.W....";

        assertTrue(pathFinder(a));
        assertFalse(pathFinder(b));
        assertTrue(pathFinder(c));
        assertFalse(pathFinder(d));
        assertFalse(pathFinder(e));
    }

    static class Node {

        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
