## 🐣 **멤버**

|<img src="asset/squrtle.webp" alt="김윤정" width="50" height="50">|<img src="asset/meowth.webp" alt="김현재" width="50" height="50">|<img src="asset/psyduck.webp" alt="문준호" width="50" height="50">|<img src="asset/bu.webp" alt="주연우" width="50" height="50">|
|---|---|---|---|
|김윤정|김현재|문준호|주연우|
## 📌 **규칙**
- 화, 목 9시 30분

## 🛠️ **참여 방법**

[상세내용](https://velog.io/@jisubin12/Github-%EC%99%B8%EB%B6%80%EC%A0%80%EC%9E%A5%EC%86%8C-fork-pull-request-%EB%8F%99%EA%B8%B0%ED%99%94-%ED%95%98%EA%B8%B0)

1. 이 저장소를 개인 원격 저장소로 fork한다.
2. fork한 git을 로컬 저장소로 clone한다.
3. 로컬 저장소에 원본 저장소(Upstream)를 등록.
```
 $ git remote add upstream [원본 저장소 주소]
```
4. 로컬 저장소에서 작업하고 fork한 원격 저장소에 commit & push한다.
```
 $ git add .
 $ git commit -m "커밋 메시지"
 $ git push origin branch_name
```
5. 작업 전에 원본 저장소의 최신 내용을 확인한다
```
$ git fetch upstream
```
7. 원본 저장소의 최신 내용을 로컬 main 브랜치에 병합한다
```
 $ git checkout main
 $ git merge upstream/main
```
(충돌이 발생하면 충돌을 해결하고 `git add`, `git commit`으로 처리)
7. 개인 브랜치로 이동하고 최신 내용을 반영한다
```
 $ git checkout branch_name
 $ git rebase main  # 개인 브랜치에 main 최신 내용 반영
 $ git push origin branch_name  # 변경 내용 원격 저장소에 반영
```
8. 작업을 완료한 후, 원본 저장소로 PR(Pull Request)을 생성한다.

**pull request가 승인되어야 잔디가 표시되고, pr 후 잔디는 커밋한 날짜를 기준으로 심어집니다.**

 (*매일 pr 할 필요는 없는 듯*)

## 🖊️ **커밋 컨벤션**
```
어떻게 할까요
```

## 📬 **PR 규칙**

```
[날짜] 문제제목
```

## 📦 **레퍼지토리 폴더 구조**
사람마다 폴더 나누기 vs 문제마다 폴더 나누기

---
git에서 다운받았을 때 project가 안보인다면
1. import 프로젝트 주소
2. 프로젝트 우클릭 build path -> configure build path 클릭
3. jre 선택 후 apply

---
## 🗑️폐기된 아이디어
### *참여 방식*
```
0. git 이메일 확인
  git config --global user.email 각자이메일

1. 협력자 초대를 받는다.

2. 로컬 저장소로 클론
  git clone https://github.com/munjh61/SSAFY-CodingTest.git

3. 각자 branch를 만들기
  git checkout -b 브랜치명

4. 파일 스테이징
  git add .

5. 커밋하기
  git commit -m'메세지'

6. 업데이트가 되어있는지 확인하기
  git pull
  :wq

7. 원격 저장소로 푸시
  git push origin 브랜치명

8. pull request를 하게 되면 꼭 연락주세요.

```

## 🚀역대 문제 기록
1. [[250123][백준_1158][S4]요세푸스](https://www.acmicpc.net/problem/1158)  
2. [[250123][백준_8958][B2]OX퀴즈](https://www.acmicpc.net/problem/8958)  
3. [[250123][백준_2810][B1]컵홀더](https://www.acmicpc.net/problem/2810)  
4. [[250123][백준_13300][B2]방배정](https://www.acmicpc.net/problem/13300)  
5. [[250206][백준_2292][B2]벌집](https://www.acmicpc.net/problem/2292)  
6. [[250206][백준_2477][S2]참외밭](https://www.acmicpc.net/problem/2477)  
7. [[250211][백준_1592][B2]영식이와친구들](https://www.acmicpc.net/problem/1592)  
8. [[250211][백준_2839][S4]설탕배달](https://www.acmicpc.net/problem/2839)  
9. [[250212][백준_8320][B2]직사각형을만드는방법](https://www.acmicpc.net/problem/8320)  
10. [[250218][SWEA_1961][D2]숫자배열회전](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=1961&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
11. [[250216][SWEA_1859][D3]백만장자프로젝트](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=1859&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
12. [[250220][백준_14696][B1]딱지놀이](https://www.acmicpc.net/problem/14696)
13. [[250220][백준_9093][B1]단어뒤집기](https://www.acmicpc.net/problem/9093)
14. [[250225][SWEA_14555][D3][공과잡초]](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AYGtoa3qARcDFARC&categoryId=AYGtoa3qARcDFARC&categoryType=CODE&problemTitle=14555&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
15. [[250225][SWEA_11315][D3][오목판정]](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ&categoryId=AXaSUPYqPYMDFASQ&categoryType=CODE&problemTitle=%EC%98%A4%EB%AA%A9+%ED%8C%90%EC%A0%95&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
16. [[250227][SWEA_1979][D2][어디에_단어가_들어갈_수_있을까?]](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PuPq6AaQDFAUq&categoryId=AV5PuPq6AaQDFAUq&categoryType=CODE&problemTitle=1979&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
17. [[250227][SWEA_1289][D3][원재의_메모리_복구하기]](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=1289&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
18. [[250306][백준_2999][비밀이메일]](https://www.acmicpc.net/problem/2999) 
19. [[250306][백준_3985][롤케이크]](https://www.acmicpc.net/problem/3985) 
20. [[250313][백준_2164][카드2]](https://www.acmicpc.net/problem/2164) 
21. [[250313][백준_10816][숫자 카드2]](https://www.acmicpc.net/problem/10816) 
22. [[250313][백준_11650][좌표 정렬하기]](https://www.acmicpc.net/problem/11650) 
23. [[250313][백준_11723][집합]](https://www.acmicpc.net/problem/11723) 
24. [[250319][백준_15649][N과M1번]](https://www.acmicpc.net/problem/15649) 
25. [[250319][백준_1182][부분수열의 합]](https://www.acmicpc.net/problem/1182) 
26. [[250319][백준_10872][팩토리얼 - 연습문제]](https://www.acmicpc.net/problem/10872) 
27. [[250319][백준_10870][피보나치 수 5 - 연습문제]](https://www.acmicpc.net/problem/10870) 
28. [[250319][백준_17478][재귀함수가 뭔가요?]](https://www.acmicpc.net/problem/17478) 
29. [[250319][백준_1463][1로 만들기]](https://www.acmicpc.net/problem/1463) 
30. [[250325][백준_10974][모든순열]](https://www.acmicpc.net/problem/10974) 
31. [[250325][백준_2003][수들의 합2]](https://www.acmicpc.net/problem/2003)
32. [[250325][백준_10829][이진수 변환]](https://www.acmicpc.net/problem/10829)
33. [[250327][백준_6603][로또]](https://www.acmicpc.net/problem/6603)
34. [[250327][백준_3986][좋은 단어]](https://www.acmicpc.net/problem/3986)
35. [[250401][백준_0][유기농배추]](https://www.acmicpc.net/problem/0)
36. [[250403][백준_4386][별자리]](https://www.acmicpc.net/problem/4386)
37. [[250403][백준_20920][영어단어암기는어려워]](https://www.acmicpc.net/problem/20920)
38. [[250403][백준_2667][단지번호붙이기]](https://www.acmicpc.net/problem/2667)
39. [[250408][백준_1303][전쟁 - 전투]](https://www.acmicpc.net/problem/1303)
40. [[250408][백준_1929][소수구하기]](https://www.acmicpc.net/problem/1929)
41. [[250408][백준_2960][에라토스테네스의 체]](https://www.acmicpc.net/problem/2960)
42. [[250408][백준_1016][제곱ㄴㄴ수]](https://www.acmicpc.net/problem/1016)
43. [[250408][백준_2468][안전 영역]](https://www.acmicpc.net/problem/2468)
44. [[250613][백준_15903][카드합체놀이]](https://www.acmicpc.net/problem/15903)
45. [[250613][백준_1541][잃어버린 괄호]](https://www.acmicpc.net/problem/1541)
46. [[250613][백준_1946][신입 사원]](https://www.acmicpc.net/problem/1946)
47. [[250613][백준_2178][미로 탐색]](https://www.acmicpc.net/problem/2178)
48. [[250616][백준_12865][평범한 배낭]](https://www.acmicpc.net/problem/12865)
49. [[250616][백준_13549][숨바꼭질 3]](https://www.acmicpc.net/problem/13549)
50. [[250616][백준_2206][벽 부수고 이동하기]](https://www.acmicpc.net/problem/2206)
51. [[250618][백준_1202][보석도둑]](https://www.acmicpc.net/problem/1202)
52. [[250618][백준_14500][테크로미노]](https://www.acmicpc.net/problem/14500)
53. [[250618][백준_9663][N Queen]](https://www.acmicpc.net/problem/9663)
54. [[250620][백준_15686][치킨배달]](https://www.acmicpc.net/problem/15686)
55. [[250620][백준_9935][문자열폭발]](https://www.acmicpc.net/problem/9935)
56. [[250620][백준_2096][내려가기]](https://www.acmicpc.net/problem/2096)
57. [[250623][백준_18870][좌표압축]](https://www.acmicpc.net/problem/18870)
58. [[250623][백준_18111][마인크래프트]](https://www.acmicpc.net/problem/18111)
59. [[250623][백준_2178][미로 탐색]](https://www.acmicpc.net/problem/2178)
60. [[2506][백준_0][0]](https://www.acmicpc.net/problem/0)
61. [[2506][백준_0][0]](https://www.acmicpc.net/problem/0)
62. [[2506][백준_0][0]](https://www.acmicpc.net/problem/0)
63. [[2506][백준_0][0]](https://www.acmicpc.net/problem/0)
