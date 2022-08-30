package io.github.cyklon73.cytils.database.sql;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class SQLite {

    private static Connection conn;
    private static Statement stmt;

    public static void connect(String path) {
        connectToFile(new File(path));
    }

    public static void connect(File file) {
        connectToFile(file);
    }

    private static void connectToFile(File file) {
        conn = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            String url = "jdbc:sqlite:" + file.getAbsolutePath();
            conn = DriverManager.getConnection(url);

            stmt = conn.createStatement();

            System.out.println("Verbindung zur DatenBank hergestellt!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Verbindung zur DatenBank getrent!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdate(String sql) {
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet onQuery(String sql) {
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

