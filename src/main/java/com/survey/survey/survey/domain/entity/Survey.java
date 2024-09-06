package com.survey.survey.survey.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.survey.survey.chapter.domain.entity.Chapter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank(message="The field cannot be blank!")
    private String name;

    @Column
    @NotBlank(message="The field cannot be blank!")
    private String description;
    
    @Column(name="created_at", columnDefinition="TIMESTAMP")
    private LocalDateTime createdAt;
    
    @Column(name="updated_at", columnDefinition="TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column
    private Boolean status;

    @OneToMany(mappedBy="survey")
    private List<Chapter> chapters;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PostPersist
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
