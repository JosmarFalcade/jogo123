package servicos;

public class ServicosFactory {
    private static VitimasServicos vitimaS = new VitimasServicos();

    public static VitimasServicos getVitimaServicos(){
        return vitimaS;
    }

}
