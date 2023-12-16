import java.util.Scanner;


public class DataRunner {
  public static void main(String[] args) {

    Bird starter = new Bird();
    UserStory bruh = new UserStory(starter.genOrganizedArray());

    Scanner input = new Scanner(System.in);

    Bird[] currentArray = bruh.getAllData();


    while (true) {
      if (input.hasNextLine()) {
        String nonFiltered = input.nextLine();
        String[] command = nonFiltered.split(":");
        
        if (command[0].equals("filter") && command.length == 3) {
          String key = command[1].toLowerCase();
          String value = command[2].toLowerCase();
          currentArray = bruh.filter(key,value,currentArray);
        }


        if (nonFiltered.equals("clearfilter")) {
          currentArray = bruh.getAllData();
          System.out.println("filter cleared");
        }


        if (nonFiltered.equals("totalstats")) {
          System.out.println(bruh.toString());
        }
        
        if (nonFiltered.equals("getall")) {
          System.out.println(bruh.readArray(bruh.getAllData()));
        }

        if (nonFiltered.equals("help")) {
          // i am not writing the rest of this
          System.out.println("Commands: \n filter \n Description: adds a filter to this birds you want to see using a key and value \n Examples: \n filter:diet:fish \n filter:color:grey \n filter:status:least concern \n filter:name:bald eagle \n \nclearfilter \n Descripton: clears your current filters \n Examples\n clearfilter");
        }
        

        
      }
    }
    
    


    
    
    
  }
}
