package br.ufsm.tcc2.pmmaster.service;

import br.ufsm.tcc2.pmmaster.model.Tabuleiro;
import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.repository.TabuleiroRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class TabuleiroReportService {

    @Autowired
    private TabuleiroService tabuleiroService;
    @Autowired
    private UsuarioService usuarioService;

    public void exportReport(Long idTabuleiro) throws FileNotFoundException, JRException {

        File file = ResourceUtils.getFile("classpath:tabuleiro.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Tabuleiro tabuleiro = tabuleiroService.find(idTabuleiro);
        List<Usuario> usuarios = usuarioService.findAll();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(usuarios);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idTabuleiro", "idTabuleiro");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource);

        JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
