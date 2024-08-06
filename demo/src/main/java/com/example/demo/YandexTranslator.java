package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.*;

import org.springframework.http.ResponseEntity;

public class YandexTranslator {
    private static final int MAX_THREADS = 10;

    public String multithreaded_translation_by_word(String st, String sourceLanguageCode, String targetLanguageCode) {
        final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
        Scanner sc = new Scanner(st);
        List<Callable<String>> tasks = new ArrayList<>();
        while (sc.hasNext()) {
            tasks.add(new One_word_translator_class(sc.next(), sourceLanguageCode, targetLanguageCode));
        }
        try {
            List<Future<String>> futures = executor.invokeAll(tasks);
            StringBuilder answer = new StringBuilder();
            for (Future<String> future : futures) {
                answer.append(future.get());
                answer.append(" ");
            }
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
            return answer.toString();
        } catch (Exception e) {
            return "exception during parallel translating " + e.getMessage();
        }
    }

    private static class One_word_translator_class implements Callable<String> {
        private final String word;
        private final RestTemplate restTemplate = new RestTemplate();
        private final String targetLanguageCode;
        private final String sourceLanguageCode;
        private static final String URL = "https://yandex.cloud/api/translate/translate";

        public One_word_translator_class(String word, String sourceLanguageCode, String targetLanguageCode) {
            this.word = word;
            this.targetLanguageCode = targetLanguageCode;
            this.sourceLanguageCode = sourceLanguageCode;
        }

        @Override
        public String call() {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            Map<String, Object> payload = new HashMap<>();
            payload.put("sourceLanguageCode", sourceLanguageCode);
            payload.put("targetLanguageCode", targetLanguageCode);
            payload.put("format", "PLAIN_TEXT");
            payload.put("texts", Collections.singletonList(word));
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Map responseMap = objectMapper.readValue(response.getBody(), Map.class);
                    List<Map<String, String>> translations = (List<Map<String, String>>) responseMap.get("translations");
                    return translations.get(0).get("text");
                } catch (JsonProcessingException e) {
                    throw new RuntimeException("Error during parsing json answer from translator " + e.getMessage());
                }
            } else {
                throw new RuntimeException("Translating error " + response.getStatusCode());
            }
        }
    }
}
