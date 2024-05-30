

public class Noeud 
{
    private int[][] matrice;
    private int[] tp;
    private int vtotale;
    private int p;

    public Noeud(int[][] matrice, int[] tp, int vtotale, int p) 
    {
        this.matrice = matrice;
        this.tp = tp;
        this.vtotale = vtotale;
        this.p = p;
    }

    public int[][] getMatrice() 
    {
        return matrice;
    }

    public void setMatrice(int[][] matrice) 
    {
        this.matrice = matrice;
    }

    public int[] getTp() 
    {
        return tp;
    }

    public void setTp(int[] tp) 
    {
        this.tp = tp;
    }

    public int getVtotale() {
        return vtotale;
    }

    public void setVtotale(int vtotale) 
    {
        this.vtotale = vtotale;
    }

    public int getP() 
    {
        return p;
    }

    public void setP(int p) 
    {
        this.p = p;
    }
}

