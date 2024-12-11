package com.eggtracker.modules.configuracionusuario.infrastructure.repository;

import com.eggtracker.modules.configuracionusuario.domain.entity.ConfiguracionUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ConfiguracionUsuarioRepository {
    private final Connection connection;

    public ConfiguracionUsuarioRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(ConfiguracionUsuario configuracionUsuario) {
        String sql = "INSERT INTO Configuraciones_Usuario (usuario_id, notificaciones, tema, idioma) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, configuracionUsuario.getUsuarioId());
            statement.setBoolean(2, configuracionUsuario.isNotificaciones());
            statement.setString(3, configuracionUsuario.getTema());
            statement.setString(4, configuracionUsuario.getIdioma());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear configuración de usuario: " + e.getMessage());
        }
    }

    public Optional<ConfiguracionUsuario> read(int configuracionId) {
        String sql = "SELECT * FROM Configuraciones_Usuario WHERE configuracion_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, configuracionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ConfiguracionUsuario configuracionUsuario = new ConfiguracionUsuario();
                configuracionUsuario.setConfiguracionId(resultSet.getInt("configuracion_id"));
                configuracionUsuario.setUsuarioId(resultSet.getInt("usuario_id"));
                configuracionUsuario.setNotificaciones(resultSet.getBoolean("notificaciones"));
                configuracionUsuario.setTema(resultSet.getString("tema"));
                configuracionUsuario.setIdioma(resultSet.getString("idioma"));
                return Optional.of(configuracionUsuario);
            }
        } catch (Exception e) {
            System.out.println("Error al leer configuración de usuario: " + e.getMessage());
        }
        return Optional.empty();
    }

    public void update(ConfiguracionUsuario configuracionUsuario, int id) {
        String sql = "UPDATE Configuraciones_Usuario SET usuario_id = ?, notificaciones = ?, tema = ?, idioma = ? WHERE configuracion_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, configuracionUsuario.getUsuarioId());
            statement.setBoolean(2, configuracionUsuario.isNotificaciones());
            statement.setString(3, configuracionUsuario.getTema());
            statement.setString(4, configuracionUsuario.getIdioma());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar configuración de usuario: " + e.getMessage());
        }
    }

    public void delete(int configuracionId) {
        String sql = "DELETE FROM Configuraciones_Usuario WHERE configuracion_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, configuracionId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar configuración de usuario: " + e.getMessage());
        }
    }
}
