package lotto.domain

import domain.Value

// 로또 게임 목록을 가지고 있는 도메인
// 해야 할 일
// 자동 로또 번호를 만들어서 넘겨주기
// 코인 갯수 만큼 자동 로또 객체 생성 ( 번호를 전달 받을 때 매번 섞어서 보내기 )
class Lottos {
    var lottoList = mutableListOf<Lotto>()
    private val ranNumbers = RandomNumber()

    fun getLottoSize() : Int {
        return lottoList.size
    }

    fun createAutoLotto(coin : Int) {
        for(index in Value.ZERO until coin) {
            lottoList.add(Lotto(ranNumbers.createRandomNumbers()))
        }
    }

}
