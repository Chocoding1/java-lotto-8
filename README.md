# java-lotto-precourse

## 기능 목록
---
1. **[입력] 로또 구입 금액을 입력 받는다.**
    - [예외처리] 금액이 숫자 타입이 아닐 경우 IllegalArgumentException 예외를 발생시킨다.
    - [예외처리] 금액이 1000원 미만일 경우 IllegalArgumentException 예외를 발생시킨다.
    - [예외처리] 1000원으로 나누어 떨어지지 않을 경우 IllegalArgumentException 예외를 발생시킨다.
2. **[중간 과정] 구입 금액에 맞게 로또를 발행한다.**
3. **[출력] 발행한 로또를 출력한다.**
4. **[입력] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.**
    - [예외처리] 쉼표 외의 문자가 포함되어 있을 경우 IllegalArgumentException 예외를 발생시킨다.
    - [예외처리] 입력 받은 당첨 번호가 6개가 아닐 경우 IllegalArgumentException 예외를 발생시킨다.
    - [예외처리] 각 당첨 번호가 1 ~ 45 사이의 정수가 아닐 경우 IllegalArgumentException 예외를 발생시킨다.
5. **[입력] 보너스 번호를 입력 받는다.**
    - [예외처리] 보너스 번호가 숫자 타입이 아닐 경우 IllegalArgumentException 예외를 발생시킨다.
    - [예외처리] 보너스 번호가 1 ~ 45 사이의 정수가 아닐 경우 IllegalArgumentException 예외를 발생시킨다.
    - [예외처리] 입력 받은 당첨 번호와 중복된 수일 경우 IllegalArgumentException 예외를 발생시킨다.
6. **[중간 과정] 번호를 비교하여 수익률을 계산한다. (소수점 둘째 자리 반올림)**
7.** [출력] 당첨 내역을 출력한다.**
