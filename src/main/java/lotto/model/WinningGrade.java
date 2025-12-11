package lotto.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693a1a746e508191a21d63cfdece696f
 * https://chatgpt.com/s/t_693a190d65488191aa4251f0a8e3e27b
 * https://chatgpt.com/s/t_693a18e7be8481919066933a3bffba0f
 * https://chatgpt.com/s/t_693a18fcf53881918d49660b8137b349
 * https://chatgpt.com/s/t_693a18e7be8481919066933a3bffba0f
 */
public enum WinningGrade {

    NONE(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    ;

    private static final Map<Integer, WinningGrade> LOOKUP_MAP = new HashMap<>();

    static {
        for (WinningGrade winningGrade : values()) {
            if (winningGrade != SECOND && winningGrade != NONE) {
                LOOKUP_MAP.put(winningGrade.matchCount, winningGrade);
            }
        }
    }

    private final int matchCount;
    private final int prize;
    private final String noticeMessage;

    WinningGrade(int matchCount, int prize, String noticeMessage) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.noticeMessage = noticeMessage;
    }

    public static WinningGrade of(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        return LOOKUP_MAP.getOrDefault(matchCount, NONE);
    }

    public int getPrize() {
        return prize;
    }

    public String getNoticeMessage() {
        return noticeMessage;
    }
}
