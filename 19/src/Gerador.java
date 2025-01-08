import java.util.*;

public abstract class Gerador {
  protected List<Integer> sequencia = new ArrayList<>();

  public abstract void gerar(int quantidade);
  
  public List<Integer> getSequencia(){
    return this.sequencia;
  }

}
