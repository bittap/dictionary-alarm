package com.example.demo.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.dto.WordInstractDto;
import com.example.demo.entity.WordDataEntity;
import com.example.demo.entity.WordDataEntity.Nationality;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WordInstracter {

  private final Path TARGET_FILE;

  public List<WordInstractDto> instract(int instractCount)
      throws FileNotFoundException, IOException {
    List<WordInstractDto> datas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(TARGET_FILE.toString()))) {
      String line;
      int currentCount = 0;
      while ((line = reader.readLine()) != null) {
        currentCount++;
        if (currentCount > instractCount) {
          break;
        } else {
          datas.add(convertStringToDto(line));
        }
      }
    }

    return datas;
  }

  public void updateFile(List<Long> targets) {


  }

  private WordInstractDto convertStringToDto(String target) {
    final String TAB = "\t";
    String[] wordData = target.split(TAB);
    String word = wordData[0].replaceAll("\\d", "");
    LocalDateTime now = LocalDateTime.now();

    WordDataEntity entity =
        WordDataEntity.create(word, Nationality.KOREA, Integer.parseInt(wordData[4]), now, now);

    return new WordInstractDto(entity, Long.valueOf(wordData[0]));
  }



}
