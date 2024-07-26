# Musinsa Project
안녕하세요. 
무신사 지원자 임종완 입니다. 
무신사 과제 개발내용 검토 부탁 드리겠습니다.

1. Package 구조는 다음과 같습니다.
   기본 Package : com.limstar.musinsa
   controller :
      1. AdminController -> 4번 문항 CRUD API (운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.)
      2. MusinsaController -> 1,2,3번 문항 API

   entity : Table entity
   request : 요청 데이터 class
   response : 결과값 응답 데이터 class
   error, handler : Exception 응답 처리 enum data
   reource : application.yml 환경 설정 정보
             schema.sql - > table 생성 쿼리 
             data.sql -> data 입력 쿼리 
   Junit Spring boot Test : mock 테스트, repository data 확인 테스트 케이스

2. 프로젝트 환경 구성 및 설명
   Spring boot 3.3.1 JAVA
   DB : H2 mem
   기본 설정 정보는 application.yml 에서 확인 가능
   runtime시 h2 DB는 schema.sql & data.sql 스크립트로 기본 테이블 및 데이터 생성 됩니다.
   기본 접근 URL : http://localhost:8080


## 과제 코드 가져오기 및 빌드하여 실행까지 다음과 같이 명령어를 이용하여 진행 부탁 드립니다.
```sh
git clone https://github.com/LimStarrr/musinsa.git
cd musinsa
```
## Build the Project
### Linux / macOS
```sh 클린명령
./gradlew clean
```

```sh 빌드하기
./gradlew build
```

## Run the Application
### Linux / macOS
```sh Musinsa 서버 실행하기
./gradlew bootRun
```

서버 실행 완료 후 DB 테이블 및 데이터 생성 및 실시간 데이터 쿼리 확인 가능 ( H2 Database )
```H2
1. 웹 H2 URL : http://localhost:8080/db
    2. url: 'jdbc:h2:mem:musinsa'
    3. username: musinsa
    4. password: limstar
```

## 서버 설치 및 실행 후 API 테스트를 위한 명령어
서버 api 호출 명령어 ( curl ) 을 사용하여 호출하면 결과와 같이 결과값을 받을 수 있습니다.
무신사 구현해야하는 API들의 설명과 호출 명령어 및 예상 결과값을 아래와 같이 설명하였습니다.
api 호출 확인 시 이용 부탁 드리겠습니다.

1. 구현1) api - 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
   curl -X GET http://localhost:8080/musinsa/lowestprice
   result> [{"브랜드":"D","카테고리":"상의","가격":10100},{"브랜드":"E","카테고리":"아우터","가격":5000},{"브랜드":"D","카테고리":"바지","가격":3000},{"브랜드":"A","카테고리":"스니커즈","가격":9000},{"브랜드":"G","카테고리":"스니커즈","가격":9000},{"브랜드":"A","카테고리":"가방","가격":2000},{"브랜드":"D","카테고리":"모자","가격":1500},{"브랜드":"I","카테고리":"양말","가격":1700},{"브랜드":"F","카테고리":"액세서리","가격":1900}]%
2. 구현 2) - 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
   curl -X GET http://localhost:8080/musinsa/brandwithlowesttotalprice
   result> {"최저가":{"브랜드":"C","카테고리":[{"브랜드":"C","카테고리":"아우터","가격":6200},{"브랜드":"C","카테고리":"바지","가격":3300},{"브랜드":"C","카테고리":"스니커즈","가격":9200},{"브랜드":"C","카테고리":"가방","가격":2200},{"브랜드":"C","카테고리":"모자","가격":1900},{"브랜드":"C","카테고리":"양말","가격":2200},{"브랜드":"C","카테고리":"액세서리","가격":2100}],"총액":27100}}%
3. 구현 3) - 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
   curl -X GET http://localhost:8080/musinsa/{category}
   ex command > curl -X GET http://localhost:8080/musinsa/상의
   result> {"카테고리":"상의","최고가":[{"브랜드":"I","카테고리":"상의","가격":11400}],"최저가":[{"브랜드":"D","카테고리":"상의","가격":10100}]}%
4. 운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.
   1. POST 상품 등록 명령어 
   curl -d '{"brand":"K", "category":"J", "price":10000}' -H "Content-Type: application/json" -X POST http://localhost:8080/admin/product
   2. PUT 상품 업데이트 명령어
   curl -d '{"id":"1", "brand":"L", "category":"슬리퍼", "price":10000}' -H "Content-Type: application/json" -X PUT http://localhost:8080/admin/product
   3. GET 상품 ID로 조회
   curl -X GET http://localhost:8080/admin/product/2
   4. DELETE 상품 ID로 데이터 삭제
   curl -X DELETE http://localhost:8080/admin/product/3

이상입니다. 확인 감사 드립니다. 임종완 드림.