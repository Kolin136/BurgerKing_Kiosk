package project;

public class InputException extends Exception{
    public InputException(int n) {
        super("잘못된 입력입니다! 1~"+String.valueOf(n)+"숫자를 입력해주세요!");
    }
}
