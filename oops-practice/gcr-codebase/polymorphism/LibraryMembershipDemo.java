public class LibraryMembershipDemo {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentLibraryMember("Alice", "S1001"),
            new FacultyLibraryMember("Dr. Bob", "F2001"),
            new GuestLibraryMember("Charlie", "G3001")
        };

        for (LibraryMember member : members) {
            member.printMemberDetails();
            System.out.println("Fine for 5 overdue days: " + member.calculateFine(5));
            System.out.println();
        }

        String searchId = "F2001";
        System.out.println("Searching for member ID: " + searchId);
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(searchId)) {
                member.printMemberDetails();
                break;
            }
        }
    }
}

abstract class LibraryMember {
    private String memberName;
    private String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public abstract double calculateFine(int overdueDays);

    public void printMemberDetails() {
        System.out.println("Member Name: " + memberName);
        System.out.println("Member ID: " + memberId);
    }
}

class StudentLibraryMember extends LibraryMember {
    public StudentLibraryMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 1.0;
    }
}

class FacultyLibraryMember extends LibraryMember {
    public FacultyLibraryMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 0.5;
    }
}

class GuestLibraryMember extends LibraryMember {
    public GuestLibraryMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }
}
