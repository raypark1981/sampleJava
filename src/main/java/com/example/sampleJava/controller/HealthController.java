package com.example.sampleJava.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/api/health")
    public Map<String, Object> health(){
        return Map.of(
                "code", "200",
                "message", "정상 처리 되엇습니다. ",
                "data", Map.of(
                        "status", "ok"
                )
        );
    }

    @PostMapping("/api/health")
    public Map<String, Object> healthPost(@RequestBody Map<String, Object> body){
        return Map.of(
                "code", "200",
                "message", "정상 처리 되엇습니다. ",
                "data", Map.of(
                        "status", "ok"
                )
        );
    }
}
