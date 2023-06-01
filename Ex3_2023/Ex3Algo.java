

import java.awt.*;

import java.util.Arrays;

import exe.ex3.game.Game;
import exe.ex3.game.GhostCL;
import exe.ex3.game.PacManAlgo;
import exe.ex3.game.PacmanGame;

/**
 * This is the major algorithmic class for Ex3 - the PacMan game:
 * <p>
 * This code is a very simple example (random-walk algorithm).
 * Your task is to implement (here) your PacMan algorithm.
 */
public class Ex3Algo implements PacManAlgo {
    private int _count;

    public Ex3Algo() {
        _count = 0;
    }

    @Override
    /**
     *  Add a short description for the algorithm as a String.
     */
    public String getInfo() {
        return null;
    }

    @Override
    /**
     * This ia the main method - that you should design, implement and test.
     */
    public int move(PacmanGame game) {
        if (_count == 0 || _count == 300) {
            int code = 0;
            int[][] board = game.getGame(0);
            printBoard(board);
            int blue = Game.getIntColor(Color.BLUE, code);
            int pink = Game.getIntColor(Color.PINK, code);
            int black = Game.getIntColor(Color.BLACK, code);
            int green = Game.getIntColor(Color.GREEN, code);
            System.out.println("Blue=" + blue + ", Pink=" + pink + ", Black=" + black + ", Green=" + green);
            String pos = game.getPos(code);
            System.out.println("Pacman coordinate: " + pos);
            /// parse str to pixel
            System.out.println(stringToPixel(pos));
            ///
            GhostCL[] ghosts = game.getGhosts(code);
            printGhosts(ghosts);
            int up = Game.UP, left = Game.LEFT, down = Game.DOWN, right = Game.RIGHT;
        }
        _count++;
        //int dir = 0;
        //packman pos
        //Pixel2D pc= new Index2D(stringToPixel(game.getPos(0).toString()));
        //	Pixel2D ghost= new Index2D(stringToPixel(ghosts[0]
        GhostCL[] gh = game.getGhosts(0);
        Pixel2D pp = stringToPixel(game.getPos(0));
        Pixel2D[] gp = new Pixel2D[gh.length];
        for (int i = 0; i < gh.length; i++) {
            gp[i] = new Index2D(stringToPixel(gh[i].getPos(0)));
        }

        Map map = new Map(game.getGame(0));
        Map2D mapall = new Map(map.allDistance(pp, 1).getMap());
        Pixel2D farest = new Index2D(0, 0);
        Pixel2D nearest = map.getNearestEatable(pp, 1, new int[]{3, 5});

        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                if (map.getPixel(x, y) == 3 || map.getPixel(x, y) == 5) {
                    if (mapall.getPixel(farest) < mapall.getPixel(x, y)) {
                        farest = new Index2D(x, y);
                    }
                }

            }
        }
        Pixel2D[] sp = map.shortestPath(pp, nearest, 1);
//        System.out.println("----------------------- shortest pixels");
//        System.out.println(Arrays.toString(sp));

//        pp = sp[sp.length - 1];
        return toMove(map, pp, sp[1]);
    }

//}

    private static void printBoard(int[][] b) {
        for (int y = 0; y < b[0].length; y++) {
            for (int x = 0; x < b.length; x++) {
                int v = b[x][y];
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }

    private static void printGhosts(GhostCL[] gs) {
        for (int i = 0; i < gs.length; i++) {
            GhostCL g = gs[i];
            System.out.println(i + ") status: " + g.getStatus() + ",  type: " + g.getType() + ",  pos: " + g.getPos(0) + ",  time: " + g.remainTimeAsEatable(0));
        }
    }

    private static int randomDir() {
        int[] dirs = {Game.UP, Game.LEFT, Game.DOWN, Game.RIGHT};
        int ind = (int) (Math.random() * dirs.length);
        return dirs[ind];
    }

    private static Pixel2D stringToPixel(String str) {
        String[] arr = str.split(",");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        return new Index2D(x, y);
    }

    private static int toMove(Map map, Pixel2D from, Pixel2D to) {

        System.out.println("from:" + from);
        System.out.println("to:" + to);

        if (map.isCyclic()) {
            if (from.getX() == to.getX()) {
                if (from.getY() == map.getHeight() - 1 && to.getY() == 0) {
                    return Game.UP;
                }
                if (from.getY() == 0 && to.getY() == map.getHeight() - 1) {
                    return Game.DOWN;
                }
            }
            if (from.getY() == to.getY()) {
                if (from.getX() == map.getWidth() - 1 && to.getX() == 0) {
                    return Game.RIGHT;
                }
                if (from.getX() == 0 && to.getX() == map.getWidth() - 1) {
                    return Game.LEFT;
                }
            }
        }
        if (to.getX() == from.getX() && to.getY() < from.getY()) {
            return Game.DOWN;
            //	dirs[a] = down;
        }
        if (to.getX() == from.getX() && to.getY() > from.getY()) {
            return Game.UP;
            //	dirs[a] = up;
        }
        if (to.getX() < from.getX() && to.getY() == from.getY()) {
            return Game.LEFT;
            //dirs[a] = right;
        }
        if (to.getX() > from.getX() && to.getY() == from.getY()) {
            return Game.RIGHT;
            //dirs[a] = left;
        }
        return Game.PAUSE;
    }
}