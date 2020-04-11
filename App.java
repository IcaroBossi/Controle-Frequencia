package icaro;
import java.sql.*;

public class App {
    public static void main( String[] args ){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/controle-frequencia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ;
            String usuario = "root";
            String senha= "";



            Connection conexao = DriverManager.getConnection(url,usuario, senha);
            String consultar = "SELECT * FROM contato";
            PreparedStatement stmtSelect = conexao.prepareStatement(consultar);
            ResultSet rs = stmtSelect.executeQuery();
            while(rs.next() == true) {
                System.out.println(rs.getString("idcontato") + " - " + rs.getInt("tia") + " - " + rs.getString("nome") + " - " + rs.getString("horarioent") + " até " + rs.getString("horariosai"));
            }
            System.out.println("Inserido");
            conexao.close();
            System.out.println("Conexão encerrada");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
