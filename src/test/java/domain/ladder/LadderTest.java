package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.strategy.BridgeGeneratorStub;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,2"})
    @DisplayName("플레이어의 위치에서 시작해 사다리를 타기를 완료한 최종 위치를 반환한다")
    void getFinalPositionTest(int playerPosition, int expected) {
        // given
        PlayerName playerName1 = new PlayerName("kaki");
        PlayerName playerName2 = new PlayerName("solar");
        PlayerName playerName3 = new PlayerName("eden");

        LadderHeight height = new LadderHeight(3);
        List<LadderBridge> bridges = List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.NONE);
        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        PlayerNames playerNames = new PlayerNames(List.of(playerName1, playerName2, playerName3));

        // when
        bridgeGeneratorStub.setBridges(bridges);
        LadderGenerator ladderGenerator = new LadderGenerator(height, playerNames, bridgeGeneratorStub);
        List<Floor> floors = ladderGenerator.generate();
        Ladder ladder = new Ladder(floors);
        int finalPosition = ladder.getFinalPosition(playerPosition);

        /* 사다리 형태
            aa    bb    cc
             |-----|     |
             |-----|     |
             |-----|     |
            꽝    당첨    꽝
         */

        // then
        assertThat(finalPosition).isEqualTo(expected);
    }
}
