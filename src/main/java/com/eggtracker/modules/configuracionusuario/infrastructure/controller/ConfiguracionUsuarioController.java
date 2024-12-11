package com.eggtracker.modules.configuracionusuario.infrastructure.controller;

import com.eggtracker.modules.configuracionusuario.aplication.CreateConfiguracionUsuarioUC;
import com.eggtracker.modules.configuracionusuario.aplication.DeleteConfiguracionUsuarioUC;
import com.eggtracker.modules.configuracionusuario.aplication.ReadConfiguracionUsuarioUC;
import com.eggtracker.modules.configuracionusuario.aplication.UpdateConfiguracionUsuarioUC;
import com.eggtracker.modules.configuracionusuario.domain.entity.ConfiguracionUsuario;
import com.eggtracker.console.Util;

public class ConfiguracionUsuarioController {
    private CreateConfiguracionUsuarioUC createConfiguracionUsuarioUC;
    private ReadConfiguracionUsuarioUC readConfiguracionUsuarioUC;
    private UpdateConfiguracionUsuarioUC updateConfiguracionUsuarioUC;
    private DeleteConfiguracionUsuarioUC deleteConfiguracionUsuarioUC;

    Object[] options = {"Crear configuración", 
                        "Leer configuración", 
                        "Actualizar configuración", 
                        "Eliminar configuración"};
    int choice = -1;

    public ConfiguracionUsuarioController(CreateConfiguracionUsuarioUC createConfiguracionUsuarioUC, 
                                           ReadConfiguracionUsuarioUC readConfiguracionUsuarioUC, 
                                           UpdateConfiguracionUsuarioUC updateConfiguracionUsuarioUC, 
                                           DeleteConfiguracionUsuarioUC deleteConfiguracionUsuarioUC) {
        this.createConfiguracionUsuarioUC = createConfiguracionUsuarioUC;
        this.readConfiguracionUsuarioUC = readConfiguracionUsuarioUC;
        this.updateConfiguracionUsuarioUC = updateConfiguracionUsuarioUC;
        this.deleteConfiguracionUsuarioUC = deleteConfiguracionUsuarioUC;
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
                        int usuarioId = Util.getIntInput("Ingresa el ID del usuario: ");
                        boolean notificaciones = Util.getBooleanInput("¿Activar notificaciones? (true/false): ");
                        String tema = Util.getStringInput("Elige un tema: ");
                        String idioma = Util.getStringInput("Elige un idioma: ");

                        ConfiguracionUsuario configuracionUsuario = new ConfiguracionUsuario();
                        configuracionUsuario.setUsuarioId(usuarioId);
                        configuracionUsuario.setNotificaciones(notificaciones);
                        configuracionUsuario.setTema(tema);
                        configuracionUsuario.setIdioma(idioma);

                        createConfiguracionUsuarioUC.execute(configuracionUsuario);
                        System.out.println("Configuración creada satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error creando la configuración: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Util.clearConsole();
                        int configuracionId = Util.getIntInput("Ingresa el ID de la configuración: ");
                        readConfiguracionUsuarioUC.execute(configuracionId).ifPresentOrElse(
                            configuracionFound -> {
                                System.out.println("Configuración del usuario:");
                                System.out.println("ID: " + configuracionFound.getConfiguracionId());
                                System.out.println("Notificaciones: " + configuracionFound.isNotificaciones());
                                System.out.println("Tema: " + configuracionFound.getTema());
                                System.out.println("Idioma: " + configuracionFound.getIdioma());
                            },
                            () -> System.out.println("Configuración no encontrada!")
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error leyendo la configuración: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Util.clearConsole();
                        int configuracionId = Util.getIntInput("Ingresa el ID de la configuración: ");
                        readConfiguracionUsuarioUC.execute(configuracionId).ifPresentOrElse(
                            configuracion -> {
                                boolean continueUpdating = true;
                                while (continueUpdating) {
                                    System.out.println("\n1. Notificaciones");
                                    System.out.println("2. Tema");
                                    System.out.println("3. Idioma");
                                    System.out.println("0. Salir");

                                    int choice = Util.getIntInput("Elige tu opción: ");
                                    switch (choice) {
                                        case 1:
                                            boolean newNotificaciones = Util.getBooleanInput("¿Activar notificaciones? (true/false): ");
                                            configuracion.setNotificaciones(newNotificaciones);
                                            break;
                                        case 2:
                                            String newTema = Util.getStringInput("Elige un nuevo tema: ");
                                            configuracion.setTema(newTema);
                                            break;
                                        case 3:
                                            String newIdioma = Util.getStringInput("Elige un nuevo idioma: ");
                                            configuracion.setIdioma(newIdioma);
                                            break;
                                        case 0:
                                            continueUpdating = false;
                                            break;
                                        default:
                                            System.out.println("Opción no válida.");
                                    }
                                }
                                updateConfiguracionUsuarioUC.execute(configuracion, configuracionId);
                                System.out.println("Configuración actualizada.");
                            },
                            () -> System.out.println("Configuración no encontrada.")
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error actualizando la configuración: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Util.clearConsole();
                        int configuracionId = Util.getIntInput("Ingresa el ID de la configuración: ");
                        deleteConfiguracionUsuarioUC.execute(configuracionId);
                        System.out.println("Configuración eliminada satisfactoriamente.");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error eliminando la configuración: " + e.getMessage());
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
