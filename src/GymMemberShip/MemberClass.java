package GymMemberShip;

public class MemberClass {

    private String name;
    private int age;
    private String membership;
    private int feePaid;

    MemberClass (String name, int age, String membership,int feePaid){

        this.name = name;
        this.age = age;
        this.membership = membership;
        this.feePaid = feePaid;
    }

    public int getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(int feePaid) {
        this.feePaid = feePaid;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void memberInfo(){

        System.out.println("NAME = " + name);
        System.out.println("AGE = " + age);
        System.out.println("MEMBERSHIP INFO = " + membership);
        System.out.println("FEE = " + feePaid);

    }

}
