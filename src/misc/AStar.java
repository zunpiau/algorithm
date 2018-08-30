package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AStar {

    private static final int MAX_MAP_WIDTH = 100;
    private static final int COST_DIRECT = 10;
    private static final int COST_DIAGONAL = 14;

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        AStar aStar = new AStar();
        System.out.println(aStar.findPath(map, 2, 2, 4, 4));
    }

    public List<Node> findPath(int[][] map, int startX, int startY, int endX, int endY) {
        List<Node> openList = new ArrayList<>();
        List<Node> closeList = new ArrayList<>();
        List<Node> path = new ArrayList<>();
        Node end = new Node(endX, endY);
        openList.add(new Node(startX, startY));
        path.add(end);
        Node current;
        while (openList.size() != 0) {
            current = getMinFNode(openList);
            moveToOtherList(openList, current, closeList);
            List<Node> neighbors = getNeighbors(current, map);
            if (neighbors.contains(end)) {
                Node parent = current;
                while (parent != null) {
                    path.add(parent);
                    parent = parent.parent;
                }
                break;
            }
            neighbors.removeAll(closeList);
            for (Node neighbor : neighbors) {
                if (openList.contains(neighbor)) {
                    if (neighbor.G < current.G) {
                        processChild(neighbor, current, end);
                    }
                } else {
                    processChild(neighbor, current, end);
                    openList.add(neighbor);
                }
            }
        }
        if (path.size() == 1)
            return null;
        Collections.reverse(path);
        return path;
    }

    private void processChild(Node child, Node parent, Node end) {
        child.parent = parent;
        if (isAdjacent(child, parent)) {
            child.G = parent.G + COST_DIRECT;
        } else {
            child.G = parent.G + COST_DIAGONAL;
        }
        child.H = manhattan(child, end);
        child.F = child.H + child.G;
    }

    private int manhattan(Node node, Node other) {
        return (Math.abs(node.x - other.x) + Math.abs(node.y - other.y)) * COST_DIRECT;
    }

    /**
     * 判断是否在直线方向上
     */
    private boolean isAdjacent(Node node, Node other) {
        return Math.abs(node.x - other.x) + Math.abs(node.y - other.y) == 1;
    }

    private List<Node> getNeighbors(Node node, int[][] map) {
        List<Node> neighbors = new ArrayList<>(8);
        int x = node.x;
        int y = node.y;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i == x && j == y) && isValidNeighbor(i, j, map)) {
                    neighbors.add(new Node(i, j));
                }
            }
        }
        return neighbors;
    }

    private boolean isValidNeighbor(int x, int y, int[][] map) {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] == 0;
    }

    private Node getMinFNode(List<Node> nodeList) {
        return Collections.min(nodeList, Comparator.comparingInt(o -> o.F));
    }

    private void moveToOtherList(List<Node> src, Node node, List<Node> dist) {
        src.remove(node);
        dist.add(node);
    }

    static class Node {

        int x, y;
        Node parent;
        int H, G, F;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (obj instanceof Node) {
                Node node = (Node) obj;
                return node.x == this.x && node.y == this.y;
            }
            return false;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

        @Override
        public int hashCode() {
            return x * MAX_MAP_WIDTH + y;
        }
    }
}
