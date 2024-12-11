package com.eggtracker.modules.grupo.infrastructure.controller;

import java.text.MessageFormat;
import java.util.Optional;

import com.eggtracker.modules.grupo.aplication.CreateGrupoUC;
import com.eggtracker.modules.grupo.aplication.DeleteGrupoUC;
import com.eggtracker.modules.grupo.aplication.ReadGrupoUC;
import com.eggtracker.modules.grupo.aplication.UpdateGrupoUC;
import com.eggtracker.modules.grupo.domain.entity.Grupo;
import com.eggtracker.console.Util;

public class GrupoController {
    private CreateGrupoUC createGrupoUC;
    private ReadGrupoUC readGrupoUC;
    private UpdateGrupoUC updateGrupoUC;
    private DeleteGrupoUC deleteGrupoUC;

    Object[] options = {"Crear grupo", 
                        "Leer grupo", 
                        "Actualizar grupo", 
                        "Eliminar grupo"};
    int choice = -1;

    public GrupoController(CreateGrupoUC createGrupoUC, ReadGrupoUC readGrupoUC, UpdateGrupoUC updateGrupoUC, DeleteGrupoUC deleteGrupoUC) {
        this.createGrupoUC = createGrupoUC;
        this.readGrupoUC = readGrupoUC;
        this.updateGrupoUC = updateGrupoUC;
        this.deleteGrupoUC = deleteGrupoUC;
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
                        String nombre = Util.getStringInput("Ingresa el nombre del grupo: ");
                        String descripcion = Util.getStringInput("Ingresa la descripcion del grupo: ");
                        Grupo grupo = new Grupo();
                        grupo.setNombre(nombre);
                        grupo.setDescripcion(descripcion);

                        createGrupoUC.execute(grupo);

                        System.out.println("Grupo creado satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error creando el grupo: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID del grupo: ");
                        readGrupoUC.execute(id).ifPresentOrElse(
                            grupoFound -> {
                                System.out.println("\nInformación del grupo:");
                                System.out.println(MessageFormat.format("ID: {0}", grupoFound.getGrupoId()));
                                System.out.println(MessageFormat.format("Nombre: {0}", grupoFound.getNombre()));
                                System.out.println(MessageFormat.format("Descripción: {0}", grupoFound.getDescripcion()));
                                System.out.println(MessageFormat.format("Fecha de creación: {0}", grupoFound.getFechaCreacion()));
                            },
                            () -> {
                                System.out.println("Grupo no encontrado!");
                            }
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error leyendo el grupo: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID del grupo: ");
                        Optional<Grupo> grupoToUpdate = readGrupoUC.execute(id);
                        grupoToUpdate.ifPresentOrElse(
                            grupo -> {
                                boolean continueUpdating = true;
                                while (continueUpdating) {
                                    System.out.println("\n1. Nombre del grupo");
                                    System.out.println("2. Descripción del grupo");
                                    System.out.println("0. Salir");

                                    int choice = Util.getIntInput("Elige tu opción: ");
                                    switch (choice) {
                                        case 1:
                                            String newNombre = Util.getStringInput("\nElige un nuevo nombre: ");
                                            grupo.setNombre(newNombre);
                                            break;
                                        case 2:
                                            String newDescripcion = Util.getStringInput("\nElige una nueva descripción: ");
                                            grupo.setDescripcion(newDescripcion);
                                            break;
                                        case 0:
                                            continueUpdating = false;
                                            break;
                                        default:
                                            System.out.println("Opción inválida");
                                            continue;
                                    }
                                    if (choice != 0) {
                                        updateGrupoUC.execute(grupo, id);
                                        System.out.println("Grupo actualizado satisfactoriamente!");
                                    }
                                }
                            },
                            () -> System.out.println("Grupo no encontrado!")
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error actualizando el grupo: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Elige un ID del grupo para eliminar: ");
                        deleteGrupoUC.execute(id);
                        System.out.println("Grupo eliminado satisfactoriamente!");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error eliminando el grupo: " + e.getMessage());
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
