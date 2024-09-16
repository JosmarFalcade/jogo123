package servicos;

public class ServicosFactory {
    private static VitimasServicos vitimaS = new VitimasServicos();

    public static VitimasServicos getVitimaServicos() {
        return vitimaS;
    }

    private static GuerreiroServicos guerreiro = new GuerreiroServicos();

    public static GuerreiroServicos getGuerreiroServicos() {
        return guerreiro;
    }

    private static LadraoServicos ladrao = new LadraoServicos();

    public static LadraoServicos getLadraoServicos() {
        return ladrao;
    }

}
