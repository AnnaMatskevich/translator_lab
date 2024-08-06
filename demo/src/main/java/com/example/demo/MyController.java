package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("/mytranslator")
    public String translate(Model model) {
        model.addAttribute("answer", "here will be your translation");
        return "translator";
    }


    @PostMapping("/mytranslator")
    public String translate(@RequestParam(name = "sourceLanguageCode") String sourceLanguageCode,
                            @RequestParam(name = "targetLanguageCode") String targetLanguageCode,
                            @RequestParam(name = "text") String text,
                            HttpServletRequest user_request,
                            Model model) {
        String ipAddress = user_request.getRemoteAddr();
        YandexTranslator translator = new YandexTranslator();
        String answer = translator.multithreaded_translation_by_word(text, sourceLanguageCode, targetLanguageCode);
        Request request = new Request(ipAddress, text, answer);
        requestRepository.save(request);
        try {
            model.addAttribute("answer", translator.multithreaded_translation_by_word(text, sourceLanguageCode, targetLanguageCode));
        } catch (Exception e) {
            model.addAttribute("answer", e.getMessage());
        }
        return "translator";
    }

    @GetMapping("/mytranslator/requests_history")
    public String requestHistory(Model model) {
        Iterable<Request> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);
        return "requests_history";
    }

}
