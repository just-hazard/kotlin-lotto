package lotto.domain

// 시나리오
// 예외 - 1000원 보다 커야함
// 1000원 단위로 루프를 돌면서 남은 금액이 1000원 보다 낮으면 거스름돈으로 빼고 루프 종료
// 1000원 이상일 경우 루프를 돌면서 코인 충전 +1
class Money(var inputPrice: Int) {

    var lottos = Lottos()
    var remainMoney: Int = 0

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val ZERO = 0
    }

    init {
        validation1000MoreThan()
        lottos = buyLotto()
    }

    private fun buyLotto() : Lottos {
        // inputPrice가 1000원 이상일 경우 Lottos에 Lottos 객체 생성
        // Loop를 돌 때마다 해당 금액이 1000원 이상인지 확인하면서 돌고
        // 1000원 미만일 경우 거스름돈에 담기

        while(inputPrice >= LOTTO_PRICE) {
            buyOnePiece()
        }
        change()

        return lottos
    }

    private fun change() {
        if(inputPrice > ZERO) {
            remainMoney = inputPrice
        }
    }

    private fun buyOnePiece() {
        inputPrice = inputPrice.minus(LOTTO_PRICE)
//        lottos.lottoList.add(Lotto())
    }

    private fun validation1000MoreThan() {
        if(inputPrice < LOTTO_PRICE) {
            throw IllegalArgumentException("로또 한장당 구매금액은 1000원 입니다.")
        }
    }
}
