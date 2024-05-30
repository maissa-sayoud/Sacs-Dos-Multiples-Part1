public class NoeudA {
    private int[][] matrice;
    private int[] tp;
    private int vtotale;
    private int p;
    private int g;
    private int h;
    private int f;

    public NoeudA(int[][] matrice, int[] tp, int vtotale, int p, int g,int h,int f) {
        this.matrice = matrice;
        this.tp = tp;
        this.vtotale = vtotale;
        this.p = p;
        this.g=g;
        this.h=h;
        this.f=f;
    }
    
    public int getG() {
        return g;
    }
    public void setG(int g){
        this.g=g;
    }
    public int getH() {
        return h;
    }
    public void setH(int h){
        this.h=h;
    }
    public int getF() {
        return f;
    }
    public void setf(int f){
        this.f=f;
    }
    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }

    public int[] getTp() {
        return tp;
    }

    public void setTp(int[] tp) {
        this.tp = tp;
    }

    public int getVtotale() {
        return vtotale;
    }

    public void setVtotale(int vtotale) {
        this.vtotale = vtotale;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
}