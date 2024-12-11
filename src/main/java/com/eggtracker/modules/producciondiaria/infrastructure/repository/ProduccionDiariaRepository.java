package com.eggtracker.modules.producciondiaria.infrastructure.repository;

import com.eggtracker.modules.producciondiaria.domain.entity.ProduccionDiaria;

import java.sql.*;
import java.util.Optional;

public class ProduccionDiariaRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/eggtracker";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void createProduccionDiaria(ProduccionDiaria produccionDiaria) throws SQLException {
        String query = "INSERT INTO Produccion_Diaria (gallina_id, fecha, cantidad) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, produccionDiaria.getGallinaId());
            ps.setDate(2, produccionDiaria.getFecha());
            ps.setInt(3, produccionDiaria.getCantidad());
            ps.executeUpdate();
        }
    }

    public Optional<ProduccionDiaria> readProduccionDiaria(int gallinaId, Date fecha) throws SQLException {
        String query = "SELECT * FROM Produccion_Diaria WHERE gallina_id = ? AND fecha = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, gallinaId);
            ps.setDate(2, fecha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ProduccionDiaria produccionDiaria = new ProduccionDiaria(
                        rs.getInt("produccion_id"),
                        rs.getInt("gallina_id"),
                        rs.getDate("fecha"),
                        rs.getInt("cantidad")
                );
                return Optional.of(produccionDiaria);
            }
        }
        return Optional.empty();
    }

    public void updateProduccionDiaria(ProduccionDiaria produccionDiaria, int produccionId) throws SQLException {
        String query = "UPDATE Produccion_Diaria SET gallina_id = ?, fecha = ?, cantidad = ? WHERE produccion_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, produccionDiaria.getGallinaId());
            ps.setDate(2, produccionDiaria.getFecha());
            ps.setInt(3, produccionDiaria.getCantidad());
            ps.setInt(4, produccionId);
            ps.executeUpdate();
        }
    }

    public void deleteProduccionDiaria(int produccionId) throws SQLException {
        String query = "DELETE FROM Produccion_Diaria WHERE produccion_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, produccionId);
            ps.executeUpdate();
        }
    }
}
