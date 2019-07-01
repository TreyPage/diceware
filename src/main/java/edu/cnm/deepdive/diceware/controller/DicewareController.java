package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.service.PassphraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("diceware")
public class DicewareController {

  private PassphraseGenerator generator;


  @Autowired
  public DicewareController(PassphraseGenerator generator) {
    this.generator = generator;
  }


  @GetMapping()
  public String[] get(@RequestParam(value = "length", defaultValue = "6") int length) {
    return generator.passphrase(length);
  }

}
