package com.eggtracker.modules.analisisalerta.infrastructure.controller;

import java.text.MessageFormat;
import java.util.Optional;

import com.eggtracker.modules.analisisalerta.aplication.CreateAnalisisAlertaUC;
import com.eggtracker.modules.analisisalerta.aplication.DeleteAnalisisAlertaUC;
import com.eggtracker.modules.analisisalerta.aplication.ReadAnalisisAlertaUC;
import com.eggtracker.modules.analisisalerta.aplication.UpdateAnalisisAlertaUC;
import com.eggtracker.modules.analisisalerta.domain.entity.AnalisisAlerta;
import com.eggtracker.console.Util;

public class AnalisisAlertaController {
    private CreateAnalisisAlertaUC createAnalisisAlertaUC;
    private ReadAnalisisAlertaUC readAnalisisAlertaUC;
    private UpdateAnalisisAlertaUC updateAnalisisAlertaUC;
    private DeleteAnalisisAlertaUC deleteAnalisisAlertaUC;

    Object[] options = {"Crear análisis alerta", 
                        "Leer análisis alerta", 
                        "Actualizar análisis alerta", 
                        "Eliminar análisis alerta"};
    int choice = -1;

    public AnalisisAlertaController(CreateAnalisisAlertaUC createAnalisisAlertaUC, ReadAnalisisAlertaUC readAnalisisAlertaUC, UpdateAnalisisAlertaUC updateAnalisisAlertaUC, DeleteAnalisisAlertaUC deleteAnalisisAlertaUC) {
        this.createAnalisisAlertaUC = createAnalisisAlertaUC;
        this.readAnalisisAlertaUC = readAnalisisAlertaUC;
        this.updateAnalisisAlertaUC = updateAnalisisAlertaUC;
        this.deleteAnalisisAlertaUC = deleteAnalisisAlertaUC;
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
                        String tipoAnalisis = Util.getStringInput("Ingresa el tipo de análisis (rendimiento, tendencias, alerta): ");
                        String descripcion = Util.getStringInput("Ingresa la descripción: ");
                        
                        AnalisisAlerta analisisAlerta = new AnalisisAlerta();
                        analisisAlerta.setUsuarioId(usuarioId);
                        analisisAlerta.setTipoAnalisis(tipoAnalisis);
                        analisisAlerta.setDescripcion(descripcion);

                        createAnalisisAlertaUC.execute(analisisAlerta);

                        System.out.println("Análisis alerta creado satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error creando el análisis alerta: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID del análisis alerta: ");
                        readAnalisisAlertaUC.execute(id).ifPresentOrElse(
                            analisis -> {
                                System.out.println("\nInformación del análisis alerta:");
                                System.out.println(MessageFormat.format("ID: {0}", analisis.getAnalisisId()));
                                System.out.println(MessageFormat.format("Usuario ID: {0}", analisis.getUsuarioId()));
                                System.out.println(MessageFormat.format("Fecha: {0}", analisis.getFecha()));
                                System.out.println(MessageFormat.format("Tipo de análisis: {0}", analisis.getTipoAnalisis()));
                                System.out.println(MessageFormat.format("Descripción: {0}", analisis.getDescripcion()));
                            },
                            () -> {
                                System.out.println("Análisis alerta no encontrado!");
                            }
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error leyendo el análisis alerta: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID del análisis alerta: ");
                        Optional<AnalisisAlerta> analisisAlertaToUpdate = readAnalisisAlertaUC.execute(id);
                        analisisAlertaToUpdate.ifPresent(analisis -> {
                            String tipoAnalisis = Util.getStringInput("Nuevo tipo de análisis: ");
                            String descripcion = Util.getStringInput("Nueva descripción: ");
                            analisis.setTipoAnalisis(tipoAnalisis);
                            analisis.setDescripcion(descripcion);
                            updateAnalisisAlertaUC.execute(analisis, id);
                            System.out.println("Análisis alerta actualizado satisfactoriamente.");
                        });
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error actualizando el análisis alerta: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Util.clearConsole();
                        int id = Util.getIntInput("Ingresa el ID del análisis alerta: ");
                        deleteAnalisisAlertaUC.execute(id);
                        System.out.println("Análisis alerta eliminado satisfactoriamente.");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error eliminando el análisis alerta: " + e.getMessage());
                    }
                    break;
            }
        }
    }
}
