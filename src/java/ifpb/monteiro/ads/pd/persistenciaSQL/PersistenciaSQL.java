package ifpb.monteiro.ads.pd.persistenciaSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistenciaSQL {

	public static Connection conectar() throws SQLException {
		String url = "jdbc:mysql://localhost/projeto_HumQueCaro";
		String username = "root";
		String password = "coloque aqui sua senha";
		Connection connection;
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
