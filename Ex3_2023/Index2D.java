public class Index2D implements Pixel2D {
    private int _x, _y;
    public Index2D() {
        this(0,0);} // constructor
    public Index2D(int x, int y) {//////////////////
        _x=x;_y=y;}
    public Index2D(Pixel2D t) {
        this(t.getX(), t.getY());}
    @Override
    public int getX() {
        return _x;
    }
    @Override
    public int getY() {
        return _y;
    }
    public double distance2D(Pixel2D t) {
        double ans = 0;
        /////// add your code below ///////
        double a=Math.pow(this.getX()-t.getX(),2);
        double b=Math.pow(this.getY()-t.getY(),2);
        double dist= Math.sqrt(a+b);
        ans=dist;
        ///////////////////////////////////
        return ans;
    }
    @Override
    public String toString() {
        return "("+getX()+","+getY()+")";
    }
    @Override
    public boolean equals(Object t) {
        boolean ans = false;
        /////// you do NOT need to add your code below ///////
        if(t instanceof Pixel2D) {
            Pixel2D p = (Pixel2D) t;
            ans = (this.distance2D(p)==0);
        }
        ///////////////////////////////////
        return ans;
    }
}