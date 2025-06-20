import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Class06IncrementoSalarialEmpleados {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost:3306/hospital";

            Connection cn = DriverManager.getConnection(connectionString, "root", "root");

            Statement st = cn.createStatement();

            String sqlSelect = "SELECT * FROM EMP";

            ResultSet rs = st.executeQuery(sqlSelect);


            while(rs.next()) {
                String ape = rs.getString("APELLIDO");
                String ofi = rs.getString("OFICIO");
                String sal = rs.getString("SALARIO");

                System.out.println(ape + " - " + ofi + " - " + sal);
            }

            System.out.println("El Oficio: ");
            String oficio = teclado.nextLine();
            oficio = oficio.toUpperCase();

            System.out.println("\nIncremento Salarial: ");
            String salario = teclado.nextLine();

            // UPDATE EMP SET SALARIO = SALARIO + 300 WHERE OFICIO='EMPLEADO';

            String sqlIncremento = "UPDATE EMP SET SALARIO = SALARIO + " + salario + " WHERE OFICIO='" + oficio + "'";

            int incSal = st.executeUpdate(sqlIncremento);

            System.out.println("\nSalarios Incrementados: " + incSal + "\n");
            sqlSelect = sqlSelect + " where OFICIO='" + oficio + "'";

            ResultSet rs2 = st.executeQuery(sqlSelect);


            while(rs2.next()) {
                String ape2 = rs2.getString("APELLIDO");
                String ofi2 = rs2.getString("OFICIO");
                String sal2 = rs2.getString("SALARIO");

                System.out.println(ape2 + " - " + ofi2 + " - " + sal2);

            }

            System.out.println("\n Fin de Programa \n");
            cn.close();
            rs.close();
            rs2.close();


        } catch (Exception e) {
            System.out.println("Error es: " + e);
        }

        
    }
    
}
