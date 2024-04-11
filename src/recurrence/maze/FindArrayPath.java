package recurrence.maze;

import java.util.Arrays;

public class FindArrayPath {
    public static void main(String[] args) {
        // findPath("", 3, 3);
        // int count = countTotalPaths(3, 3);
        // System.out.println(count);
        // diagonalPath("", 3, 3);
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };
        int[][] arr = new int[maze.length][maze[0].length];
        findPathWithMatric("", maze, 0, 0, arr, 1);
        // findAllPaths("", maze, 0, 0);
    }

    static void findPath(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (c > 1) {
            findPath(p + 'R', r, c - 1);
        }
        if (r > 1) {
            findPath(p + 'D', r - 1, c);
        }
    }

    static int countTotalPaths(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = countTotalPaths(r - 1, c);
        int right = countTotalPaths(r, c - 1);
        return left + right;
    }

    static void diagonalPath(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (c > 1) {
            findPath(p + 'H', r, c - 1);
        }
        if (r > 1) {
            findPath(p + 'V', r - 1, c);
        }

        if (r > 1 && c > 1) {
            findPath(p + 'D', r - 1, c - 1);
        }
    }

    static void findAllPaths(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        if (c < maze[0].length - 1) {
            findAllPaths(p + 'R', maze, r, c + 1);
        }
        if (r < maze.length - 1) {
            findAllPaths(p + 'D', maze, r + 1, c);
        }

        if (r > 0) {
            findAllPaths(p + 'U', maze, r - 1, c);
        }

        if (c > 0) {
            findAllPaths(p + 'L', maze, r, c - 1);
        }

        maze[r][c] = true;
    }

    static void findPathWithMatric(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (!maze[r][c]) {
            return;
        }

        path[r][c] = step;
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            return;
        }
        maze[r][c] = false;

        if (c < maze[0].length - 1) {
            findPathWithMatric(p + 'R', maze, r, c + 1, path, step + 1);
        }

        if (r < maze.length - 1) {
            findPathWithMatric(p + 'D', maze, r + 1, c, path, step + 1);
        }

        if (r > 0) {
            findPathWithMatric(p + 'U', maze, r - 1, c, path, step + 1);
        }

        if (c > 0) {
            findPathWithMatric(p + 'L', maze, r, c - 1, path, step + 1);
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
