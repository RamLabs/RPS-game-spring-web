package dev.ramlabs.rpsgamespringwebexample.service;

import dev.ramlabs.rpsgamespringwebexample.RPSChoice;
import dev.ramlabs.rpsgamespringwebexample.RPSResult;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RPSGameService {

    // Set Random object as instance variable (SonarLint)
    private final Random random = new Random();

    public RPSResult play(RPSChoice userChoice, RPSChoice computerChoice) {
        if (userChoice == computerChoice) {
            return RPSResult.DRAW;
        } else if ((userChoice == RPSChoice.ROCK && computerChoice == RPSChoice.SCISSORS) ||
                (userChoice == RPSChoice.PAPER && computerChoice == RPSChoice.ROCK) ||
                (userChoice == RPSChoice.SCISSORS && computerChoice == RPSChoice.PAPER)) {
            return RPSResult.WIN;
        } else {
            return RPSResult.LOSE;
        }
    }

    public RPSChoice generateComputerChoice() {
        int choiceIndex = random.nextInt(3);
        return switch (choiceIndex) {
            case 0 -> RPSChoice.ROCK;
            case 1 -> RPSChoice.PAPER;
            case 2 -> RPSChoice.SCISSORS;
            default -> throw new IllegalStateException("Unexpected value: " + choiceIndex);
        };
    }
}
