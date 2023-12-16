

public class Bird {
  private String diet;
  private String color;
  private String status;
  private String name;

  public Bird() {
    this("test","test","test","test");
  }


  public Bird(String name, String status, String diet, String color) {
    this.name = name;
    this.status = status;
    this.diet = diet;
    this.color = color;
  }


  public String toString() {
    return ":Name: " + name + " :Status: " + status + " :Diet: " + diet + " :Color: " + color; 
  }

  public String[] toStringArray() { // this is so i dont have to fetch object properties manually
    String[] returnString = {diet,color,status,name};
    // is there a way to do this in one line?
    return returnString;
  }

//i have no idea if this is the right place to put this however i do not care
  public Bird[] genOrganizedArray() { // generates an array birds from the information provided in the txt files
    
    String[] names = FileReader.toStringArray("names.txt");
    String[] status = FileReader.toStringArray("status.txt");
    String[] colors = FileReader.toStringArray("colors.txt");
    String[] diets = FileReader.toStringArray("diets.txt");
  
    Bird[] birds = new Bird[names.length];
  
      
    for (int i = 0; i < names.length; i++) {
      birds[i] = new Bird(names[i],status[i],diets[i],colors[i]);
    }
  
    return birds;
}





  
  
  
}
