package com.eggtracker.modules.reportesproduccion.infrastructure.repository;

import com.eggtracker.modules.reportesproduccion.domain.entity.ReporteProduccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ReporteProduccionRepository {
    private final Connection connection;

    public ReporteProduccionRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(ReporteProduccion reporteProduccion) {
        String sql = "INSERT INTO Reportes_Produccion (produccion_id, analisis_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reporteProduccion.getProduccionId());
            statement.setInt(2, reporteProduccion.getAnalisisId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear reporte de producción: " + e.getMessage());
        }
    }

    public Optional<ReporteProduccion> read(int reporteId) {
        String sql = "SELECT * FROM Reportes_Produccion WHERE reporte_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reporteId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ReporteProduccion reporteProduccion = new ReporteProduccion();
                reporteProduccion.setReporteId(resultSet.getInt("reporte_id"));
                reporteProduccion.setProduccionId(resultSet.getInt("produccion_id"));
                reporteProduccion.setAnalisisId(resultSet.getInt("analisis_id"));
                return Optional.of(reporteProduccion);
            }
        } catch (Exception e) {
            System.out.println("Error al leer reporte de producción: " + e.getMessage());
        }
        return Optional.empty();
    }

    public void update(ReporteProduccion reporteProduccion, int reporteId) {
        String sql = "UPDATE Reportes_Produccion SET produccion_id = ?, analisis_id = ? WHERE reporte_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reporteProduccion.getProduccionId());
            statement.setInt(2, reporteProduccion.getAnalisisId());
            statement.setInt(3, reporteId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar reporte de producción: " + e.getMessage());
        }
    }

    public void delete(int reporteId) {
        String sql = "DELETE FROM Reportes_Produccion WHERE reporte_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reporteId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar reporte de producción: " + e.getMessage());
        }
    }
}
