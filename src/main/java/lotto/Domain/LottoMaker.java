package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class LottoMaker {
    // 금액에 따른 로또 개수
    private int lottoAmount = 0;
    private final List<Lotto> lottoTickets = new ArrayList<>();

    // 생성자
    public LottoMaker(){}
    public LottoMaker(int lottoAmount){
        this.lottoAmount = lottoAmount;
    }

    // getter & setter
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
    public void setLottoTickets(Lotto lotto) {lottoTickets.add(lotto);}
    

    // 생성된 로또지 출력
    public void printLottoTickets(){
        System.out.println(this.lottoAmount+"개를 구매했습니다.");
        for(Lotto lotto:lottoTickets){
            System.out.println(lotto);
        }
    }

    // 로또의 개수만큼의 로또지 생성
    public void issueLottoTickets(int lottoAmount){
        Lotto lotto = new Lotto(publishLottoTicket());
        this.lottoTickets.add(lotto);
    }

    // 하나의 로또지 발행
    public List<Integer> publishLottoTicket(){
        List<Integer> ticket = Randoms.
                pickUniqueNumbersInRange(Constants.firstNumber,
                        Constants.lastNumber, Constants.lottoLength);
        return ticket;
    }
}
