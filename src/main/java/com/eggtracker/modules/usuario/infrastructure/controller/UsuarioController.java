package com.eggtracker.modules.usuario.infrastructure.controller;

import java.text.MessageFormat;
import java.util.Optional;

import com.eggtracker.modules.usuario.aplication.CreateUsuarioUC;
import com.eggtracker.modules.usuario.aplication.DeleteUsuarioUC;
import com.eggtracker.modules.usuario.aplication.ReadUsuarioUC;
import com.eggtracker.modules.usuario.aplication.UpdateUsuarioUC;
import com.eggtracker.modules.usuario.domain.entity.Usuario;
import com.eggtracker.console.Util;

public class UsuarioController {
    private CreateUsuarioUC createUsuarioUC;
    private ReadUsuarioUC readUsuarioUC;
    private UpdateUsuarioUC updateUsuarioUC;
    private DeleteUsuarioUC deleteUsuarioUC;

    Object[] options = {"Crear usuario", 
                        "Leer usuario", 
                        "Actualizar usuario", 
                        "Eliminar usuario"};
    int choice = -1;

    public UsuarioController(CreateUsuarioUC createUsuarioUC, ReadUsuarioUC readUsuarioUC, UpdateUsuarioUC updateUsuarioUC, DeleteUsuarioUC deleteUsuarioUC) {
        this.createUsuarioUC = createUsuarioUC;
        this.readUsuarioUC = readUsuarioUC;
        this.updateUsuarioUC = updateUsuarioUC;
        this.deleteUsuarioUC = deleteUsuarioUC;
    }

    public void run() {
        while (choice != 0) {
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.println("0. Salir");

            choice = Util.getIntInput("Ingresa una opcion: ");

            switch (choice) {
                case 1:
                    try {
                        Util.clearConsole();
                        String name = Util.getStringInput("Ingresa el nombre del usuario: ");
                        String email = Util.getStringInput("Ingresa el email del usuario: ");
                        String password = Util.getStringInput("Ingresa la contraseña del usuario: ");
                        Usuario usuario = new Usuario();
                        usuario.setNombre(name);
                        usuario.setEmail(email);
                        usuario.setPassword(password);

                        createUsuarioUC.execute(usuario);

                        System.out.println("Usuario creado satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error creando el usuario: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID del usuario: ");
                        readUsuarioUC.execute(id).ifPresentOrElse(
                            usuarioFound -> {
                                System.out.println("\nInformación del usuario:");
                                System.out.println(MessageFormat.format("ID: {0}", usuarioFound.getId()));
                                System.out.println(MessageFormat.format("Nombre: {0}", usuarioFound.getNombre()));
                                System.out.println(MessageFormat.format("Email: {0}", usuarioFound.getEmail()));
                            },
                            () -> {
                                System.out.println("Usuario no encontrado!");
                            }
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error leyendo el usuario: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID del usuario: ");
                        Optional<Usuario> usuarioToUpdate = readUsuarioUC.execute(id);
                        usuarioToUpdate.ifPresentOrElse(
                            usuario -> {
                                boolean continueUpdating = true;
                                while (continueUpdating) {
                                    System.out.println("\n1. Nombre del usuario");
                                    System.out.println("2. Email del usuario");
                                    System.out.println("3. Contraseña del usuario");
                                    System.out.println("0. Salir");

                                    int choice = Util.getIntInput("Elige tu opción: ");
                                    switch (choice) {
                                        case 1:
                                            String newName = Util.getStringInput("\nElige un nuevo nombre: ");
                                            usuario.setNombre(newName);
                                            break;
                                        case 2:
                                            String newEmail = Util.getStringInput("\nElige un nuevo email: ");
                                            usuario.setEmail(newEmail);
                                            break;
                                        case 3:
                                            String newPassword = Util.getStringInput("\nElige una nueva contraseña: ");
                                            usuario.setPassword(newPassword);
                                            break;
                                        case 0:
                                            continueUpdating = false;
                                            break;
                                        default:
                                            System.out.println("Opción inválida");
                                            continue;
                                    }
                                    if (choice != 0) {
                                        updateUsuarioUC.execute(usuario, id);
                                        System.out.println("Usuario actualizado satisfactoriamente!");
                                    }
                                }
                            },
                            () -> System.out.println("Usuario no encontrado!")
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error actualizando el usuario: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Elige un ID del usuario para eliminar: ");
                        deleteUsuarioUC.execute(id);
                        System.out.println("Usuario eliminado satisfactoriamente!");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error eliminando el usuario: " + e.getMessage());
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida, elige otra opción.");
            }

            System.out.println();
        }
    }
}
