package com.springboot.siicoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.siicoreapp.models.service.MailService;

@Controller
public class MailController {
	
	@Autowired
    private MailService mailService;

    @GetMapping("/mail")
    public String index(){
        return "/views/mail/send_mail_view";
    }

    @PostMapping("/sendMail")
    public String sendMail( @RequestParam("subject") 
    String subject, @RequestParam("body") String body, RedirectAttributes attr){

        String message = body +"\n\n Datos de contacto: ";
        mailService.sendMail("siicoreweb@gmail.com",subject,message);
        attr.addFlashAttribute("success", "Correo enviado exitosamente");
 
        return "redirect:/mail/";
    }
}
