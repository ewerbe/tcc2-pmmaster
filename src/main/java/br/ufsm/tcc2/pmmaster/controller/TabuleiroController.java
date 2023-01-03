package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.Tabuleiro;
import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.service.TabuleiroService;
import br.ufsm.tcc2.pmmaster.service.UsuarioService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.repo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Controller
public class TabuleiroController {

    @Autowired
    private TabuleiroService tabuleiroService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/tabuleiros.action", method = RequestMethod.GET)
    public String getTabuleiros(Model model,
                                   @RequestParam(value = "idUsuario", required = false)Long idUsuario) {
        //Usuario usuario = usuarioService.find(idUsuario);
        List<Tabuleiro> tabuleiros;
        tabuleiros = tabuleiroService.findAll();

        model.addAttribute("tabuleiros", tabuleiros);
        model.addAttribute("idUsuario", 1L);

        return "tabuleiros";
    }

    @RequestMapping(value = "/tabuleiros/novo-tabuleiro.action", method = RequestMethod.POST)
    public void gera(Model model,
                                  HttpServletRequest request,
                                  HttpServletResponse response,
                                  @RequestParam(value = "idUsuario", required = false)Long idUsuario) throws Exception {

        //TODO: teste com ID_TABULEIRO fixo, para por o tabuleiro Jasper na webapp;
        //Long idTabuleiro = 1L;

        //Tabuleiro tabuleiroNovo = new Tabuleiro();
        //tabuleiroNovo.setId(idTabuleiro);
        //tabuleiroNovo.setIdUsuario(usuarioService.find(idUsuario));

        //consistir o novo tabuleiro no banco;
        //tabuleiroService.save(tabuleiroNovo);
        //criar o novo arquivo (jasper) do tabuleiro, passando o idUsuario pra gerar a URL destino do QRCODE;
//        Boolean tabuleiroGerado = geraArquivoTabuleiro(tabuleiroNovo.getIdUsuario().getId());
        //tabuleiroReportService.exportReport(tabuleiroNovo.getId());

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=tabuleiro.pdf");

        //geraArquivoTabuleiro(tabuleiroNovo.getId());
        response.getOutputStream().write(geraArquivoTabuleiro(6L));
    }

    ////////////////////////////

    private byte[] geraArquivoTabuleiro(Long idTabuleiro) throws FileNotFoundException, JRException {

        //Tabuleiro tabuleiro = tabuleiroService.find(idTabuleiro);
        //File file = ResourceUtils.getFile("classpath:tabuleiro.jrxml");
        File file = ResourceUtils.getFile("classpath:tabuleiro.jrxml");
        //File file = ResourceUtils.getFile("classpath:src/main/resources/tabuleiro.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(null);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ID_TABULEIRO", idTabuleiro);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }


//    private JasperPrint getJasperPrint(final String jrxmlName,
//                                       final Map<String, Object> params,
//                                       final Collection<?> beanCollection) throws Exception {
//        final File file = ResourceUtils.getFile("classpath:reports//" + jrxmlName);
//        final DefaultJasperReportsContext contexto = DefaultJasperReportsContext.getInstance();
//        final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(beanCollection);
//        final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        addDefaultParams(params);
//        return JasperFillManager.fillReport(jasperReport, params, dataSource);
//    }
//
//    private void addDefaultParams(final Map<String, Object> params) throws FileNotFoundException {
//        final File fileImg = ResourceUtils.getFile("classpath:static//assets//img//imagemxxx.png");
//        params.put("SRC_IMAGE", fileImg.getAbsolutePath());
//    }
//
//    public byte[] exportPdf(final String jrxmlName,
//                            final Map<String, Object> params,
//                            final Collection<?> beanCollection) throws Exception {
//        final JasperPrint jasperPrint = getJasperPrint(jrxmlName, params, beanCollection);
//        return JasperExportManager.exportReportToPdf(jasperPrint);
//    }


}
