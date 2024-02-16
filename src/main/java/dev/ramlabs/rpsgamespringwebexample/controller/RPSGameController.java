package dev.ramlabs.rpsgamespringwebexample.controller;

import dev.ramlabs.rpsgamespringwebexample.RPSChoice;
import dev.ramlabs.rpsgamespringwebexample.RPSResult;
import dev.ramlabs.rpsgamespringwebexample.service.RPSGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rps")
public class RPSGameController {

    private final RPSGameService rpsGameService;

    // Use constructor injection instead of field injection (SonarLint)
    @Autowired
    public RPSGameController(RPSGameService rpsGameService) {
        this.rpsGameService = rpsGameService;
    }

    @GetMapping("/play/{choice}")
    public String playGame(@PathVariable String choice) {
        RPSChoice userChoice = RPSChoice.valueOf(choice.toUpperCase());
        RPSChoice computerChoice = rpsGameService.generateComputerChoice();
        RPSResult result = rpsGameService.play(userChoice, computerChoice);
        return "You chose: " + userChoice + ". Computer chose: " + computerChoice + ". Result: " + result;
    }
}
