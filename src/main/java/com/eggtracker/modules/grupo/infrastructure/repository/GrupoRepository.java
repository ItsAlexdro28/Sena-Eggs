package com.eggtracker.modules.grupo.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Properties;

import com.eggtracker.modules.grupo.domain.entity.Grupo;
import com.eggtracker.modules.grupo.domain.service.GrupoService;

public class GrupoRepository implements GrupoService {
    private Connection connection;

    public GrupoRepository() {
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
    public void createGrupo(Grupo grupo) {
        try {
            String query = "INSERT INTO Grupos (nombre, descripcion) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, grupo.getNombre());
                statement.setString(2, grupo.getDescripcion());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el grupo", e);
        }
    }

    @Override
    public Optional<Grupo> readGrupo(int grupoId) {
        try {
            String query = "SELECT * FROM Grupos WHERE grupo_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, grupoId);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Grupo grupo = new Grupo();
                    grupo.setGrupoId(resultSet.getInt("grupo_id"));
                    grupo.setNombre(resultSet.getString("nombre"));
                    grupo.setDescripcion(resultSet.getString("descripcion"));
                    grupo.setFechaCreacion(resultSet.getString("fecha_creacion"));
                    return Optional.of(grupo);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el grupo", e);
        }
        return Optional.empty();
    }

    @Override
    public void updateGrupo(Grupo grupo, int id) {
        try {
            String query = "UPDATE Grupos SET nombre = ?, descripcion = ? WHERE grupo_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, grupo.getNombre());
                statement.setString(2, grupo.getDescripcion());
                statement.setInt(3, id);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el grupo", e);
        }
    }

    @Override
    public void deleteGrupo(int grupoId) {
        try {
            String query = "DELETE FROM Grupos WHERE grupo_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, grupoId);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el grupo", e);
        }
    }
}
