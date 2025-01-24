## 🐣 **멤버**

|<img src="https://i.namu.wiki/i/1fJgTa4Qb9M3W6oXBw0YJcCSqrgUDEdNc5_R5XhI6uFt-PwQpaNuj4km75sbxsWfEGY3heNBSHT0fFJ2Af2MPbhAzsC4GjR8Oh62-4Cmwujs0zsyo5rvlscbtNAPVOny6JOz6Fl5LgB-haO4e2k4UQ.webp" alt="김윤정" width="50" height="50">|<img src="https://i.namu.wiki/i/O9kShYKXbkq4USe-Bob5wm_wtC2MdkPEK3y24Tu6M9nNVsynrIFHjckMQuL2vgs4wYIUjZwYETlqR4HQOdW0CYFXN7t1ngHlh8WiSVqmKBv_vb4WxBd4-D4Lb50U1qeve-q0lZMsgg1e1cCZM0EPkw.webp" alt="김현재" width="50" height="50">|<img src="https://i.namu.wiki/i/i6ZpdaKiiEf4qzrR_m9NjvBriuvWtFktDjDX-wry76CYBSssaiOpsZRTVXU20K0kDFnnoBqR9SiVkYh_akXYmQ.webp" alt="문준호" width="50" height="50">|<img src="https://i.namu.wiki/i/I77jbxd2_8Sczv5L5fNdOx9sduPWGtSzGLJrgU52iSHMgGFMU7V_96CYmBsZ9psk5yWl12d6c0LNOOWK7h83Ix2UW9gn1PAEL3CY6nKP4DryZZT9i6kZRHonnGq8XuMUKAThp8XfY1XGWC-_kL-wuA.webp" alt="주연우" width="50" height="50">|
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
1. [[250123][백준1158][S4]요세푸스](acmicpc.net/problem/1158)
2. [[250123][백준8958][B2]OX퀴즈](https://www.acmicpc.net/problem/8958)
3. [[250123][백준2810][B1]컵홀더](https://www.acmicpc.net/problem/2810)
4. [[250123][백준13300][B2]방배정](https://www.acmicpc.net/problem/13300)
5. [[250206][백준2292][B2]벌집](https://www.acmicpc.net/problem/2292)
6. [[250206][백준2477][S2]참외밭](https://www.acmicpc.net/problem/2477)
7. [[250206][백준1592][B2]영식이와친구들](https://www.acmicpc.net/problem/1592)
8. [[250211][백준2839][S4]설탕배달](https://www.acmicpc.net/problem/2839)

