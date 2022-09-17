package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    //connection class used to make connections to our database
    //set as private static, so it can be used but not changed
    //a class creation is not needed to use this.
    private static Connection conn;

    //static method that returns a new connection, if connection has not been created
    public static Connection getConnection(){
        //if there is no connection, then we need to establish one
        if(conn == null){
            //need to run in a try catch block, so we can print stacktrace to see what happened
            try{
                String url = "jdbc:sqlserver://localhost:1433;trustServerCertificate=true";
                String username = "sa";
                String password = "P@SSWORD123";
                conn = DriverManager.getConnection(url,username,password);
            }catch (SQLException e){
                e.printStackTrace();
                //this spits out code if we can't get a connection, so we can figure out what we need to do
            }

        }
        return conn;
    }

}
