package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.WordDataEntity;
import com.example.demo.repository.WordDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WordDataService {

  private final WordDataRepository REPOSITOY;

  @Transactional
  public void insertData(List<WordDataEntity> wordDatas) {
    REPOSITOY.saveAll(wordDatas);
  }
}
