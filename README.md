#내일배움캠프 일정 관리 과제

* 과제명 : 일정을 관리하는 앱 만들기
* 개발 일정 : 1/23 ~ 2/4
* 구현 단계 : Lv2

  ## 구현
  * 필수
    * Lv0
       - API 명세서 작성
       - ERD 작성
       - SQL 작성
    * Lv1
       - 일정 생성
       - 전체 일정 조회
       - 선택 일정 조회
    * Lv2
       - 선택 일정 수정
       - 선택 일정 삭제
     
  * 도전
    * Lv3 - 연관 관계 설정 [작성자외 일정의 연결]
    * Lv4 - 페이지네이션
    * Lv5 - 예외 발생 처리
    * Lv6 - null체크 및 특정 패턴에 대한 검증

### ERD
![스크린샷 2025-02-03 시간: 16 17 58](https://github.com/user-attachments/assets/02a5b21e-5fd3-4ea1-b068-93cb179b27f6)

https://www.erdcloud.com/d/8ANCs2ZZd4pJS4ejP

### API
|기능|URL|request|response|상태코드|
|---|---|---|---|-----|
|일정 등록|POST|/schedules|등록 정보|201|
|전제 일정 조회|GET|/schedules|전제 일정 정보|200|
|선택 일정 조회|GET|/schedules/{id}|선택 일정 정보|200|
|일정 수정|PUT|/schedules/{id}|선택 일정 수정|200|
|일정 삭제|DELETE|/schedules/{id}|선택 일정 삭제|200|

### SQL
![스크린샷 2025-02-03 시간: 15 18 21](https://github.com/user-attachments/assets/4875d760-0dc7-443d-bbe5-69e66f93f0fe)

### 트러블 슈팅
https://cork-7.tistory.com/51

## 과제를 진행하며 느낀점
이번 과제도 어영부영 끝낸 느낌이다.
이론 강의에서 뒤죽박죽 정리하고 이해가 안된상태로 진행을 하니 코드가 이상해지고 스트레스로 쉬는 시간이 더 많이 생긴 과제였다고 생각한다.
