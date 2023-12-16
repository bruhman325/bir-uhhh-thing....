import java.util.Scanner;

public class UserStory {

  private Bird[] organizedArray;
  
  public UserStory(Bird[] organizedArray) {
    this.organizedArray = organizedArray;
  }

  public Bird[] getAllData() {
    return organizedArray;
  }

  public int GetIndexInArray(String[] array, String key) {
    for (int i = 0; i < array.length; i++) { 
      //System.out.println(array[i]);
     // System.out.println(key);
      if (array[i] != null) {
        if (array[i].equals(key)) return i; 
      }
      
    }
    return -1;
  }

  public Bird[] filter(String key, String value, Bird[] currentArray) { // filters currentArray by key and value 
    Bird[] returnArray = new Bird[currentArray.length];

    String[] possibleIndexes = {"diet","color","status","name"};

    int keyIndex = GetIndexInArray(possibleIndexes,key); 

    
    for (int i = 0; i < currentArray.length; i++) {
      Bird currentBird = currentArray[i];
      if (currentBird != null) {
        if (currentBird.toStringArray()[keyIndex].toLowerCase().equals(value)) returnArray[i] = currentBird;
      }
    }

    System.out.println(readArray(returnArray));

    return returnArray;
    
  }

  public String toString() { // i hate htis so much
    String[] keys = new String[organizedArray.length];
    int[] values = new int[organizedArray.length];
    String[] valueType = new String[organizedArray.length];
    String[] possibleIndexes = {"diet","color","status","name"};

    String returnString = "";

    for (int index = 0; index <  organizedArray.length; index++) { 
      String[] info = organizedArray[index].toStringArray();
      info[3] = null; // delete names
      for (int i = 0; i < info.length; i++) {
        int keyIndex = GetIndexInArray(keys, info[i]);
        if (info[i] != null) {
          if (keyIndex == -1){
            keys[index] = info[i];
            valueType[index] = possibleIndexes[i];
            values[index] += 1;
          } else {
            values[keyIndex] += 1;
          }
        }
      }
    }

    

    for (int index = 0; index < keys.length; index++) {
      if (keys[index] != null) {
        returnString += " :" + valueType[index] + ": " + keys[index] + " :amount: " + values[index] + "\n";
      }
    }

    
    return returnString;
  }


  public String readArray(Bird[] array) {
    String returnString = "";
    for (Bird i : array) {
      if (i != null) {
        returnString += i.toString() + "\n";
      }
    }
    return returnString;
  }


 



  
}
