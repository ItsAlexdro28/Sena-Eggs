package com.eggtracker.modules.reportesproduccion.infrastructure.controller;

import java.text.MessageFormat;
import java.util.Optional;

import com.eggtracker.modules.reportesproduccion.aplication.CreateReporteProduccionUC;
import com.eggtracker.modules.reportesproduccion.aplication.DeleteReporteProduccionUC;
import com.eggtracker.modules.reportesproduccion.aplication.ReadReporteProduccionUC;
import com.eggtracker.modules.reportesproduccion.aplication.UpdateReporteProduccionUC;
import com.eggtracker.modules.reportesproduccion.domain.entity.ReporteProduccion;
import com.eggtracker.console.Util;

public class ReporteProduccionController {
    private CreateReporteProduccionUC createReporteProduccionUC;
    private ReadReporteProduccionUC readReporteProduccionUC;
    private UpdateReporteProduccionUC updateReporteProduccionUC;
    private DeleteReporteProduccionUC deleteReporteProduccionUC;

    Object[] options = {
        "Crear reporte de producción",
        "Leer reporte de producción",
        "Actualizar reporte de producción",
        "Eliminar reporte de producción"
    };
    int choice = -1;

    public ReporteProduccionController(CreateReporteProduccionUC createReporteProduccionUC, ReadReporteProduccionUC readReporteProduccionUC, UpdateReporteProduccionUC updateReporteProduccionUC, DeleteReporteProduccionUC deleteReporteProduccionUC) {
        this.createReporteProduccionUC = createReporteProduccionUC;
        this.readReporteProduccionUC = readReporteProduccionUC;
        this.updateReporteProduccionUC = updateReporteProduccionUC;
        this.deleteReporteProduccionUC = deleteReporteProduccionUC;
    }

    public void run() {
        while (choice != 0) {
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.println("0. Salir");

            choice = Util.getIntInput("Ingresa una opción: ");

            switch (choice) {
                case 1:
                    try {
                        Util.clearConsole();
                        int produccionId = Util.getIntInput("Ingresa el ID de producción: ");
                        int analisisId = Util.getIntInput("Ingresa el ID de análisis: ");

                        ReporteProduccion reporte = new ReporteProduccion();
                        reporte.setProduccionId(produccionId);
                        reporte.setAnalisisId(analisisId);

                        createReporteProduccionUC.execute(reporte);

                        System.out.println("Reporte de producción creado satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error creando el reporte: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Util.clearConsole();
                        int reporteId = Util.getIntInput("Ingresa el ID del reporte: ");
                        readReporteProduccionUC.execute(reporteId).ifPresentOrElse(
                            reporteFound -> {
                                System.out.println("\nInformación del reporte:");
                                System.out.println(MessageFormat.format("ID Reporte: {0}", reporteFound.getReporteId()));
                                System.out.println(MessageFormat.format("ID Producción: {0}", reporteFound.getProduccionId()));
                                System.out.println(MessageFormat.format("ID Análisis: {0}", reporteFound.getAnalisisId()));
                            },
                            () -> {
                                System.out.println("Reporte no encontrado!");
                            }
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error leyendo el reporte: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Util.clearConsole();
                        int reporteId = Util.getIntInput("Ingresa el ID del reporte: ");
                        Optional<ReporteProduccion> reporteToUpdate = readReporteProduccionUC.execute(reporteId);
                        reporteToUpdate.ifPresentOrElse(
                            reporte -> {
                                boolean continueUpdating = true;
                                while (continueUpdating) {
                                    System.out.println("\n1. ID de producción");
                                    System.out.println("2. ID de análisis");
                                    System.out.println("0. Salir");

                                    int updateChoice = Util.getIntInput("Elige tu opción: ");
                                    switch (updateChoice) {
                                        case 1:
                                            int newProduccionId = Util.getIntInput("\nIngresa un nuevo ID de producción: ");
                                            reporte.setProduccionId(newProduccionId);
                                            break;
                                        case 2:
                                            int newAnalisisId = Util.getIntInput("\nIngresa un nuevo ID de análisis: ");
                                            reporte.setAnalisisId(newAnalisisId);
                                            break;
                                        case 0:
                                            continueUpdating = false;
                                            break;
                                        default:
                                            System.out.println("Opción inválida");
                                            continue;
                                    }
                                    if (updateChoice != 0) {
                                        updateReporteProduccionUC.execute(reporte, reporteId);
                                        System.out.println("Reporte actualizado satisfactoriamente!");
                                    }
                                }
                            },
                            () -> System.out.println("Reporte no encontrado!")
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error actualizando el reporte: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Util.clearConsole();
                        int reporteId = Util.getIntInput("Elige un ID del reporte para eliminar: ");
                        deleteReporteProduccionUC.execute(reporteId);
                        System.out.println("Reporte eliminado satisfactoriamente!");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error eliminando el reporte: " + e.getMessage());
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
