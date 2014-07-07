package jp.co.fitec.lesson.feng;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {

		String sql = "SELECT * FROM author";
		
		try (Connection conn = ConnectionUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			System.out.println(conn);
			
			while(rs.next()){
				
//				String id = rs.getString("id");
//				String name = rs.getString("name");
//				String result = id + " " + name;
//				System.out.println(result);
				
				System.out.println(rs.getInt("code") + " : " + rs.getString("name"));
				
			}
			

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

}

















//String url = "jdbc:mysql://localhost:3306/lesson";
//String user = "root";
//String pass = "mysql";
// try {
// Connection conn = DriverManager.getConnection(url,user,pass);
//
// conn.close();
// } catch (SQLException e) {
// e.printStackTrace();
// }
//

