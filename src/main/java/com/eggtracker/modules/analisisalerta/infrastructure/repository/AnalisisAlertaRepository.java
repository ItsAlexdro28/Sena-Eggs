package com.eggtracker.modules.analisisalerta.infrastructure.repository;

import com.eggtracker.modules.analisisalerta.domain.entity.AnalisisAlerta;
import com.eggtracker.modules.analisisalerta.domain.service.AnalisisAlertaService;
import java.sql.*;
import java.util.Optional;

public class AnalisisAlertaRepository{
    private Connection connection;

    public AnalisisAlertaRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(AnalisisAlerta analisisAlerta) throws SQLException {
        String sql = "INSERT INTO Analisis_Alertas (usuario_id, fecha, tipo_analisis, descripcion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, analisisAlerta.getUsuarioId());
            ps.setString(2, analisisAlerta.getFecha());
            ps.setString(3, analisisAlerta.getTipoAnalisis());
            ps.setString(4, analisisAlerta.getDescripcion());
            ps.executeUpdate();
        }
    }

    public Optional<AnalisisAlerta> read(int analisisId) throws SQLException {
        String sql = "SELECT * FROM Analisis_Alertas WHERE analisis_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, analisisId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AnalisisAlerta analisisAlerta = new AnalisisAlerta(
                    rs.getInt("analisis_id"),
                    rs.getInt("usuario_id"),
                    rs.getString("fecha"),
                    rs.getString("tipo_analisis"),
                    rs.getString("descripcion")
                );
                return Optional.of(analisisAlerta);
            }
        }
        return Optional.empty();
    }

    public void update(AnalisisAlerta analisisAlerta) throws SQLException {
        String sql = "UPDATE Analisis_Alertas SET tipo_analisis = ?, descripcion = ? WHERE analisis_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, analisisAlerta.getTipoAnalisis());
            ps.setString(2, analisisAlerta.getDescripcion());
            ps.setInt(3, analisisAlerta.getAnalisisId());
            ps.executeUpdate();
        }
    }

    public void delete(int analisisId) throws SQLException {
        String sql = "DELETE FROM Analisis_Alertas WHERE analisis_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, analisisId);
            ps.executeUpdate();
        }
    }
}
