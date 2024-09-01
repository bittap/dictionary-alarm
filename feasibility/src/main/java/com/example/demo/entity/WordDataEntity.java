package com.example.demo.entity;


import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "word_data")
@Entity
@NoArgsConstructor
@Getter
public class WordDataEntity {

  @Id
  @GeneratedValue
  private Long no;

  @Column(nullable = false, length = 50)
  private String word;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, columnDefinition = "ENUM('KOREA', 'JAPAN', 'AMERICAN')")
  private Nationality type;

  @Column(nullable = true)
  private Integer level;

  private LocalDateTime created;

  private LocalDateTime updated;

  public static WordDataEntity create(String word, Nationality type, Integer level,
      LocalDateTime created, LocalDateTime updated) {
    WordDataEntity entity = new WordDataEntity();
    entity.word = word;
    entity.type = type;
    entity.level = level;
    entity.created = created;
    entity.updated = updated;

    return entity;
  }

  /**
   * 国
   * 
   *
   */
  public enum Nationality {
    KOREA, JAPAN, AMERICAN;
  }
}
