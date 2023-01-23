package br.ufsm.tcc2.pmmaster.controller;

import br.ufsm.tcc2.pmmaster.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class IndexController {

    @GetMapping({"/", "/home"})
    public String getIndex() {
        return "home";
    }

    @RequestMapping(value = "/fichas.action", method = RequestMethod.GET)
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
