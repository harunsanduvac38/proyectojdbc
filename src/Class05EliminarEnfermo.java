import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Class05EliminarEnfermo {
    public static void main (String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost:3306/hospital";

            Connection cn = DriverManager.getConnection(connectionString, "root", "root");

            System.out.println("Inscription de Enfermo:");
            String inscripcion = teclado.nextLine();

            // DELETE FROM ENFERMO WHERE INSCRIPCION=1234;
            String sql = "DELETE FROM ENFERMO WHERE INSCRIPCION=" + inscripcion;

            Statement st = cn.createStatement();

            int deleted = st.executeUpdate(sql);

            System.out.println("Enfermos eliminados: " + deleted);



            String sqlSelect = "Select * from ENFERMO";

            ResultSet rs = st.executeQuery(sqlSelect);

            while(rs.next()) {
                String ins = rs.getString("INSCRIPCION");
                String ape = rs.getString("APELLIDO");
                System.out.println(ins + " - " + ape);
            }


            rs.close();
            cn.close();
            
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    
    
    }
    
}
