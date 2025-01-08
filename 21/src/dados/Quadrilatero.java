package dados;
public class Quadrilatero extends FormaGeometrica {
    protected int l1, l2, l3, l4;
    
    public Quadrilatero(int x, int y, int l1, int l2, int l3, int l4){
        this.x=x;
        this.y=y;
        this.l1=l1;
        this.l2=l2;
        this.l3=l3;
        this.l4=l4;
    }

    @Override
    public double calculaArea() {
        return 0;
    }
    
    @Override
    public double calculaPerimetro() {
        return l1 + l2 + l3 + l4;
    }
}
