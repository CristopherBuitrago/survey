package com.survey.survey.survey_json.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;

import com.survey.survey.survey.domain.entity.Survey;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "survey_json")
public class SurveyJson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime createdAt;

    @JoinColumn(name = "survey_id", nullable = false)
    @ManyToOne
    private Survey survey;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "payload", columnDefinition = "JSONB", nullable = false)
    private String payload;

    

}

// // Método para convertir el JSONB a un objeto Java específico
// public <T> T getPayloadAsObject(Class<T> clazz) throws JsonProcessingException {
//     ObjectMapper objectMapper = new ObjectMapper();
//     return objectMapper.readValue(this.payload, clazz);
// }

// // Método para establecer el JSONB desde un objeto Java
// public void setPayloadAsObject(Object object) throws JsonProcessingException {
//     ObjectMapper objectMapper = new ObjectMapper();
//     this.payload = objectMapper.writeValueAsString(object);
// }