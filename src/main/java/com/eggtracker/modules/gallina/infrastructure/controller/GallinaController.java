package com.eggtracker.modules.gallina.infrastructure.controller;

import java.text.MessageFormat;
import java.util.Optional;

import com.eggtracker.modules.gallina.aplication.CreateGallinaUC;
import com.eggtracker.modules.gallina.aplication.DeleteGallinaUC;
import com.eggtracker.modules.gallina.aplication.ReadGallinaUC;
import com.eggtracker.modules.gallina.aplication.UpdateGallinaUC;
import com.eggtracker.modules.gallina.domain.entity.Gallina;
import com.eggtracker.console.Util;

public class GallinaController {
    private CreateGallinaUC createGallinaUC;
    private ReadGallinaUC readGallinaUC;
    private UpdateGallinaUC updateGallinaUC;
    private DeleteGallinaUC deleteGallinaUC;

    Object[] options = {"Crear gallina", 
                        "Leer gallina", 
                        "Actualizar gallina", 
                        "Eliminar gallina"};
    int choice = -1;

    public GallinaController(CreateGallinaUC createGallinaUC, ReadGallinaUC readGallinaUC, UpdateGallinaUC updateGallinaUC, DeleteGallinaUC deleteGallinaUC) {
        this.createGallinaUC = createGallinaUC;
        this.readGallinaUC = readGallinaUC;
        this.updateGallinaUC = updateGallinaUC;
        this.deleteGallinaUC = deleteGallinaUC;
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
                        String nombre = Util.getStringInput("Ingresa el nombre de la gallina: ");
                        String fechaNacimiento = Util.getStringInput("Ingresa la fecha de nacimiento (YYYY-MM-DD): ");
                        int grupoId = Util.getIntInput("Ingresa el ID del grupo: ");
                        Gallina gallina = new Gallina();
                        gallina.setNombre(nombre);
                        gallina.setFechaNacimiento(fechaNacimiento);
                        gallina.setGrupoId(grupoId);

                        createGallinaUC.execute(gallina);

                        System.out.println("Gallina creada satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error creando la gallina: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID de la gallina: ");
                        readGallinaUC.execute(id).ifPresentOrElse(
                            gallinaFound -> {
                                System.out.println("\nInformación de la gallina:");
                                System.out.println(MessageFormat.format("ID: {0}", gallinaFound.getGallinaId()));
                                System.out.println(MessageFormat.format("Nombre: {0}", gallinaFound.getNombre()));
                                System.out.println(MessageFormat.format("Fecha de nacimiento: {0}", gallinaFound.getFechaNacimiento()));
                                System.out.println(MessageFormat.format("Grupo ID: {0}", gallinaFound.getGrupoId()));
                                System.out.println(MessageFormat.format("Estado: {0}", gallinaFound.getEstado()));
                            },
                            () -> {
                                System.out.println("Gallina no encontrada!");
                            }
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error leyendo la gallina: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID de la gallina: ");
                        Optional<Gallina> gallinaToUpdate = readGallinaUC.execute(id);
                        gallinaToUpdate.ifPresentOrElse(
                            gallina -> {
                                boolean continueUpdating = true;
                                while (continueUpdating) {
                                    System.out.println("\n1. Nombre de la gallina");
                                    System.out.println("2. Fecha de nacimiento");
                                    System.out.println("3. Estado de la gallina");
                                    System.out.println("0. Salir");

                                    int choice = Util.getIntInput("Elige tu opción: ");
                                    switch (choice) {
                                        case 1:
                                            String newNombre = Util.getStringInput("\nElige un nuevo nombre: ");
                                            gallina.setNombre(newNombre);
                                            break;
                                        case 2:
                                            String newFechaNacimiento = Util.getStringInput("\nElige una nueva fecha de nacimiento (YYYY-MM-DD): ");
                                            gallina.setFechaNacimiento(newFechaNacimiento);
                                            break;
                                        case 3:
                                            String newEstado = Util.getStringInput("\nElige el nuevo estado (activo/inactivo): ");
                                            gallina.setEstado(newEstado);
                                            break;
                                        case 0:
                                            continueUpdating = false;
                                            break;
                                        default:
                                            System.out.println("Opción inválida");
                                            continue;
                                    }
                                    updateGallinaUC.execute(gallina, id);
                                }
                            },
                            () -> System.out.println("Gallina no encontrada!")
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error actualizando la gallina: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID de la gallina: ");
                        deleteGallinaUC.execute(id);
                        System.out.println("Gallina eliminada con éxito");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error eliminando la gallina: " + e.getMessage());
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
