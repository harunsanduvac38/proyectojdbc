import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Class02BuscadorEmpleadosDept {

    public static void main (String[] args) {

        Scanner tecleado = new Scanner (System.in);
        System.out.println("Ingresa num de departamento: ");
        String idDepartamento = tecleado.nextLine();

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");
            String sql = "SELECT apellido, oficio FROM EMP WHERE dept_no=" + idDepartamento;
           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                String apellido = rs.getString("apellido");
                String oficina = rs.getString("oficio");
                System.out.println(apellido + " - " + oficina);
            }

            rs.close();
            cn.close();

        } catch(Exception e){
            System.out.println("Error gordo: " + e);
        }



        

    }

    
}
