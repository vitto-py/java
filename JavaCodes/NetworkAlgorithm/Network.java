import java.util.ArrayList;

public class Network {
    /* A Network has people and those people have friends
     Network all the people
    */
    public class Member {
        public String name;
        public ArrayList<Member> friends = new ArrayList<>();

        public Member(String name) {
            this.name = name;
        }

        public void AddFriend(Member f) {
            this.friends.add(f);
        }

        public void Deactivate() {
            // remove itself from the Network (outer class)
            Network.this.members.remove(this); //Network.this is optional but it gives you the idea of what that memebers reference 
            
            // remove itself from others people lists
            for (Member m : Network.this.members) {
                m.friends.remove(this); 
            }
        }

        public void PrintFriendList() {
            System.out.println("List of friends of "+this.name);
            for (Member e: friends) {
                
                System.out.println("\tFriend: " + e.name);
            }
        }

        // probably add a NetworkBelongsTo checker 

    }

    private ArrayList<Member> members = new ArrayList<>();

    public Member AddMember(String name) {
        var e = this.new Member(name);
        //this.new is not necessary, You can invoke an inner class constructor on any instance of an outer class:
        this.members.add(e);
        return e; //makes easier to create a list outside this class, look at NetworkDemo.java
    }

    public void PrintAllUsers() {
        System.out.println("ALL USERS");
        for(Member n:members) {
            System.out.println("-".repeat(25));
            n.PrintFriendList();
        }
    }

    //
}