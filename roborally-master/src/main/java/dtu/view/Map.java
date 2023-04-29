package dtu.view;

import java.util.ArrayList;
 
import javax.management.relation.RelationSupportMBean;

public enum Map {
    map1("Empty",1,new String[][]{   
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","C 1","T","T","T","C 2 ","T","C 3","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                
                                                // Start Field
                                                {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
                                                {"AT  ","S","WT 4","T","S","S","T","WT 2","S","T"},
                                                {"S","T","T","S","T","T","S","T","T","S"},}),

    map2("Black holes",3,new String[][]{ {"T   ","T     ","T     ","T     ","T   ","T","T     ","T      ","T    ","T   "},  
                                                    {"T   ","BT 3 1","BT 3 1","BT 4 1","C 1   ","T","BT 2 1","BT 3 1","BT 3 1","T   "},
                                                    {"LT 4","BT 2 1","HT    ","BT 4 1","T   ","T","BT 2 1","HT    ","BT 4 1","LT 2"},
                                                    {"T   ","BT 2 1","BT 1 1","BT 1 1","T   ","T","BT 1 1","BT 1 1","BT 4 1","T   "},
                                                    {"T   ","T     ","T     ","LT 2  ","T   ","T","LT 4  ","T     ","T   ","T     "},
                                                    {"T "," C 3    ","WT 3  ","LT 2  ","RT  ","T","LT 4  ","WT 3  ","HT  ","T     "},
                                                    {"T   ","T     ","T     ","T     ","T   ","T","T     ","T     ","T   ","T     "}, 
                                                    {"C 1 ","T     ","T     ","LT 4  ","AT  ","T","LT 2  ","T     ","T   ","T     "},
                                                    {"T   ","T     ","T     ","T     ","T   ","T","T     ","T     ","T   ","T     "},
                                                    {"T   ","T     ","T     ","T     ","T   ","T","T     ","T     ","C 2 ","T     "},
                                                    // Start Field
                                                    {"T  ","T     ","T     ","BT 1 1","WT 1","WT 1","BT 1 1","T   ","T","T"},
                                                    {"T  ","S     ","WT 4  ","T     ","S   ","S   ","T     ","WT 2","S","T"},
                                                    {"S  ","T     ","T     ","S     ","T   ","T   ","S     ","T   ","T","S"},}),
    
    map3("The Pit",2,new String[][]{
                                    {"T","T","T","WT 1","T","T","T","T ","T","T"},
                                    {"T","RT","T","T","C 1","T","T","T ","RT","T"},
                                    {"T","T","T","LT 3","T","T","BT 3 1","T ","T","T"},
                                    {"T","T","BT 2 1","T","HT","HT","T","T ","T","T"},
                                    {"T","T","T 4","HT","HT","HT","HT ","WT 2","AT","T"},
                                    {"WT 4","LT 2","T ","HT","HT","HT","HT ","WT 2","C 3","T"},
                                    {"T","T","T","T","HT","HT","T","T ","T","T"},
                                    {"T","AT","T","T","T","T","T","T ","T","T"},
                                    {"T","T","T","T","T","C 2","T","T ","T","T"},
                                    {"T","T","WT 1","T","T","T","T","WT 1","T","T"},

                                    {"S","T ","T","BT 1 1","S","S","BT 1 1","T","T","S"},
                                    {"T","BT 1 2","T","S","T","T","S","T","BT 1 2","T"},
                                    {"T ","S","WT 3","T","T","T","T","WT 3","S","T"},}),
    map4("Parallel Parking",4,new String[][]{ 
                                    {"T","T","T","T","T","T","T","T","T","T"},
                                    {"T","RT","T","T","T","C 1","T","T","T","T"},
                                    {"T","T","T","T","WT 1","WT 1","T","AT","T","T"},
                                    {"T","T","T","T","T","T","T","T","T","T"},
                                    {"T","T","HT","BT 4 2","T","T","BT 2 2","HT","T","T"},
                                    {"T","T","T","T","C 2","T","T","T","T","T"},
                                    {"T","T","T","T","T","RT","T","T","T","T"},
                                    {"LT 4","HT","T","HT","T","T","HT","T","HT","LT 2"},
                                    {"T","HT","T","HT","T","T","HT","T","HT","T"},
                                    {"T","AT","T","WT 1","T","T","WT 1","T","AT","T"},
                                    // Start Field
                                    {"T","T","S","LT 3","T","T","LT 3","S","T","T"},
                                    {"S","S","T","T","T","C 3","T","T","S","S"},
                                    {"T","T","T","T","S","S","T","T","T","T"}}),
    map5("Arround the World",3,new String[][]{
                                    {"T","T","T","T","LT 1","T","BT 2 1","BT 2 1","BT 3 1","HT"},
                                    {"T","BT 2 1","BT 3 1","T","T","T","BT 1 1","C 2","BT 3 1","T"},
                                    {"T","BT 1 1","BT 4 1","T","WT 3","T","BT 1 1","BT 4 1","BT 4 1","T"},
                                    {"T","T","RT","T","T","T","T","T","T","T"},
                                    {"T","T","WT 2","BT 2 2","BT 2 2","BT 2 2","BT 3 2","T","T","T"},
                                    {"LT 4","T","WT 2","BT 1 2","T","C 1","BT 3 2","WT 4","RT","T"},
                                    {"T","T","T","BT 1 2","HT","T","BT 3 2","WT 4","T","LT 2"},
                                    {"T","AT","T","BT 1 2","BT 4 2","BT 4 2","BT 4 2","T","T","T"},
                                    {"T","C 3","T","T","T","T","AT","T","T","HT"},
                                    {"T","T","T","T","T","T","T","T","T","T"},
                                    // Start Field
                                    {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
                                    {"T","S","WT 4","T","S","S","T","WT 2","S","T"},
                                    {"S","T","T","S","T","T","S","T","T","S"},

    }),
    map6("Highway to Hell",5,new String[][]{
                                    {"T","T","WT 1","T","T","LT 1","T","T","T","T"},
                                    {"T","RT","T","T","T","T","T","T","C 2","T"},
                                    {"BT 2 2","BT 2 2","BT 2 2","BT 2 2","BT 2 2","BT 2 2","BT 2 2","BT 2 2","BT 2 2","BT 2 2"},
                                    {"T","WT 2","LT 3","AT","T","T","HT","T","T","T"},
                                    {"BT 4 1","BT 4 1","BT 4 1","BT 4 1","BT 4 1","BT 4 1","BT 4 1","BT 4 1","BT 4 1","BT 4 1"},
                                    {"LT 4","T","T","WT 2","C 1","T","WT 4","AT","T","LT 2"},
                                    {"BT 2 1","BT 2 1","BT 2 1","BT 2 1","BT 2 1","BT 2 1","BT 2 1","BT 2 1","BT 2 1","BT 2 1"},
                                    {"T","T","HT","T","T","T","C 3","WT 2","RT","T"},
                                    {"BT 4 2","BT 4 2","BT 4 2","BT 4 2","BT 4 2","BT 4 2","BT 4 2","BT 4 2","BT 4 2","BT 4 2"},
                                    {"T","T","T","T","T","T","T","T","T","T"},

                                    // Start Field
                                    {"T","S","T","T","T","S","T","T","S","S"},
                                    {"T","T","T","S","T","T","S","T","T","T"},
                                    {"T","T","S","T","T","T","T","S","T","T"},

}),
    map7("Laser Tag",1,new String[][]{   
        {"T","T","T","T","WT 2","WT 1","RT","HT","T","T"},
        {"T","T","WT 3","WT 2","T","T","WT 2","T","C 3","T"},
        {"T","C 1","WT 2","AT","T","HT","T","BT 4 1","WT 3","T"},
        {"WT 3","WT 3","BT 2 1","WT 2","WT 3","LT 3","T","LT 4","T","WT 2"},
        {"T","RT","WT 1","T","T","T","WT 3","T","HT","T"},
        {"WT 2","T","LT 2","T","HT","T","WT 2","T","T","WT 4"},
        {"WT 2","WT 2","T","T","HT","AT","T","T","T","LT 4"},
        {"T","WT 3","T","WT 3","T","T","WT 2","BT 1 2","WT 3","BT 4 1"},
        {"WT 2","T","BT 1 2","T","WT 3","WT 4","WT 3","T","WT 2","T"},
        {"WT 2","T","WT 2","T","T","WT 4","T","C 2","T","RT"},
        
        // Start Field
        {"T","T","S","T","WT 2","S","T","T","S","T"},
        {"T","S","T","T","S","WT 4","T","S","T","T"},
        {"T","T","T","S","WT 2","T","S","T","T","T"},}
        
);

                                    


    

    

	
	
	private String Name;
    private String[][] map;
    private int level;

    public String getName(){
        return Name;
    }
    public String[][] getMap(){
        return map;
    }
    public int getLevel(){
        return level;
    }
 
	private Map(String Name,int Level,String[][] map) {
		this.Name = Name;
        this.map = map;
        this.level = Level;
	}

    public static ArrayList<String> getmapNames(){
        ArrayList<String> names = new ArrayList<String>();
        for (Map m : Map.values()){
            names.add(m.getName());
        }
        return names;
    }

    public static String[][] getMapByName(String Name){
        
        for (Map m : Map.values()){
            if (m.getName().equals(Name)){
                return m.getMap();
            } 
        }
        return map1.getMap();
    }
}
