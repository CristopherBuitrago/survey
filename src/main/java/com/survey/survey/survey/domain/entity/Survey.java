package com.survey.survey.survey.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.survey.survey.categoriescatalog.domain.entity.CategoriesCatalog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
    private String name;

    @Column
    private String description;

    @Column(name="created_at", columnDefinition="TIMESTAMP")
    private LocalDateTime createdAt;
    
    @Column(name="updated_at", columnDefinition="TIMESTAMP")
    private LocalDateTime updatedAt;

    @JoinTable(
        name = "survey_category",
        joinColumns = @JoinColumn(name = "survey_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"category_id", "survey_id"})}
    )
    private List<CategoriesCatalog> categories;

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
