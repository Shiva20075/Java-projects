package GymMemberShip;
import java.util.ArrayList;
import java.util.List;

public class GymClass {

    List <MemberClass> NewMembers = new ArrayList <>();

    public void addMember (MemberClass peson){

        NewMembers.add(peson);
    }

    public void showMember (){

        for ( int i = 0; i < NewMembers.size(); i++){

            MemberClass person = NewMembers.get(i);

            person.memberInfo();
        }
    }

    public void removeMembers (MemberClass person2){

        for ( int i = 0; i < NewMembers.size(); i++){

            if (NewMembers.get(i).getName().equals(person2.getName())){
                System.out.println("REMOVED MEMBER IS = " + NewMembers.get(i).getName());
                NewMembers.remove(i);
                break;
            }
        }
    }

    public void totalFees(){

        int total = 0;

        for (int i = 0; i < NewMembers.size(); i++){

            total = total + NewMembers.get(i).getFeePaid();

        }

        System.out.println("TOTAL FEE PAYED = " + total );
    }
}
