import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Class04InsertarDepartamento {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost:3306/hospital";

            Connection cn = DriverManager.getConnection(connectionString, "root", "root");

            // SI QUEREMOS ADMINISTRAR NOSOTROS LOS COMMITS:
            cn.setAutoCommit(false);

            System.out.println("Id departamento: ");
            String id = teclado.nextLine();

            System.out.println("Nombre departamento: ");
            String nombre = teclado.nextLine();

            System.out.println("Localidad :");
            String local = teclado.nextLine();

            // insert into DEPT values(50, 'TEST', 'LOCALTEST')

            String sql = "insert into DEPT values (" + id + ", '" + nombre + "', '" + local + "')";
            

            Statement st = cn.createStatement();

            int registros = st.executeUpdate(sql);

            System.out.println("Registro insertado: " + registros);

            // Al ser una base de datos Transaccional (Mysql, Oracle..) debemos indicar que los cambios son permanentes
            // 1- Permanente: commit    2- Deshacer cambios: rollback


            cn.commit();


            cn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    
    
}
