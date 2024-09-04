package com.survey.survey.responsequestion.domain.entity;

import com.survey.survey.question.domain.entity.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="response_question")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ResponseQuestion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private int id;

    @OneToOne
    @JoinColumn(name="question_id")
    private Question question;

    @Column(columnDefinition="TEXT", nullable=false)
    @NotBlank(message="The field cannot be blank")
    private String response;
}
