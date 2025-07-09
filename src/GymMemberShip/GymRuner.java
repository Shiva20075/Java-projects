package GymMemberShip;

public class GymRuner {

    public static void main(String[] args) {

        MemberClass person = new MemberClass("SAI" , 23,"MONTHLY",500);

        person.setAge(32);
        person.setFeePaid(355);
        person.setName("Shiva");
        person.setMembership("Week");

        MemberClass person2 = new MemberClass("OMBABA",26,"MONTLY", 450);

        person2.setFeePaid(345);
        person2.setName("PRAKASH");
        person2.setMembership("WEEK");
        person2.setAge(26);

        GymClass newMember = new GymClass();

        newMember.addMember(person);
        newMember.addMember(person2);

        newMember.showMember();
        newMember.removeMembers(person2);
        newMember.showMember();

        newMember.totalFees();
    }
}
