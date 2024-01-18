package sqlpack;
import java.sql.*;

public class sqlclass {

    public int finduser(String userid,String password){
        Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/atm",
				"user_name", "password");

			// atm is database
            // user_name is name of database
            // password is password of database

			Statement statement;
			statement = connection.createStatement();
            String query = "SELECT password FROM customers WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, userid);

            ResultSet resultSet = preparedStatement.executeQuery();
            String new_password="0";
            if(resultSet.equals(null)){
                return 0;
            }
            while (resultSet.next()) {
                new_password = (resultSet.getString("password"));
            }
            if(password.equals(new_password)){
                return 1;
            }
            resultSet.close();
			statement.close();
			connection.close();
            
        }catch (Exception exception) {
			System.out.println(exception);
		}
        return 0;
    }

	public String query_results(String query,String userid){
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/atm",
				"user_name", "password");

			Statement statement;
			statement = connection.createStatement();
            String final_query = "SELECT "+query+" FROM customers WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(final_query);

            preparedStatement.setString(1, userid);

            ResultSet resultSet = preparedStatement.executeQuery();
            String result="";
            while (resultSet.next()) {
                result = (resultSet.getString(query));
            }
            resultSet.close();
			statement.close();
			connection.close();
			return result;
            
        }catch (Exception exception) {
			System.out.println(exception);
		}
        return "";
	}
	public void update_values(String query,String value,String userid){
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/atm",
				"user_name", "password");

			Statement statement;
			statement = connection.createStatement();
            String final_query = "UPDATE customers SET "+query+" = "+value+" WHERE user_id = ?";
           	PreparedStatement preparedStatement = connection.prepareStatement(final_query);

            preparedStatement.setString(1, userid);

            int rowsaffected = preparedStatement.executeUpdate();
			statement.close();
			connection.close();
            
        }catch (Exception exception) {
			System.out.println(exception);
		}
	}
}
