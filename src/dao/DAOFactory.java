package dao;

public class DAOFactory {
    private static VitimaDAO vDAO = new VitimaDAO();

    public static VitimaDAO getVitimaDAO() {
        return vDAO;
    }

}
