package main;
import java.awt.Graphics2D;

public class Labirinti {
    private final int cols, rows;
    private boolean[][] north;
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private boolean isDone = false;

    public Labirinti(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        init();
        generateLabirintin();
    }

    private void init() {
        visited = new boolean[cols + 2][rows + 2];
        for (int col = 0; col < cols + 2; col++) {
            visited[col][0] = true;
            visited[col][rows + 1] = true;
        }
        for (int row = 0; row < rows + 2; row++) {
            visited[0][row] = true;
            visited[cols + 1][row] = true;
        }

        north = new boolean[cols + 2][rows + 2];
        east = new boolean[cols + 2][rows + 2];
        south = new boolean[cols + 2][rows + 2];
        west = new boolean[cols + 2][rows + 2];
        for (int col = 0; col < cols + 2; col++) {
            for (int row = 0; row < rows + 2; row++) {
                north[col][row] = true;
                east[col][row] = true;
                south[col][row] = true;
                west[col][row] = true;
            }
        }
    }

    private void generateLabirintin(int col, int row) {
        visited[col][row] = true;

        while (!visited[col][row + 1] || !visited[col + 1][row] || !visited[col][row - 1] || !visited[col - 1][row]) {
            while (true) {
                double r = Math.random() * 4;
                if (r == 0 && !visited[col][row + 1]) {
                    north[col][row] = false;
                    south[col][row + 1] = false;
                    generateLabirintin(col, row + 1);
                    break;
                } else if (r == 1 && !visited[col + 1][row]) {
                    east[col][row] = false;
                    west[col + 1][row] = false;
                    generateLabirintin(col + 1, row);
                    break;
                } else if (r == 2 && !visited[col][row - 1]) {
                    south[col][row] = false;
                    north[col][row - 1] = false;
                    generateLabirintin(col, row - 1);
                    break;
                } else if (r == 3 && !visited[col - 1][row]) {
                    west[col][row] = false;
                    east[col - 1][row] = false;
                    generateLabirintin(col - 1, row);
                    break;
                }
            }
        }
    }

    private void generateLabirintin() {
        generateLabirintin(1, 1);
    }

    public void drawLabirintin(Graphics2D g2) {
        int wallSize = 10; // Adjust this size based on your preference

        for (int col = 1; col <= cols; col++) {
            for (int row = 1; row <= rows; row++) {
                if (south[col][row]) {
                    g2.fillRect(col * wallSize, (row + 1) * wallSize, wallSize, 2);
                }
                if (north[col][row]) {
                    g2.fillRect(col * wallSize, row * wallSize, wallSize, 2);
                }
                if (west[col][row]) {
                    g2.fillRect(col * wallSize, row * wallSize, 2, wallSize);
                }
                if (east[col][row]) {
                    g2.fillRect((col + 1) * wallSize, row * wallSize, 2, wallSize);
                }
            }
        }
    }
}
