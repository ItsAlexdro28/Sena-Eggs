package com.eggtracker;

import com.eggtracker.console.*;

import com.eggtracker.modules.analisisalerta.aplication.CreateAnalisisAlertaUC;
import com.eggtracker.modules.analisisalerta.aplication.ReadAnalisisAlertaUC;
import com.eggtracker.modules.analisisalerta.aplication.UpdateAnalisisAlertaUC;
import com.eggtracker.modules.analisisalerta.aplication.DeleteAnalisisAlertaUC;
import com.eggtracker.modules.analisisalerta.domain.service.AnalisisAlertaService;
import com.eggtracker.modules.analisisalerta.infrastructure.repository.AnalisisAlertaRepository;

import com.eggtracker.modules.configuracionusuario.aplication.CreateConfiguracionUsuarioUC;
import com.eggtracker.modules.configuracionusuario.aplication.ReadConfiguracionUsuarioUC;
import com.eggtracker.modules.configuracionusuario.aplication.UpdateConfiguracionUsuarioUC;
import com.eggtracker.modules.configuracionusuario.aplication.DeleteConfiguracionUsuarioUC;
import com.eggtracker.modules.configuracionusuario.domain.service.ConfiguracionUsuarioService;
import com.eggtracker.modules.configuracionusuario.infrastructure.repository.ConfiguracionUsuarioRepository;

import com.eggtracker.modules.gallina.aplication.CreateGallinaUC;
import com.eggtracker.modules.gallina.aplication.ReadGallinaUC;
import com.eggtracker.modules.gallina.aplication.UpdateGallinaUC;
import com.eggtracker.modules.gallina.aplication.DeleteGallinaUC;
import com.eggtracker.modules.gallina.domain.service.GallinaService;
import com.eggtracker.modules.gallina.infrastructure.repository.GallinaRepository;

import com.eggtracker.modules.grupo.aplication.CreateGrupoUC;
import com.eggtracker.modules.grupo.aplication.ReadGrupoUC;
import com.eggtracker.modules.grupo.aplication.UpdateGrupoUC;
import com.eggtracker.modules.grupo.aplication.DeleteGrupoUC;
import com.eggtracker.modules.grupo.domain.service.GrupoService;
import com.eggtracker.modules.grupo.infrastructure.repository.GrupoRepository;

import com.eggtracker.modules.producciondiaria.aplication.CreateProduccionDiariaUC;
import com.eggtracker.modules.producciondiaria.aplication.ReadProduccionDiariaUC;
import com.eggtracker.modules.producciondiaria.aplication.UpdateProduccionDiariaUC;
import com.eggtracker.modules.producciondiaria.aplication.DeleteProduccionDiariaUC;
import com.eggtracker.modules.producciondiaria.domain.service.ProduccionDiariaService;
import com.eggtracker.modules.producciondiaria.infrastructure.repository.ProduccionDiariaRepository;

import com.eggtracker.modules.reportesproduccion.aplication.CreateReporteProduccionUC;
import com.eggtracker.modules.reportesproduccion.aplication.ReadReporteProduccionUC;
import com.eggtracker.modules.reportesproduccion.aplication.UpdateReporteProduccionUC;
import com.eggtracker.modules.reportesproduccion.aplication.DeleteReporteProduccionUC;
import com.eggtracker.modules.reportesproduccion.domain.service.ReporteProduccionService;
import com.eggtracker.modules.reportesproduccion.infrastructure.repository.ReporteProduccionRepository;

import com.eggtracker.modules.usuario.aplication.CreateUsuarioUC;
import com.eggtracker.modules.usuario.aplication.ReadUsuarioUC;
import com.eggtracker.modules.usuario.aplication.UpdateUsuarioUC;
import com.eggtracker.modules.usuario.aplication.DeleteUsuarioUC;
import com.eggtracker.modules.usuario.domain.service.UsuarioService;
import com.eggtracker.modules.usuario.infrastructure.repository.UsuarioRepository;

public class Main {
    public static void main(String[] args) {

        AnalisisAlertaService analisisAlertaService = new AnalisisAlertaRepository();
        ConfiguracionUsuarioService configuracionUsuarioService = new ConfiguracionUsuarioRepository();
        GallinaService gallinaService = new GallinaRepository();
        GrupoService grupoService = new GrupoRepository();
        ProduccionDiariaService produccionDiariaService = new ProduccionDiariaRepository();
        ReporteProduccionService reporteProduccionService = new ReporteProduccionRepository();
        UsuarioService usuarioService = new UsuarioRepository();

        CreateAnalisisAlertaUC createAnalisisAlertaUC = new CreateAnalisisAlertaUC(analisisAlertaService);
        ReadAnalisisAlertaUC readAnalisisAlertaUC = new ReadAnalisisAlertaUC(analisisAlertaService);
        UpdateAnalisisAlertaUC updateAnalisisAlertaUC = new UpdateAnalisisAlertaUC(analisisAlertaService);
        DeleteAnalisisAlertaUC deleteAnalisisAlertaUC = new DeleteAnalisisAlertaUC(analisisAlertaService);

        CreateConfiguracionUsuarioUC createConfiguracionUsuarioUC = new CreateConfiguracionUsuarioUC(configuracionUsuarioService);
        ReadConfiguracionUsuarioUC readConfiguracionUsuarioUC = new ReadConfiguracionUsuarioUC(configuracionUsuarioService);
        UpdateConfiguracionUsuarioUC updateConfiguracionUsuarioUC = new UpdateConfiguracionUsuarioUC(configuracionUsuarioService);
        DeleteConfiguracionUsuarioUC deleteConfiguracionUsuarioUC = new DeleteConfiguracionUsuarioUC(configuracionUsuarioService);

        CreateGallinaUC createGallinaUC = new CreateGallinaUC(gallinaService);
        ReadGallinaUC readGallinaUC = new ReadGallinaUC(gallinaService);
        UpdateGallinaUC updateGallinaUC = new UpdateGallinaUC(gallinaService);
        DeleteGallinaUC deleteGallinaUC = new DeleteGallinaUC(gallinaService);

        CreateGrupoUC createGrupoUC = new CreateGrupoUC(grupoService);
        ReadGrupoUC readGrupoUC = new ReadGrupoUC(grupoService);
        UpdateGrupoUC updateGrupoUC = new UpdateGrupoUC(grupoService);
        DeleteGrupoUC deleteGrupoUC = new DeleteGrupoUC(grupoService);

        CreateProduccionDiariaUC createProduccionDiariaUC = new CreateProduccionDiariaUC(produccionDiariaService);
        ReadProduccionDiariaUC readProduccionDiariaUC = new ReadProduccionDiariaUC(produccionDiariaService);
        UpdateProduccionDiariaUC updateProduccionDiariaUC = new UpdateProduccionDiariaUC(produccionDiariaService);
        DeleteProduccionDiariaUC deleteProduccionDiariaUC = new DeleteProduccionDiariaUC(produccionDiariaService);

        CreateReporteProduccionUC createReporteProduccionUC = new CreateReporteProduccionUC(reporteProduccionService);
        ReadReporteProduccionUC readReporteProduccionUC = new ReadReporteProduccionUC(reporteProduccionService);
        UpdateReporteProduccionUC updateReporteProduccionUC = new UpdateReporteProduccionUC(reporteProduccionService);
        DeleteReporteProduccionUC deleteReporteProduccionUC = new DeleteReporteProduccionUC(reporteProduccionService);

        CreateUsuarioUC createUsuarioUC = new CreateUsuarioUC(usuarioService);
        ReadUsuarioUC readUsuarioUC = new ReadUsuarioUC(usuarioService);
        UpdateUsuarioUC updateUsuarioUC = new UpdateUsuarioUC(usuarioService);
        DeleteUsuarioUC deleteUsuarioUC = new DeleteUsuarioUC(usuarioService);

        // Instanciar los controladores
        AnalisisAlertaController analisisAlertaController = new AnalisisAlertaController(createAnalisisAlertaUC, readAnalisisAlertaUC, updateAnalisisAlertaUC, deleteAnalisisAlertaUC);
        ConfiguracionUsuarioController configuracionUsuarioController = new ConfiguracionUsuarioController(createConfiguracionUsuarioUC, readConfiguracionUsuarioUC, updateConfiguracionUsuarioUC, deleteConfiguracionUsuarioUC);
        GallinaController gallinaController = new GallinaController(createGallinaUC, readGallinaUC, updateGallinaUC, deleteGallinaUC);
        GrupoController grupoController = new GrupoController(createGrupoUC, readGrupoUC, updateGrupoUC, deleteGrupoUC);
        ProduccionDiariaController produccionDiariaController = new ProduccionDiariaController(createProduccionDiariaUC, readProduccionDiariaUC, updateProduccionDiariaUC, deleteProduccionDiariaUC);
        ReporteProduccionController reporteProduccionController = new ReporteProduccionController(createReporteProduccionUC, readReporteProduccionUC, updateReporteProduccionUC, deleteReporteProduccionUC);
        UsuarioController usuarioController = new UsuarioController(createUsuarioUC, readUsuarioUC, updateUsuarioUC, deleteUsuarioUC);

		while (true) {
        Util.clearConsole();
        String header = """
                ░█▀▀█ ░█▀▀█ ░█─░█ ░█▀▀▄
                ░█─── ░█▄▄▀ ░█─░█ ░█─░█
                ░█▄▄█ ░█─░█ ─▀▄▄▀ ░█▄▄▀

                -----------------------------------
                 Crear, Leer, Modificar y Eliminar
                -----------------------------------
                """;
        String[] mainOptions = {
                "- ( 1 ) Analisis Alerta",   
                "- ( 2 ) Configuracion Usuario", 
                "- ( 3 ) Gallina",   
                "- ( 4 ) Grupo",   
                "- ( 5 ) Producción Diaria",   
                "- ( 6 ) Reportes Producción", 
                "- ( 7 ) Usuario",   
                "- ( 0 ) Salir"
        };

        System.out.println(header);
        for (String option : mainOptions) {
            System.out.println(option);
        }
        int selectedOption = Util.getIntInput(">> ¿Qué tabla deseas editar?");
        switch (selectedOption) {
            case 1:
                analisisAlertaController.run();
                break;
            case 2:
                configuracionUsuarioController.run();
                break;
            case 3:
                gallinaController.run();
                break;
            case 4:
                grupoController.run();
                break;
            case 5:
                produccionDiariaController.run();
                break;
            case 6:
                reportesProduccionController.run();
                break;
            case 7:
                usuarioController.run();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                break;
        }
    }
    }
}
