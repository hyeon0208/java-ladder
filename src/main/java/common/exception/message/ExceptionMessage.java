package common.exception.message;

import domain.LadderHeight;
import domain.PlayerNames;

public class ExceptionMessage {

    public static final String PLAYER_NAMES_RANGE = String.format("참가자의 수는 %d 이상, %d 이하여야 합니다",
            PlayerNames.PLAYER_NAMES_MIN_RANGE, PlayerNames.PLAYER_NAMES_MAX_RANGE);
    public static final String PLAYER_NAMES_DUPLICATION = "참가자 이름은 중복될 수 없습니다";
    public static final String LADDER_HEIGHT_RANGE = String.format("사다리 높이의 범위는 %d 이상, %d 이하여야 합니다",
            LadderHeight.HEIGHT_MIN_RANGE, LadderHeight.HEIGHT_MAX_RANGE);
    public static final String INTEGER_FORMAT = "정수 형태만 입력 가능합니다";
    public static final String PLAYER_NAME_BLANK = "참가자 이름으로 공백을 사용할 수 없습니다";
    public static final String PLAYER_NAMES_INPUT_FORMAT = "참가자 이름 형식이 올바르지 않습니다";
}
