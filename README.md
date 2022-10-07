# sw-repo-manager

## Basic Cencepts

본 리포는 연습문제과 정답을 관리하기 위한 리포 입니다.
2개의 깃모듈과 원 코드 폴더를 포함한 총 3개의 폴더로 구현되어 있습니다. 

1. 수강생을 위한 연습문제용 (read-only, version)
2. 수강생을 위한 정답 레퍼런스용 (read-only, version)
3. 내부 코드 정리와 이력을 기록하는 용도 및 1번, 2번을 특정 버전 시점으로 생성하는 용도 (read and write)

주의 : 가능한 rm명령어를 사용하지 않는 방법을 하였다.

> {}-main 폴더를 제외한,
> () 및 {}-assign 폴더는 언제든 삭제되어도 무방하다, 
> 해당내용은 assing branch and ref branch에 기록되어 있을뿐


## Config (진행중) 
package.json 에 추가되어 있는 예시처럼 추가 해주세요.
```
"swRepoManager": {
    "assignRepoPath": "project3-microservices-assign",
    "assignRepoUrl": "git@github.com:cs-devops-bootcamp/project3-microservices-url.git",
    "refRepoPath": "project3-microservices-ref",
    "refRepoUrl": "git@github.com:cs-devops-bootcamp/project3-microservices-ref.git",
    "mainRepoPath": "project3-microservices-main"
}
```

- \<package-name>-main
- \<package-name>
- \<package-name>-ref

[] 아직은 package.json 의 scripts 에 해당하는 부분을 모두 직접 바꿔줘야 한다. 

## Environment 
nodejs 14.19.1 for nodegit




## Usage

### 0. 사전준비 
```bash
# 필요한 npm package를 선택합니다.
# nodegit 사용을 위해 .nvmrc에 명시된 Node.js 버전을 사용합니다.
nvm use && npm install
```

```
npm run init
```
브랜치 2개를 만들고, 필요한 폴더 2개를 만든후 최소 2개 커밋이 들어간 상태를 만들어둔다.

### 1. 코드 개발
 main 폴더에서 코드 수정후 

### 2. 브랜치별 코드 분리
문제는 assign브랜치에서 만들고 커밋하고, 거기로 ref를 rebase한다음에, 다 완성되면 ref로 master를 rebase한다음에 추가 하고 싶은 내용을 추가해서 기록해둔다.

### 3. 브랜치별 코드를 하위Git폴더로 배포
deploy 명령으로 두개의 브랜치에 있는 파일들을 하위 git 시스템 폴더로 옮기고 커밋을 정리한다. 
```
npm run deploy:ref
npm run deploy:assign
```

### 4. 버저닝
standard-version 을 실행해서 모든 파일이 커밋된상태에서 버저닝을 진행하고 
```
npm run version                               
✔ bumping version in package.json from 0.1.0 to 0.1.1
✔ bumping version in package-lock.json from 1.0.4 to 0.1.1
✔ outputting changes to CHANGELOG.md
✔ committing package-lock.json and package.json and CHANGELOG.md
✔ tagging release v0.1.1
ℹ Run `git push --follow-tags origin main && npm publish` to publish
```
하위 폴더 2개에도 같은 버전 태그를 기입한다. 
```
cd ./im-repo-manager   
git tag v0.1.1 
```



## Todos
- [x] 우선 git 명령어로 준비 해둔다. 
- [ ] 사용된 프로젝트를 연결하고 소개한다. cs-devops-bootcamp/project3-microservices
- [ ] nodegit 으로 자연스럽게 자동으로 되도록 한다. 
- [ ] .sw-repo-ignore 폴더에 main path에는 있어도 좋지만, 수강생은 몰라도 되는 파일들을 정리하자