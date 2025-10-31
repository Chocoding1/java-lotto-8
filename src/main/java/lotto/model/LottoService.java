package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private static LottoService instance;

    private final LottoExtractor lottoExtractor = LottoExtractor.getInstance();

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (instance == null) {
            instance = new LottoService();
        }
        return instance;
    }

    public List<Lotto> publishLotto(int purchasePrice) {
        int lottoQuantity = getLottoQuantity(purchasePrice); // 로또 발행 개수는 service에서 하고, 로또 추출기는 입력받은 횟수만큼 로또 추출만 하도록

        return lottoExtractor.getLotto(lottoQuantity);
    }

    private int getLottoQuantity(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public void checkDuplicate(LottoNumber bonusNumber, List<LottoNumber> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 번호입니다.");
        }
    }

//    public List<WinningResult> getWinningResult(List<Lotto> lottos, List<LottoNumber> winningLottoNumbers,
//                                                LottoNumber bonusNumber) {
//        List<WinningResult> winningResults = new ArrayList<>();
//        for (Lotto lotto : lottos) {
//            winningResults.add(getMatchCount(lotto, winningLottoNumbers, bonusNumber));
//        }
//        return winningResults;
//    }

//    private WinningResult getMatchCount(Lotto lotto, List<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
//        List<Integer> numbers = lotto.getNumbers();
//        int matchCount = 0;
//        for (Integer number : numbers) {
//            if (winningLottoNumbers.contains(number)) {
//                matchCount++;
//            }
//        }
//        boolean matchBonus = false;
//        if (numbers.contains(bonusNumber)) {
//            matchCount++;
//            matchBonus = true;
//        }
//
//        return new WinningResult(matchCount, matchBonus);
//    }
}
