## 제출 
- ### 1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
  - #### 수정시엔 RequestBody 방식을 사용하였습니다.
  - #### 삭제시엔 PathVariable이용해 해당 아이디값으로 삭제를 하였습니다
- ### 2. 어떤 상황에 어떤 방식의 request를 써야하나요?
  - #### 데이터를 드러내고 싶지 않을때는 body를 쓰고
  - #### 조건이 여러가지거나 필터링 해야한다면 query
  - #### 본인이 원하는 명으로 mapper에서 사용할 수 있을때 사용함.
- ### 3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
  - #### api uri 부분을 동사로 목적을 드러내지않고 명사를 씀으로써 members라는 리소스 uri에 매핑했습니다.
- ### 4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
  - #### 네 Controller에서는 클라이언트에게서 요청을 받고 서비스에게 넘겨주고 서비스에서 Repository를 통한 SQL작업을 하였습니다.
- ### 5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요.
  - #### 네!

## API명세서
|method|URL|Request|
|:---:|:---:|:---:|
|GET|/api/members|-|
|GET|/api/members/{id}|-|
|POST|/api/members|{"title" : "title", "username" : "username", "username", "contents" : "contents", "password" : "password"}|
|POST|/api/members/{1}|{"password" : "password"}|
|PUT|/api/members/{1}|{"title" : "title", "title2" : "username", "username2", "contents" : "contents2", "password" : "password2"}|
|DELETE|/api/members/{1}|-|

