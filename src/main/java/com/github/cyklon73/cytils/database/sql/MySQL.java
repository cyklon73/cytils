package com.github.cyklon73.cytils.database.sql;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.*;

public class MySQL {

    private static String host;
    private static String port;
    private static String database;
    private static String username;
    private static String password;
    private static String connectionString;
    private static boolean use_connection_string;

    private static final String prefix = "[MySQL] ";

    private static Connection con;

    public static void Init(FileConfiguration config) {
        host = config.getString("database.host");
        port = config.getString("database.port");
        database = config.getString("database.database");
        username = config.getString("database.username");
        password = config.getString("database.password");
        connectionString = config.getString("database.connection_string");
        use_connection_string = config.getBoolean("database.use_connection_string");
    }

    public static boolean isConnected() {
        return con != null;
    }

    public static void connect() {
        if (!isConnected()) {
            try {
                if (use_connection_string) con = DriverManager.getConnection(connectionString);
                else con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);
                System.out.println(prefix + "Successfully Connected to Database");
            } catch (SQLException throwables) {
                System.out.println(prefix + "Failed to connect to database \n" + ChatColor.RED + "cause: \n" + throwables.getMessage());
            }
        }
    }

    public static void disconnect() {
        if (isConnected()) {
            try {
                con.close();
                Bukkit.getConsoleSender().sendMessage(prefix + "Successfully Disconnected from Database");
            } catch (SQLException throwables) {
                Bukkit.getConsoleSender().sendMessage(prefix + "Failed to Disconnect from database \n" + ChatColor.RED + "cause: \n" + throwables.getMessage());
            }
        }
    }

    public static PreparedStatement getStatement(String sql) {
        if (isConnected()) {
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                return ps;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public static ResultSet getResult(String sql) {
        if (isConnected()) {
            PreparedStatement ps;
            ResultSet rs;
            try {
                ps = getStatement(sql);
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}
