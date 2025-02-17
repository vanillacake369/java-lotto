## 전체 로직

### UI 로직

- [x]  로또 구입금액 입력
    - [x]  1000원 단위 예외처리
    - [x]  만약 가능하다면 ,000 단위로 입려되는 것도 정상처리가 되게끔 하자
- [x]  당첨 번호 입력
    - [x]  쉼표 기준으로 구분
        - [x]  하나의 로또에 대한 예외처리
            - [x]  사이즈가 6인지 체크
            - [x]  쉼표 구분자를 사용하여 입력하였는지 체크
            - [x]  중복 수가 없는지 체크
- [ ]  당첨 통계를 출력한다.
    - [ ]  6등~1등 순으로 당첨 갯수 출력
    - [ ]  총 수익률 출력

### 도메인 로직

- [x]  구입 금액에 따라 구매할 로또의 개수를 가져온다. getLotteryNumByAmount // 8000 or 8,000 ⇒ 8개
- [x]  가져온 로또의 개수만큼 로또를 발행한다.
    - [x]  1~45는 고정되어있으니 상수화하자.
    - [x]  하나의 로또지 발행
        - [x]  1~45 랜덤수 6개 생성 ⇒ 로또
        - [x]  우테코 제공함수 ****`pickUniqueNumbersInRange(int, int, int)`**
    - [x]  로또의 개수만큼의 로또지 생성
- [ ]  당첨 결과를 가져온다.
    - [ ]  로또 개수만큼 로또지 당첨결과를 확인한다.
        - [ ]  각 로또지마다 당첨 기준을 확인한다.
        - [ ]  어떻게 확인할 것이냐
            - [ ]  랜덤생성된 로또와 당첨번호를 입력하면 일치개수를 반환받자
                - [ ]  6개 일치하면 1등
                - [ ]  5개가 일치한다면 보너스 번호를 확인한다.
                    - [ ]  보너스 번호가 일치하면 2등
                    - [ ]  일치하지 않는다면 3등
                - [ ]  4개 일치 4등
                - [ ]  3개 일치 5등
        - [ ]  보너스 번호는 5개가 맞을 때만 확인하는 것을 명심하자. 이를 통해 확인하는 조건을 상세화할 수 있다
    - [ ]  1등~6등의 개수를 저장한다.
        - [ ]  어느 자료구조를 사용할 것이냐
            - [ ]  리스트를 활용한다.
- [ ]  총 수익률을 계산한다.
    - [ ]  등수에 따라 수익금을 계산한다.
        - [ ]  등수에 대해 key:value 관계로 매핑시킨 당청금을 불러온다.
        - [ ]  당첨결과에 따라 수익금을 계산하고 반환한다.
            - [ ]  수익률 = 수익/구입금 * 100

## 단위테스트 목록 정리

### UI 로직 테스트

- [ ]  로또 구입금액 입력
    - [ ]  1000원 단위 입력조건 테스트
    - [ ]  만약 가능하다면 ,000 단위로 입력되는 것도 정상처리 되는지 테스트
    - [ ]  잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
      ⇒ 예외_테스트() By 우테코
    - [ ]  입력에 대하여 숫자가 아닌 문자들에 대한 예외처리
- [ ]  당첨 번호 입력 테스트
    - [ ]  쉼표 기준으로 구분되는지 테스트
        - [ ]  구분 안 될 시 예외처리되는지 테스트
    - [ ]  길이가 6이 맞는지 체크
- [ ]  보너스 번호를 입력 테스트

### 도메인 로직 단위테스트

- [ ]  가져온 로또의 개수만큼 로또를 발행한다.
    - [ ]  1~45는 고정되어있으니 고정화하자.
    - [ ]  하나의 로또지 발행
        - [ ]  어떻게 중복되지 않는 6개의 숫자를 저장할 것이냐
        - [ ]  1개의 로또에 대해 어느 자료구조를 사용할 것이냐
    - [ ]  로또의 개수만큼의 로또지 저장
        - [ ]  동적으로 할당해야만, 로또의 개수만큼의 로또지를 저장할 수 있다.
        - [ ]  개수만큼의 전체 로또를 저장할 때 어느 자료구조를 사용할 것이냐
- [ ]  당첨 결과를 가져온다.
    - [ ]  각 로또지마다 당첨 기준을 확인한다.
        - [ ]  어떻게 확인할 것이냐
            - [ ]  보너스 번호는 5개가 맞을 때만 확인하는 것을 명심하자. 이를 통해 확인하는 조건을 상세화할 수 있다
    - [ ]  1등~6등의 개수를 저장한다.
        - [ ]  어느 자료구조를 사용할 것이냐
- [ ]  수익률 계산 테스트
    - [ ]  수익률에 대해 소수점 둘쨰 자리 반올림이 되는지 체크
- [ ]  “모든 단위 테스트를 합친” 당첨 통계를 출력 테스트 ⇒ 기능_테스트() By 우테코
    - [ ]  6등~1등 순으로 당첨 갯수 출력
    - [ ]  총 수익률 출력