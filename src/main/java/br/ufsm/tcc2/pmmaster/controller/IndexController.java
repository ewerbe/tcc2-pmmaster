package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.model.Usuario;
import br.ufsm.tcc2.pmmaster.service.UsuarioService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({"/", "/home"})
    public String getIndex(Model model) {
        //List<Usuario> usuarios = usuarioService.findAll();
        //Usuario usuario = usuarios.get(0);
        model.addAttribute("idUsuario", 1L);
        return "home";
    }

//    @RequestMapping(value = "/fichas")
//    public @ResponseBody byte[] getImage() throws IOException {
//        InputStream in = getClass()
//                .getResourceAsStream("D:\\actualpmmasterhibrido\\pmmaster\\src\\main\\webapp\\images\\fichas.jpg");
//        assert in != null;
//        return IOUtils.toByteArray(in);
//    }


    @RequestMapping(value = "/fichas", method = RequestMethod.GET)
    public ResponseEntity<Object> getImage() throws IOException {

        String filename = "/home/ewertonbarbos/tcc2-pmmaster/src/main/webapp/images/fichas.jpg";
            File file = new File(filename);

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", String.format("attachment filename=\"%s\"", file.getName()));
            headers.add("Cache-control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            ResponseEntity<Object> result = ResponseEntity.ok().headers(headers).
                    contentLength(file.length()).contentType(MediaType.IMAGE_PNG).body(resource);
            return result;
    }



}
