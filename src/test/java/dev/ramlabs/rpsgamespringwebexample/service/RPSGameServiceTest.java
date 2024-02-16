package dev.ramlabs.rpsgamespringwebexample.service;

// RPSGameServiceTest.java
import dev.ramlabs.rpsgamespringwebexample.RPSChoice;
import dev.ramlabs.rpsgamespringwebexample.RPSResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Repeat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RPSGameServiceTest {

    @Mock
    private RPSGameService rpsGameService = new RPSGameService();

    public RPSGameServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Repeat(5)
    void testPlayWin() {
        when(rpsGameService.play(RPSChoice.ROCK, RPSChoice.SCISSORS)).thenReturn(RPSResult.WIN);
        RPSResult result = rpsGameService.play(RPSChoice.ROCK, RPSChoice.SCISSORS);
        assertEquals(RPSResult.WIN, result);
    }

    @Test
    @Repeat(5)
    void testPlayLose() {
        when(rpsGameService.play(RPSChoice.PAPER, RPSChoice.SCISSORS)).thenReturn(RPSResult.LOSE);
        RPSResult result = rpsGameService.play(RPSChoice.PAPER, RPSChoice.SCISSORS);
        assertEquals(RPSResult.LOSE, result);
    }

    @Test
    @Repeat(5)
    void testPlayDraw() {
        when(rpsGameService.play(RPSChoice.SCISSORS, RPSChoice.SCISSORS)).thenReturn(RPSResult.DRAW);
        RPSResult result = rpsGameService.play(RPSChoice.SCISSORS, RPSChoice.SCISSORS);
        assertEquals(RPSResult.DRAW, result);
    }
}
