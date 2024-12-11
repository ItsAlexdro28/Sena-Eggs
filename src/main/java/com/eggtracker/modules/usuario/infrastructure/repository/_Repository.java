package com.eggtracker.modules.usuario.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Properties;

import com.eggtracker.modules.usuario.domain.entity.Usuario;
import com.eggtracker.modules.usuario.domain.service.UsuarioService;

public class UsuarioRepository implements UsuarioService {
	private Connection connection;

	public UsuarioRepository() {
		try {
			Properties props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createUsuario(Usuario usuario) {
		try {
			String query = "INSERT INTO usuario (nombre, email, password) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Usuario> readUsuario(int id) {
		String query = "SELECT id, nombre, email, password FROM usuario WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Usuario usuario = new Usuario(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("email"),
						rs.getString("password")
					);
					return Optional.of(usuario);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public void updateUsuario(Usuario usuario, int id) {
		String query = "UPDATE usuario SET nombre = ?, email = ?, password = ? WHERE id = ?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPassword());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUsuario(int id) {
		String query = "DELETE FROM usuario WHERE id = ?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
