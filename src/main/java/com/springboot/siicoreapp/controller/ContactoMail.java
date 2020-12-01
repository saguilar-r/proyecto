package com.springboot.siicoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.siicoreapp.models.service.ContactoMailService;

@Controller
public class ContactoMail {

	@Autowired
    private ContactoMailService mailServices;

    @GetMapping("/contactomail")
    public String index(){
        return "/views/mail/contactoMail";
    }

    @PostMapping("/sendMails")
    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") 
    String subject, @RequestParam("body") String body, RedirectAttributes attr){

        String message = body +"\n\n Datos de Contacto: " + " \nNombre: " +name + "\nE-mail: " +mail;
        mailServices.sendMails("siicoreweb@gmail.com",subject,message);
        attr.addFlashAttribute("success", "Gracias por escribirnos. Pronto nos pondremos en contacto con usted.");
 
        return "redirect:/contactomail/";
    }
}
