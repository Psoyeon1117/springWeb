package springPractice1.hello_spring.controller;

public class memberForm {
    private String name;    //html에서 input에 들어오는 변수의 name과 동일한 이름이어야한다.
    //html에서 input에 들어오는 변수의 이름이 password라면 여기도 password여야 한다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
