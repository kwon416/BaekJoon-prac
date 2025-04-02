package AlgorithmProgrammingTutorial;

public class StringExample {
    public static void main(StringExample[] args) {
        String str = "apple";

        // 길이 반환
        str.length();

        // 빈 문자열 체크
        str.isEmpty();

        // 문자 찾기
        str.charAt(0); // 'a' -> char 반환
        str.indexOf("a"); // 0 -> 인덱스 반환
        str.lastIndexOf("p"); // 2 -> 마지막으로 문자가 속한 인덱스 반환

        // 문자 자르기
        str.substring(1, 3); // "pp" -> 인덱스 1이상 3미만 위치의 문자열 반환
        str.substring(3); // "app" -> 인덱스 3미만 위치의 문자열 반환

        // 문자 치환(바꾸기)
        // replace(기존문자, 바꿀문자)
        str.replace('p', 'e'); // "aeele" -> 모든 기존문자를 바꿀문자로 치환

        // replaceAll(정규식, 바꿀문자)
        str.replaceAll("\\.", "/"); // "//////" -> 정규식에 맞춰 문자 치환 (정규식 "."은 모든 문자를 의미)

        // replaceFirst(기존문자, 바꿀문자)
//        str.replaceFirst();

        // 문자 동일 여부 판단
        // 자바 String 의 경우, 클래스로써 Call by Reference 형태로 생성 시 주소값이 부여된다.
        // 그렇기에 String 타입을 선언했을 때는 같은 값을 부여하더라도 서로 주소값이 다르다.
        // 따라서 값 비교는 equals 를 사용한다.
        str.equals("apple");  // true
        
        // 문자비교
        /*
        str 과 applp 가 같으면 0
        str 이 applp 보다 사전순으로 앞이면 -1
        사전 순으로 뒤면 1
        str 과 applp 가 마지막 문자만 다르면, 마지막 문자의 사전순 차이 반환
         */

        str.compareTo("applp"); // -1 
        
        // 문자 포함 여부
        str.contains("app"); // true
        
        // 문자열 분리
        str.split(" "); // 공백으로 구분된 문자열 str 을 분리하여 String[] 으로 반환
//        str.split(); // 한 문자 씩 분리하여 String[] 으로 반환
        
        // 문자 앞 뒤 공백 제거
        str.trim(); // 앞 뒤 공백만 제거, 문자열 사이의 공백은 제거 안함

        // 문자 <-> 숫자 변환
        Integer.parseInt("100"); // int 100 반환
        Integer.toString(100); // "100" 반환


        // StringBuilder
        // 스트링은 한 번 만들어지면 추가 삭제가 안되므로, 변경을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        
        // 문자열 추가
        sb.append("apple");
        
        // 특정 인덱스에 문자 삽입
        sb.insert(2, "oo"); // "apoople"
        
        // 문자열 삭제
        sb.delete(0,2); // 0부터 2 미만 인덱스 삭제 -> "oople"
        
        // 특정 인덱스의 문자 삭제
        sb.deleteCharAt(2); // "oole"
        
        // 특정 인덱스의 문자 변경
        sb.setCharAt(1, 'p');  // "ople"
        
        // 문자열 뒤집기
        sb.reverse(); // "elpo"
        
        // 문자열 절대길이 줄이기 
        sb.setLength(2); // 길이를 2로 -> "el"
        
        // 문자열 절대길이 늘리기
        sb.setLength(4); // 길이를 4로 -> "el  " 공백으로 채움


    }
}
