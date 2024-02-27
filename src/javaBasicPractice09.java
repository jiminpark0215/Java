//키로깅 프로그램

/*
특수 작전을 위해 상대방의 PC에 키보드 입력 내용을 얻을 수 있는 키로깅 프로그램을 설치했다.
해당 키로깅 프로그램으로 부터는 아래와 같이 특정 값으로 내용이 수신된다.
 - 8 : Backspace
 - 16 : shift
 - 20 : Caps Lock
 - 32 : Space bar
 - 37 : 키보드 왼쪽 화살표
 - 39 : 키보드 오른쪽 화살표
 - 155 : Insert
 - 127 : Delete
 - 97 ~ 122 : 알파벳 소문자( 기본 입력은 소문자 기준, Shift 나 Caps Lock 에 의해 변경)
 - 48 ~ 57 : 숫자 0 ~ 9

키로깅 프로그램으로 부터 수신된 데이터를 원래 내용으로 복구하는 프로그램을 작성

*/

public class javaBasicPractice09 {
    public static String solution(int[] keylog){
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;

        StringBuffer sb = new StringBuffer();

        int step = (int)('a' - 'A');
        int curSor = 0;
        int cmdIdx = 0;
        boolean isShift = false;
        boolean isCapsLock = false;
        boolean isInsert = false;

        while (cmdIdx != keylog.length){
            int cur = keylog[cmdIdx];//하나씩 꺼내옴

            if (cur == BACK_SPACE){
                if (curSor == 0){
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor - 1 , curSor); //하나 삭제
                curSor = Math.max(0, curSor - 1); //커서 한 칸 좌측이동

            } else if(cur == SHIFT){
                isShift = true;

            } else if (cur == CAPS_LOCK) {
                isCapsLock = !isCapsLock; //토글

            } else if (cur == SPACE_BAR) {
                inputData(sb, ' ', curSor, isInsert);//공백 문자 넣기 메서드 호출
                curSor += 1; //커서 한 칸 우측이동

            } else if (cur == KEY_LEFT) {
                curSor = Math.max(0, curSor - 1);//커서 한 칸 좌측이동

            } else if (cur == KEY_RIGHT) {
                curSor = Math.min(sb.length(), curSor + 1);//커서 한 칸 우측이동

            } else if (cur == INSERT) {
                isInsert = !isInsert;//토글

            } else if (cur == DELETE) {
                if (curSor == sb.length()){//삭제할 문자가 없을 때
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor, curSor + 1); //삭제 후 커서 위치

            } else if (cur >= 97 && cur <= 122) { //알파벳
                int data = cur; //임시로 데이터 대입

                if (isCapsLock && isShift){
                    data = cur; //아무 변동없음
                } else if (isCapsLock || isShift) {
                    data -= step; //step값 빼서 대문자로 바뀜
                }

                inputData(sb, (char)data, curSor, isInsert); //알파벳 삽입
                isShift = false; //다시 초기값 잡아줌
                curSor += 1;

            } else if (cur >= 48 && cur <= 57) { //숫자
                //데이터 입력
                if(isShift){ //shift가 눌리면 특수문자로 바꿔줌
                    char[] specialKey = {')' , '!' , '@', '#', '$', '%', '^', '&', '*', '('}; 
                    inputData(sb, specialKey[cur - '0'], curSor, isInsert); //0 ~ 9까지의 값
                }else {
                    inputData(sb, (char)cur, curSor, isInsert ); //shift가 아니면 숫자값이 들어가도록
                }

                isShift = false; //다시 초기값 잡아줌
                curSor += 1;
            }
            cmdIdx++;
        }
        return sb.toString();
    }

    public static void inputData(StringBuffer sb, char data, int curSor, boolean isInsert){
        if(isInsert == false){ //삽입모드가 이닐 때
            sb.insert(curSor, data);
        }else {
            sb.setCharAt(curSor, data);
        }
    }
    public static void main(String[] args){
        int[] keylog = {16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104};
        System.out.println(solution(keylog));

        keylog = new int[]{20, 104, 16, 105, 32, 30, 16, 106, 97, 118, 97};
        System.out.println(solution(keylog));

        keylog = new int[]{49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53};
        System.out.println(solution(keylog));

        keylog = new int[]{20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51};
        System.out.println(solution(keylog));

    }

}
