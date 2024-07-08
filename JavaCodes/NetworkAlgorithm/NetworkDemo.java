/* both files, they can access each other directly if they are in the same directory 
   
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class NetworkDemo {
    public static void main(String[] args) {
        var myFace = new Network(); //or Network myFace
        var gen = new Random();
        
        /* NOT ELEGANT WAY 
        Network.Member alice = myFace.AddMember("Alice");
        Network.Member bob = myFace.AddMember("Bob");
        Network.Member alex = myFace.AddMember("alex");
        Network.Member joey = myFace.AddMember("joey");
        Network.Member daiana = myFace.AddMember("daiana");

        alice.AddFriend(bob);
        alice.AddFriend(alex);
        alice.AddFriend(joey);
        alice.AddFriend(daiana);
        */
        
        // array with names
        String[] memberNames = {"Alice", "Bob", "Alex", "Joey", "Daiana"};

        //create an array of elements of class Network.Member
        ArrayList<Network.Member> listOfMembers = new ArrayList<>();

        for(String name: memberNames) {
            // AddMember returns the object created
            listOfMembers.add(myFace.AddMember(name));
        }

        // a copy of the array
        //ArrayList<Network.Member> copySubsetMembers = new ArrayList<>(listOfMembers);

        //for every person on the Social Network assing some friends
        for (Network.Member mem:listOfMembers) {

            // a copy of the array w/o mem
            ArrayList<Network.Member> copySubsetMembers = new ArrayList<>(listOfMembers);
            copySubsetMembers.remove(mem);

            // reMix the list
            Collections.shuffle(copySubsetMembers);
            //get a random number btw [0-5)
            var numFriends = gen.nextInt(copySubsetMembers.size());
            // select at random a subset of listOfMembers
            ArrayList<Network.Member> subsetMembers = new ArrayList<>(copySubsetMembers.subList(0, numFriends));
            
            //add friend to a person of SocialNetwork
            for(Network.Member friend:subsetMembers){
                mem.AddFriend(friend);
            }
        }
       
        //see everyone and their friend List
        myFace.PrintAllUsers();
        // for(Network.Member m:listOfMembers) {
        //     System.out.println("-".repeat(25));
        //     m.PrintFriendList();
        // }
        
        //select one randomly, to be antisocial
        var numFriends = gen.nextInt(listOfMembers.size());
        var toBeRemoved = listOfMembers.get(numFriends);

        System.out.println(toBeRemoved.name + " wants to be out of myFace, eliminating him");
        toBeRemoved.Deactivate();

        System.out.println("Lets see if the removing was successful");
        myFace.PrintAllUsers();

    }
    
}
