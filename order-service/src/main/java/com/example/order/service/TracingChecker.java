package com.example.order.service;

import io.opentelemetry.api.trace.Tracer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TracingChecker {

    private final Tracer tracer;

    public TracingChecker(Tracer tracer) {
        this.tracer = tracer;
    }

    @PostConstruct
    public void init() {
        System.out.println("✅ Tracing is initialized. Current tracer: " + tracer);
    }
}