package servicos;

public class ServicosFactory {
    private static VitimaServicos vitimaS = new VitimaServicos();

    public static VitimaServicos getVitimaServicos(){
        return vitimaS;
    }

}
