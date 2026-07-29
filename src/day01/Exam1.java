/*
    Git 브랜치 관련 명령어

새 브랜치 만들기
git branch <브랜치명>              # 브랜치만 생성 (이동 안 함)
git checkout -b <브랜치명>         # 생성 + 바로 이동
git switch -c <브랜치명>           # 위와 동일 (최신 방식)

브랜치 이동
git checkout <브랜치명>
git switch <브랜치명>

특정 브랜치로 push
git push origin <브랜치명>                    # 로컬 <브랜치명>을 origin의 같은 이름 브랜치로 push
git push origin <로컬브랜치>:<원격브랜치>      # 이름이 다를 때 (로컬:원격)
git push -u origin <브랜치명>                 # -u(--set-upstream)로 최초 push하면서 추적 연결 설정
-u로 한 번 연결해두면 그 다음부터는 그냥 git push만 해도 해당 브랜치로 push됩니다.

현재 브랜치의 upstream(추적 브랜치) 확인/변경
git branch -vv                                # 각 브랜치가 어떤 원격 브랜치를 추적 중인지 확인
git branch --set-upstream-to=origin/<브랜치명>  # 기존 브랜치의 추적 대상 변경

GitHub 저장소의 기본(default) 브랜치 바꾸기 (예: master → main 등)
- 이건 로컬 git 명령이 아니라 GitHub 쪽 설정입니다:
  - GitHub 저장소 → Settings → Branches → "Default branch" → Switch to 다른 브랜치
  - 또는 CLI로: gh repo edit <owner>/<repo> --default-branch <브랜치명>
- 로컬에서 clone 시 기본으로 checkout되는 브랜치도 이 설정을 따라갑니다.

로컬 checkout 시 기본으로 따라갈 브랜치 지정 (git이 처음 checkout할 브랜치)
git config --global init.defaultBranch <브랜치명>   # 앞으로 git init 할 때 기본 브랜치 이름

브랜치 목록/삭제
git branch -a          # 로컬+원격 브랜치 전부 확인
git branch -d <브랜치명>   # 로컬 브랜치 삭제 (병합 안 됐으면 -D로 강제)
git push origin --delete <브랜치명>   # 원격 브랜치 삭제

지금 저장소는 현재 master 브랜치 하나뿐이고 origin의 default도 master로 보입니다. 필요하면 위 명령으로 새 브랜치 파서 작업하시면 됩니다.
    

    Ctrl + F5 또한 실행 단축키
 */

package day01; // 패키징(폴더명)이면서 클래스의 위치 식별용도

public class Exam1 {
    // public: 공개용, 다른 패키지에서 사용 가능한 클래스
    // class: 클래스 선언 사용하는 키워드
    // 클래스명의 첫글자는 대문자
        // 클래스는 자바에서의 가장 최소 컴파일 단위
    
    int b = 10;
    // 실행 시작점 생성, main 함수 (Thread)
    // js에 없는 이유는 브라우저가 엔진을 대신한다
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
    }

}
