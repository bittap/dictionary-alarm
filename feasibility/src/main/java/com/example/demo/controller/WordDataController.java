package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.WordDataEntity;
import com.example.demo.service.WordDataService;
import com.example.demo.word.WordInstracter;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/word_data")
@RequiredArgsConstructor
public class WordDataController {

  private final WordDataService SERVICE;



  @GetMapping
  public void insertWordData() throws FileNotFoundException, IOException {
    final WordInstracter INSTRACTER = new WordInstracter(Path.of("src/main/resources/word.txt"));
    List<WordDataEntity> wordDatas = INSTRACTER.instract();
    SERVICE.insertData(wordDatas);
  }
}
