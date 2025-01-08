package dados;

public abstract class FiguraGeometrica {
    private float coord_x;
    private float coord_y;

    public void setCoord_x(int x){
        coord_x = x;
    }

    public void setCoord_y(int y){
        coord_y = y;
    }

    public float getCoord_x(){
        return coord_x;
    }

    public float getCoord_y(){
        return coord_y;
    }

    public abstract float calculaPerimetro();
    public abstract float calculaArea();
}
