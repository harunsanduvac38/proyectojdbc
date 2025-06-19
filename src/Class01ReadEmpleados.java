import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class01ReadEmpleados {
    public static void main (String[] args)  {

        // 1)Registrar la clase de nuestro driver jdbc de mysql
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2)Necesitamos una cadena e conexión
        String connectionString = "jdbc:mysql://localhost:3306/hospital";

        // 3)Crear una conexión mediante DRIVERMANAGER
        Connection cn = DriverManager.getConnection(connectionString, "root", "root");


        // 4)Consultar sobre la BBDD
        String sql = "select * from EMP";

        // 5) Creamos el tipo de statement dependiendo de la consulta (Aquí consulta simple)
        Statement st = cn.createStatement();

        // 6) como es un consulta sleect, necesitamos un ResultSet y el metodo executeQuery()
        ResultSet rs = st.executeQuery(sql); 
        rs.next();
        rs.next();

        // 7) Recuperamos el primer apellido
        String apellido = rs.getString("apellido");
        System.out.println("Apellido: " + apellido);

        } catch (ClassNotFoundException e) {
            System.out.println("class:" + e);
        } catch (SQLException e2) {
            System.out.println("SQL:" + e2);
        }
    
    }

    
}
