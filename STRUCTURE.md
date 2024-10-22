## 도메인 구조 분석 
### global
> 모든 도메인에서 공유하는 소스 및 기능이 정의됩니다.

- `exceptions` : 공통으로 사용되는 예외이며, 사용자 정의 예외의 기본 예외가 정의 되어 있습니다.
  - `CommonException` : 사용자가 정의하는 모든 예외의 시작점, 예외 메세지 및 예외 코드와 함께 처리 합니다.
  - `BadRequestException` : 사용자 요청 데이터가 처리에 맞지 않은 경우, 즉 사용자의 데이터를 검증했을때 실패한 경우 발생하는 예외, 이때는 예외 코드가 400으로 고정합니다.
- `libs`: 편의 기능 모음
  - Utils
    - `drawLine` : 라인 그리기 
    - `loadTpl` : 출력 템플릿 객체 생성 및 출력 함수 호출(print(), print(Model model))
    - `loadController`: 컨트롤러 객체 생성 및 실행 함수 호출(run())
    - `getString` : 텍스트 입력 처리, 필수 입력 검증 역시 진행이 됩니다(`commonInputProcess`). 검증 성공시 입력한 값을 반환
    - `getNumber`: 숫자 입력 처리, 필수 입력 검증(`commonInputProcess`) 및 숫자 검증이 진행이 됩니다. 정상 입력이 된 경우 int 형으로 변환하여 반환
    - `commonInputProcess`: 공통 입력 처리, 필수 항목 검증, M 입력시 메인 메뉴 이동, Q 입력시 종료 처리
- `validators` : 공통 검증 인터페이스 모음
  - `RequiredValidator` : 필수 항목 검증
  - `TypeValidator`: 자료형 검증 - 현재는 숫자 형식 검증만 있음, 필요에 따라 추가해도 됨
- `BeanContainer`: 객체를 최초로 조회하는 경우는 객체를 생성하고 이를 컨테이너(beans)에 보관합니다. 따라서 2번째 조회부터는 이미 생성된 객체를 반환 합니다. 
  - 싱글톤 패턴이 적용된 사례(필요할때 한번만 생성해서 공유하는 패턴)
                    
- `Container`: 모든 컨트롤러의 기본 틀, 즉 정의하는 모든 컨트롤러는 Controller의 하위 클래스,  즉 반드시 실행되어야 하는 절차가 run() 함수에 정의되어 있습니다.
  - run() 함수에는 common() -> view() -> prompt() 메서드가 순서대로 실행이 되며 
  - 이중에서 view()는 Controller가 상속받은 하위 클래스가 구현을 합니다. 
  - 즉 컨트롤러 마다 다르게 출력되는 부분을 정의하고 출력합니다.
  - 절차의 순서는 딱 고정되는 중요한 내용이므로 이를 템플릿화 하여 고정하는 패턴, 즉 `추상 메서드 템플릿 패턴` 이라고 합니다.

- `Model` : 출력(Template)에 전달할 데이터를 담기 위한 용도
  - Model 객체는를 Utils.loadTpl(Class<T> clazz, Model model) 형태로 호출한다면 Template 인터페이스의 print(Model model)로 호출이 되고 템플릿에서 데이터 출력시 사용하면 됩니다. 
 
- `Router`: 프로그램을 시작하는 메서드 execute()가 정의되어 있고 처음 메뉴로 MainController해서 실행해 줍니다. 
- `Template`: 템플릿 출력의 기본 틀, Utils.loadTpl(...)을 호출하면 print() 또는 print(Model model)이 호출 됩니다.