import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Ready Freddy", new Contact("Ready Freddy", "+1 716 332 7173"));
        contacts.put("Sandy Randy", new Contact("Sandy Randy", "+1 271 721 2998"));
        contacts.put("Sammy Hammy", new Contact("Sammy Hammy", "+1 847 723 1122"));
        contacts.put("Monkey Luffy", new Contact("Monkey Luffy", "+1 382 747 9293"));
        
        Contact retrieved = contacts.get("Ada Lovelace");
        if (retrieved == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(retrieved);
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values()); 
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("=== All Contacts ===");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println(sorted.get(i));
        }

    } 
}