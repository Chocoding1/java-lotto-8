package lotto.config;

import lotto.controller.LottoController;
import lotto.model.service.LottoComparator;
import lotto.model.service.lottopublisher.LottoNumberExtractor;
import lotto.model.service.lottopublisher.LottoPublisher;
import lotto.model.service.prizecalculator.NumberRounder;
import lotto.model.service.prizecalculator.PrizeCalculator;

public class AppConfig {

    private LottoController lottoController;
    private LottoPublisher lottoPublisher;
    private LottoNumberExtractor lottoNumberExtractor;
    private LottoComparator lottoComparator;
    private PrizeCalculator prizeCalculator;
    private NumberRounder numberRounder;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(lottoPublisher(), lottoComparator(), prizeCalculator());
        }
        return lottoController;
    }

    public LottoPublisher lottoPublisher() {
        if (lottoPublisher == null) {
            lottoPublisher = new LottoPublisher(lottoNumberExtractor());
        }
        return lottoPublisher;
    }

    public LottoNumberExtractor lottoNumberExtractor() {
        if (lottoNumberExtractor == null) {
            lottoNumberExtractor = new LottoNumberExtractor();
        }
        return lottoNumberExtractor;
    }

    public LottoComparator lottoComparator() {
        if (lottoComparator == null) {
            lottoComparator = new LottoComparator();
        }
        return lottoComparator;
    }

    public PrizeCalculator prizeCalculator() {
        if (prizeCalculator == null) {
            prizeCalculator = new PrizeCalculator(numberRounder());
        }
        return prizeCalculator;
    }

    public NumberRounder numberRounder() {
        if (numberRounder == null) {
            numberRounder = new NumberRounder();
        }
        return numberRounder;
    }
}
