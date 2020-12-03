package java_miniproject;

import java.sql.*;
import java.util.ArrayList;

class UserInfo{
    String Account_Name,websiteName,username,password;
    UserInfo(){

    }
    UserInfo(String acc,String web,String name,String pass){
        Account_Name=acc;
        websiteName=web;
        username=name;
        password=pass;
    }
}
public class UserDBUtilities {
    Connection connection;
    String url="jdbc:sqlite:C:\\Users\\Vignesh\\Desktop\\JavaDev\\db\\Users.db";
    //AS SOON AS OBJECT OF THIS CLASS IS CREATED AN CONNECTION IS ESTABLISHED WITH THE USER DB.
    UserDBUtilities() throws SQLException {
        connection = DriverManager.getConnection(url);
    }
    public void endConnection() throws SQLException {
        if(connection !=null){
            connection.close();
        }
    }
    public void insert(String accName,String websiteName,String username,String password) throws SQLException {
        String statement="INSERT INTO Users VALUES(?,?,?,?)";
        PreparedStatement query=connection.prepareStatement(statement);
        query.setString(1,accName);
        query.setString(2,websiteName);
        query.setString(3,username);
        query.setString(4,password);
        query.executeUpdate();
    }
    public ArrayList<UserInfo> getInfo(String user) throws SQLException {
        String statement="SELECT * FROM Users WHERE Account_Name=?";
        PreparedStatement query=connection.prepareStatement(statement);
        query.setString(1,user);
        ResultSet result=query.executeQuery();
        UserInfo info;
        ArrayList<UserInfo> infoList=new ArrayList<>();
        while(result.next()) {
            info=new UserInfo();
            info.Account_Name = result.getString(1);
            info.websiteName = result.getString(2);
            info.username = result.getString(3);
            info.password = result.getString(4);
            infoList.add(info);
        }
        return infoList;
    }
    public void deleteField(UserInfo infoToDelete) throws SQLException {
        String statement="DELETE FROM Users WHERE Account_Name=? AND website=? AND username=? AND password=?";
        PreparedStatement query=connection.prepareStatement(statement);
        query.setString(1,infoToDelete.Account_Name);
        query.setString(2,infoToDelete.websiteName);
        query.setString(3,infoToDelete.username);
        query.setString(4,infoToDelete.password);
        query.executeUpdate();
    }
    public static void main(String[] args) {

    }
}
