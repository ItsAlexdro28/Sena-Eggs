package com.eggtracker.modules.gallina.infrastructure.repository;

import com.eggtracker.modules.gallina.domain.entity.Gallina;
import com.eggtracker.modules.gallina.domain.service.GallinaService;

import java.sql.*;
import java.util.Optional;
import java.util.Properties;

public class GallinaRepository implements GallinaService {
    private Connection connection;

    public GallinaRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            this.connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    @Override
    public void createGallina(Gallina gallina) {
        try {
            String query = "INSERT INTO Gallinas (nombre, fecha_nacimiento, grupo_id, estado) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, gallina.getNombre());
                statement.setString(2, gallina.getFechaNacimiento());
                statement.setInt(3, gallina.getGrupoId());
                statement.setString(4, gallina.getEstado());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la gallina", e);
        }
    }

    @Override
    public Optional<Gallina> readGallina(int gallinaId) {
        try {
            String query = "SELECT * FROM Gallinas WHERE gallina_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, gallinaId);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Gallina gallina = new Gallina();
                    gallina.setGallinaId(resultSet.getInt("gallina_id"));
                    gallina.setNombre(resultSet.getString("nombre"));
                    gallina.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                    gallina.setGrupoId(resultSet.getInt("grupo_id"));
                    gallina.setEstado(resultSet.getString("estado"));
                    return Optional.of(gallina);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al leer la gallina", e);
        }
        return Optional.empty();
    }

    @Override
    public void updateGallina(Gallina gallina, int id) {
        try {
            String query = "UPDATE Gallinas SET nombre = ?, fecha_nacimiento = ?, estado = ? WHERE gallina_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, gallina.getNombre());
                statement.setString(2, gallina.getFechaNacimiento());
                statement.setString(3, gallina.getEstado());
                statement.setInt(4, id);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la gallina", e);
        }
    }

    @Override
    public void deleteGallina(int gallinaId) {
        try {
            String query = "DELETE FROM Gallinas WHERE gallina_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, gallinaId);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la gallina", e);
        }
    }
}
