# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# 빌드
./mvnw clean package

# 실행
./mvnw spring-boot:run

# 테스트 전체 실행
./mvnw test

# 단일 테스트 실행
./mvnw test -Dtest=SampleJavaApplicationTests

# 컴파일만
./mvnw compile
```

## Stack

- **Spring Boot 4.1.0** / Java 21
- **Spring Data JPA** + Hibernate (OracleDialect)
- **Oracle DB** (ojdbc11 23.4.0) — 로컬 Docker 컨테이너 사용 (아래 참고)
- **Lombok**
- **spring-boot-starter-validation**, **spring-boot-starter-webmvc**

## 아키텍처

패키지 루트: `com.example.sampleJava`

현재는 초기 단계로 Controller 레이어만 존재한다. 앞으로 아래 구조로 확장 예정:

```
controller/   — REST API 엔드포인트 (@RestController)
service/      — 비즈니스 로직
repository/   — Spring Data JPA Repository
entity/       — JPA @Entity 클래스
```

API 응답은 `Map<String, Object>` 형태로 `code`, `message`, `data` 키를 사용하는 구조를 따른다.

## DB 설정

- **접속 정보** (`application.properties`): `jdbc:oracle:thin:@//localhost:1521/FREEPDB1`, user: `study`, pw: `study1234`
- `spring.jpa.hibernate.ddl-auto=none` — DDL 자동 생성 비활성화, 스키마는 수동 관리
- `spring.jpa.show-sql=true` — 실행 SQL 콘솔 출력 활성화

### Oracle Docker

```bash
# 최초 실행
docker run -d --name oracle-free -p 1521:1521 -e ORACLE_PWD=oracle1234 \
  container-registry.oracle.com/database/free:latest

# 시작 / 중지
docker start oracle-free
docker stop oracle-free

# 로그 확인
docker logs -f oracle-free
```

SQL Developer 접속: Host `localhost`, Port `1521`, Service `FREEPDB1`, user `system`, pw `oracle1234`

## 학습 로드맵

이 프로젝트는 이론을 먼저 공부하지 않고, **기능 구현에 필요한 내용을 그때그때 학습**하는 방식으로 진행한다.

- [ ] Java 기본 문법 — 객체지향, 클래스, 인터페이스
- [ ] Spring Boot 기초
- [ ] HTTP와 REST API 기초
- [ ] Controller → Service → Repository 구조
- [ ] DTO, Validation, 예외 처리
- [ ] MyBatis
- [ ] JPA + Hibernate / Spring Data JPA
- [ ] QueryDSL
- [ ] 트랜잭션
- [ ] JUnit 기본 테스트
- [ ] Spring Security 기초
- [ ] Docker와 배포 기초
