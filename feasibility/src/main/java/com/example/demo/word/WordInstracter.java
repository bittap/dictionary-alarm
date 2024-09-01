package com.example.demo.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.entity.WordDataEntity;
import com.example.demo.entity.WordDataEntity.Nationality;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WordInstracter {

  private final Path TARGET_FILE;

  public List<WordDataEntity> instract() throws FileNotFoundException, IOException {
    List<WordDataEntity> datas = new ArrayList<>();

    System.out.println(TARGET_FILE.toAbsolutePath());

    try (BufferedReader reader = new BufferedReader(new FileReader(TARGET_FILE.toFile()));) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
        datas.add(convertStringToEntity(line));
      }
    }

    TARGET_FILE.toFile().delete();

    return datas;
  }


  private WordDataEntity convertStringToEntity(String target) {
    final String TAB = "\t";
    String[] wordData = target.split(TAB);
    String word = wordData[1].replaceAll("\\d", "");
    LocalDateTime now = LocalDateTime.now();

    return WordDataEntity.create(word, Nationality.KOREA, Integer.parseInt(wordData[4]), now, now);
  }



}
