package dev.ramlabs.rpsgamespringwebexample.controller;

import dev.ramlabs.rpsgamespringwebexample.RPSChoice;
import dev.ramlabs.rpsgamespringwebexample.RPSResult;
import dev.ramlabs.rpsgamespringwebexample.service.RPSGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RPSGameControllerTest {

    @Mock
    private RPSGameService rpsGameService;

    @InjectMocks
    private RPSGameController rpsGameController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPlayGameRock() {
        String choice = "ROCK";
        RPSChoice userChoice = RPSChoice.ROCK;
        RPSChoice computerChoice = RPSChoice.SCISSORS;
        RPSResult result = RPSResult.WIN;

        when(rpsGameService.generateComputerChoice()).thenReturn(computerChoice);
        when(rpsGameService.play(userChoice, computerChoice)).thenReturn(result);

        String expectedResult = "You chose: ROCK. Computer chose: SCISSORS. Result: WIN";
        String actualResult = rpsGameController.playGame(choice);

        assertEquals(expectedResult, actualResult);
    }
}