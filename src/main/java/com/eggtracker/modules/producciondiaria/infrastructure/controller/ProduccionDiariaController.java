package com.eggtracker.modules.producciondiaria.infrastructure.controller;

import com.eggtracker.modules.producciondiaria.aplication.CreateProduccionDiariaUC;
import com.eggtracker.modules.producciondiaria.aplication.DeleteProduccionDiariaUC;
import com.eggtracker.modules.producciondiaria.aplication.ReadProduccionDiariaUC;
import com.eggtracker.modules.producciondiaria.aplication.UpdateProduccionDiariaUC;
import com.eggtracker.modules.producciondiaria.domain.entity.ProduccionDiaria;
import com.eggtracker.console.Util;

import java.sql.Date;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class ProduccionDiariaController {
    private CreateProduccionDiariaUC createProduccionDiariaUC;
    private ReadProduccionDiariaUC readProduccionDiariaUC;
    private UpdateProduccionDiariaUC updateProduccionDiariaUC;
    private DeleteProduccionDiariaUC deleteProduccionDiariaUC;

    Object[] options = {"Crear producción diaria", "Leer producción diaria", "Actualizar producción diaria", "Eliminar producción diaria"};
    int choice = -1;

    public ProduccionDiariaController(CreateProduccionDiariaUC createProduccionDiariaUC, ReadProduccionDiariaUC readProduccionDiariaUC, 
                                      UpdateProduccionDiariaUC updateProduccionDiariaUC, DeleteProduccionDiariaUC deleteProduccionDiariaUC) {
        this.createProduccionDiariaUC = createProduccionDiariaUC;
        this.readProduccionDiariaUC = readProduccionDiariaUC;
        this.updateProduccionDiariaUC = updateProduccionDiariaUC;
        this.deleteProduccionDiariaUC = deleteProduccionDiariaUC;
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
                        int gallinaId = Util.getIntInput("Ingresa el ID de la gallina: ");
                        java.sql.Date fecha = Date.valueOf(Util.getStringInput("Ingresa la fecha de la producción (YYYY-MM-DD): "));
                        int cantidad = Util.getIntInput("Ingresa la cantidad de producción: ");
                        ProduccionDiaria produccionDiaria = new ProduccionDiaria(0, gallinaId, fecha, cantidad);

                        createProduccionDiariaUC.execute(produccionDiaria);

                        System.out.println("Producción diaria creada satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error creando la producción diaria: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Util.clearConsole();
                        int gallinaId = Util.getIntInput("Ingresa el ID de la gallina: ");
                        java.sql.Date fecha = Date.valueOf(Util.getStringInput("Ingresa la fecha de la producción (YYYY-MM-DD): "));
                        readProduccionDiariaUC.execute(gallinaId, fecha).ifPresentOrElse(
                            produccion -> {
                                System.out.println("\nInformación de la producción diaria:");
                                System.out.println(MessageFormat.format("ID: {0}", produccion.getProduccionId()));
                                System.out.println(MessageFormat.format("Gallina ID: {0}", produccion.getGallinaId()));
                                System.out.println(MessageFormat.format("Fecha: {0}", produccion.getFecha()));
                                System.out.println(MessageFormat.format("Cantidad: {0}", produccion.getCantidad()));
                            },
                            () -> {
                                System.out.println("Producción diaria no encontrada!");
                            }
                        );
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error leyendo la producción diaria: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Util.clearConsole();
                        int gallinaId = Util.getIntInput("Ingresa el ID de la gallina: ");
                        java.sql.Date fecha = Date.valueOf(Util.getStringInput("Ingresa la fecha de la producción (YYYY-MM-DD): "));
                        int cantidad = Util.getIntInput("Ingresa la cantidad de producción: ");
                        ProduccionDiaria produccionDiaria = new ProduccionDiaria(0, gallinaId, fecha, cantidad);

                        updateProduccionDiariaUC.execute(produccionDiaria, gallinaId);

                        System.out.println("Producción diaria actualizada satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error actualizando la producción diaria: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Util.clearConsole();
                        int produccionId = Util.getIntInput("Ingresa el ID de la producción a eliminar: ");
                        deleteProduccionDiariaUC.execute(produccionId);

                        System.out.println("Producción diaria eliminada satisfactoriamente");
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error eliminando la producción diaria: " + e.getMessage());
                    }
                    break;
            }
        }
    }
}
