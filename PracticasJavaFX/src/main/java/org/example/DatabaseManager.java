package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:farmacia.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initDatabase() {
        String sql = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                email TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL
            );
        """;
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean registerUser(String nombre, String email, String passwordPlana) {
        String sql = "INSERT INTO usuarios(nombre, email, password) VALUES(?, ?, ?)";

        // Genera un hash con un salt de complejidad 12
        String passwordHash = BCrypt.hashpw(passwordPlana, BCrypt.gensalt(12));

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, email.toLowerCase().trim());
            pstmt.setString(3, passwordHash); // Se guarda el hash, no el texto plano
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static String authenticateUser(String email, String passwordPlana) {
        String sql = "SELECT nombre, password FROM usuarios WHERE email = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email.toLowerCase().trim());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String hashGuardado = rs.getString("password");
                // Compara la contraseña en texto plano recibida contra el hash almacenado
                if (BCrypt.checkpw(passwordPlana, hashGuardado)) {
                    return rs.getString("nombre");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Credenciales inválidas
    }
}
