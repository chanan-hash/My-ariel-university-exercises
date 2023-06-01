import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a 2D map as a "screen" or a raster matrix or maze over integers.
 *
 * @author boaz.benmoshe
 */
public class Map implements Map2D {
    private int[][] _map;
    private boolean _cyclicFlag = true;

    /**
     * Constructs a w*h 2D raster map with an init value v.
     *
     * @param w
     * @param h
     * @param v
     */
    public Map(int w, int h, int v) {
        init(w, h, v);
    }

    /**
     * Constructs a square map (size*size).
     *
     * @param size
     */
    public Map(int size) {
        this(size, size, 0);
    }

    /**
     * Constructs a map from a given 2D array.
     *
     * @param data
     */
    public Map(int[][] data) {
        init(data);
    }

    @Override
    public void init(int w, int h, int v) {
        /////// add your code below ///////
        this._map = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                _map[i][j] = v;
            }
        }

        ///////////////////////////////////
    }

    @Override
    public void init(int[][] arr) {
        /////// add your code below ///////
        if (arr == null) {
            throw new RuntimeException("arr is null");
        }
        if (arr.length == 0) {
            throw new RuntimeException("arr is empty");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1].length != arr[i].length) {
                throw new RuntimeException("arr is a ragged array");
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length == 0) {
                throw new RuntimeException("arr is empty");
            }
        }

        int w = arr.length;
        int h = arr[0].length;
        this._map = new int[w][h];

        for (int i = 0; i < w; i++) {

            for (int j = 0; j < h; j++) {

                _map[i][j] = arr[i][j];
            }
        }

        ///////////////////////////////////
    }

    @Override
    public int[][] getMap() {
        int[][] ans = null;
        /////// add your code below ///////
        int w = this._map.length;
        int h = this._map[0].length;
        ans = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                ans[i][j] = this._map[i][j];
            }
        }

        ///////////////////////////////////
        return ans;
    }

    @Override
    /////// add your code below ///////
    public int getWidth() {
        int w = this._map.length;
        return w;
    }

    @Override
    /////// add your code below ///////
    public int getHeight() {
        int h = this._map[0].length;
        return h;
    }

    @Override
    /////// add your code below ///////
    public int getPixel(int x, int y) {
        if (isCyclic()) {
            x = (x + this.getWidth()) % this.getWidth();
            y = (y + this.getHeight()) % this.getHeight();
        }
        int v = this._map[x][y];
        return v;
    }

    @Override
    /////// add your code below ///////
    public int getPixel(Pixel2D p) {
        return this.getPixel(p.getX(), p.getY());
    }

    @Override
    /////// add your code below ///////
    public void setPixel(int x, int y, int v) {
        if (isCyclic()) {
            x = (x + this.getWidth()) % this.getWidth();
            y = (y + this.getHeight()) % this.getHeight();
        }
        this._map[x][y] = v;
    }

    @Override
    /////// add your code below ///////
    public void setPixel(Pixel2D p, int v) {
        this.setPixel(p.getX(), p.getY(), v);
    }

    @Override
    /**
     * Fills this map with the new color (new_v) starting from p.
     * https://en.wikipedia.org/wiki/Flood_fill
     */
    public int fill(Pixel2D xy, int new_v) {
        int ans = 0;
        /////// add your code below ///////
        Map2D map = new Map(this._map);
        int pColor = this.getPixel(xy);
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                if (map.getPixel(i, j) != pColor) {
                    map.setPixel(i, j, -1);
                }
            }
        }
        map = map.allDistance(xy, -1);
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                if (map.getPixel(i, j) >= 0) {
                    ans++;
                    map.setPixel(i, j, new_v);
                }
            }
        }
        this._map = map.getMap();

        return ans;
    }

    public Pixel2D getNearestEatable(Pixel2D pacmanPosition, int obsColor, int[] eatables) {
        Queue<Pixel2D> sp = new LinkedList<>();
        boolean[][] visited = new boolean[getWidth()][getHeight()];
        sp.add(pacmanPosition);
        int w = this.getWidth();
        int h = this.getHeight();
        while (!sp.isEmpty()) {
            Pixel2D temp = sp.remove();
            if (visited[temp.getX()][temp.getY()]) continue;
            visited[pacmanPosition.getX()][pacmanPosition.getY()] = true;

            // left
            int x_l = (temp.getX() - 1 + w) % w;
            int y_l = (temp.getY() + h) % h;
            Pixel2D left = new Index2D(x_l, y_l);

            //right
            int x_r = (temp.getX() + 1 + w) % w;
            int y_r = (temp.getY() + h) % h;
            Pixel2D right = new Index2D(x_r, y_r);

            //down
            int x_d = (temp.getX() + w) % w;
            int y_d = (temp.getY() - 1 + h) % h;
            Pixel2D down = new Index2D(x_d, y_d);

            //up
            int x_u = (temp.getX() + w) % w;
            int y_u = (temp.getY() + 1 + h) % h;
            Pixel2D up = new Index2D(x_u, y_u);

            if ((this.isCyclic() || isInside(right)) && (getPixel(right) == eatables[0] || getPixel(right) == eatables[1])) {
                return right;
            }
            if ((this.isCyclic() || isInside(left)) && (getPixel(left) == eatables[0] || getPixel(left) == eatables[1])) {
                return left;
            }
            if ((this.isCyclic() || isInside(up)) && (getPixel(up) == eatables[0] || getPixel(up) == eatables[1])) {
                return up;
            }
            if ((this.isCyclic() || isInside(down)) && (getPixel(down) == eatables[0] || getPixel(down) == eatables[1])) {
                return down;
            }

            if (getPixel(right) != obsColor) {
                sp.add(right);
            }
            if (getPixel(left) != obsColor) {
                sp.add(left);
            }
            if (getPixel(up) != obsColor) {
                sp.add(up);
            }
            if (getPixel(down) != obsColor) {
                sp.add(down);
            }
        }
        return null;
    }

    @Override
    /**
     * BFS like shortest the computation based on iterative raster implementation of BFS, see:
     * https://en.wikipedia.org/wiki/Breadth-first_search
     */
    public Pixel2D[] shortestPath(Pixel2D p1, Pixel2D p2, int obsColor) {
        Pixel2D[] ans = null;  // the result.
        /////// add your code below ///////
        Map2D mapSorted = this.allDistance(p1, obsColor);
        int target = mapSorted.getPixel(p2);
        if ((target == -1) || (target == -2)) {
            return null;
        }
        ///אם היעד הוא נקודת ההתחלה?? אולי לא הכרחי
        if (target == 0) {
            ans = new Pixel2D[1];
            ans[0] = p2;
            return ans;
        }
        int w = this.getWidth();
        int h = this.getHeight();
        ans = new Pixel2D[target + 1];

        Queue<Pixel2D> sp = new LinkedList<>();
        sp.add(p2);
        ans[target] = p2;
        while (!sp.isEmpty()) {
            Pixel2D temp = sp.remove();
            if (temp.equals(p1)) break;
            // left
            int x_l = (temp.getX() - 1 + w) % w;
            int y_l = (temp.getY() + h) % h;
            Pixel2D left = new Index2D(x_l, y_l);

            //right
            int x_r = (temp.getX() + 1 + w) % w;
            int y_r = (temp.getY() + h) % h;
            Pixel2D right = new Index2D(x_r, y_r);

            //down
            int x_d = (temp.getX() + w) % w;
            int y_d = (temp.getY() - 1 + h) % h;
            Pixel2D down = new Index2D(x_d, y_d);

            //up
            int x_u = (temp.getX() + w) % w;
            int y_u = (temp.getY() + 1 + h) % h;
            Pixel2D up = new Index2D(x_u, y_u);

            if ((this.isCyclic() || isInside(left)) && mapSorted.getPixel(left) == mapSorted.getPixel(temp) - 1) {
                sp.add(left);
                ans[mapSorted.getPixel(temp) - 1] = left;
                continue;
            }
            // if ((this.isCyclic() || checkIndex(temp.getX() + 1, temp.getY())) && mapSorted.getPixel(temp.getX() + 1, temp.getY()) == mapSorted.getPixel(temp) - 1) {
            if ((this.isCyclic() || isInside(right)) && mapSorted.getPixel(right) == mapSorted.getPixel(temp) - 1) {
                sp.add(right);
                ans[mapSorted.getPixel(temp) - 1] = right;
                continue;
            }
            if ((this.isCyclic() || isInside(down)) && mapSorted.getPixel(down) == mapSorted.getPixel(temp) - 1) {
                sp.add(down);
                ans[mapSorted.getPixel(temp) - 1] = down;
                continue;
            }
            if ((this.isCyclic() || isInside(up)) && mapSorted.getPixel(up) == mapSorted.getPixel(temp) - 1) {
                sp.add(up);
                ans[mapSorted.getPixel(temp) - 1] = up;
            }

        }
        ///////////////////////////////////
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 3}, {0, 0, 3, 0}, {3, 3, 3, 0}, {0, 0, 3, 0}};
        Map2D map = new Map(arr);
        Pixel2D p1 = new Index2D(0, 0);
        Pixel2D p2 = new Index2D(3, 3);
        System.out.println(Arrays.toString(map.shortestPath(p1, p2, 3)).toString());
        mapPrint(map);
        System.out.println();
        System.out.println(map.getPixel(2, 2));
        mapPrint(map.allDistance(p1, -1));
        System.out.println();

        map.fill(p1, 4);
        mapPrint(map);

    }

    @Override
    /////// add your code below ///////
    public boolean isInside(Pixel2D p) {
        int x = p.getX();
        int y = p.getY();
        return x >= 0 && x < _map.length && y >= 0 && y < _map[0].length;
    }

    @Override
    /////// add your code below ///////
    public boolean isCyclic() {
        return _cyclicFlag;
    }

    @Override
    /////// add your code below ///////
    public void setCyclic(boolean cy) {
        this._cyclicFlag = cy;
    }

    @Override
    /////// add your code below ///////
    public Map2D allDistance(Pixel2D start, int obsColor) {
        Map2D ans = null;  // the result.
        /////// add your code below ///////
        Map2D mapCopy = new Map(this._map);
        int curColor = getPixel(start);
        for (int i = 0; i < mapCopy.getWidth(); i++) {
            for (int j = 0; j < mapCopy.getHeight(); j++) {
                if (this._map[i][j] == obsColor) {
                    mapCopy.setPixel(i, j, -1);
                } else {
                    mapCopy.setPixel(i, j, -2);
                }
            }
        }
        Queue<Pixel2D> neighbors = new LinkedList<>();
        neighbors.add(start);
        mapCopy.setPixel(start, 0);

        while (!neighbors.isEmpty()) {
            Pixel2D temp = neighbors.remove();

            Pixel2D left = new Index2D(temp.getX() - 1, temp.getY());
            Pixel2D right = new Index2D(temp.getX() + 1, temp.getY());
            Pixel2D down = new Index2D(temp.getX(), temp.getY() - 1);
            Pixel2D up = new Index2D(temp.getX(), temp.getY() + 1);

            if ((this.isCyclic() || isInside(left)) && mapCopy.getPixel(left) == -2) {
                neighbors.add(left);
                mapCopy.setPixel(left, mapCopy.getPixel(temp) + 1);
            }
            if ((this.isCyclic() || isInside(right)) && mapCopy.getPixel(right) == -2) {
                neighbors.add(right);
                mapCopy.setPixel(right, mapCopy.getPixel(temp) + 1);
            }
            if ((this.isCyclic() || isInside(down)) && mapCopy.getPixel(down) == -2) {
                neighbors.add(down);
                mapCopy.setPixel(down, mapCopy.getPixel(temp) + 1);
            }
            if ((this.isCyclic() || isInside(up)) && mapCopy.getPixel(up) == -2) {
                neighbors.add(up);
                mapCopy.setPixel(up, mapCopy.getPixel(temp) + 1);
            }
        }
        ans = new Map(mapCopy.getMap());

        return ans;
    }

    boolean checkIndex(int x, int y) {
        return x >= 0 && x < _map.length && y >= 0 && y < _map[0].length;
    }


    /**
     * x,x
     * <p>
     * <p>
     * 0,0
     **/
    public static void mapPrint(Map2D m) {
        int[][] arr = m.getMap();
        int w = arr.length;
        int h = arr[0].length;
        for (int i = h - 1; i >= 0; i--) {
            System.out.println();
            for (int j = 0; j < h; j++) {
                System.out.print(arr[j][i] + "\t");
            }
        }
    }


}


