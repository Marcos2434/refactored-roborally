package dtu.view;

import java.util.ArrayList;

import javax.management.relation.RelationSupportMBean;

public enum Map {
    map1("Empty",1,new String[][]{   {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","C 2","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","C 1","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","C 3","T"},
                                                {"T","T","T","T","T","T","T","T","T","T"},
                                                // Start Field
                                                {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
                                                {"T","S","WT 4","T","S","S","T","WT 2","S","T"},
                                                {"S","T","T","S","T","T","S","T","T","S"},}),

    map2("Black holes",2,new String[][]{ {"T   ","T     ","T     ","T     ","T   ","T","T     ","T      ","T    ","T   "},  
                                                    {"T   ","BT 3 1","BT 3 1","BT 4 1","T   ","T","BT 2 1","BT 3 1","BT 3 1","T   "},
                                                    {"LT 4","BT 2 1","HT    ","BT 4 1","T   ","T","BT 2 1","HT    ","BT 4 1","LT 2"},
                                                    {"T   ","BT 2 1","BT 1 1","BT 1 1","T   ","T","BT 1 1","BT 1 1","BT 4 1","T   "},
                                                    {"T   ","T     ","T     ","LT 2  ","T   ","T","LT 4  ","T     ","T   ","T     "},
                                                    {"C 3 ","T     ","WT 3  ","LT 2  ","RT  ","T","LT 4  ","WT 3  ","HT  ","T     "},
                                                    {"T   ","T     ","T     ","T     ","T   ","T","T     ","T     ","T   ","T     "}, 
                                                    {"C 1 ","T     ","T     ","LT 4  ","AT  ","T","LT 2  ","T     ","T   ","T     "},
                                                    {"HT  ","T     ","T     ","T     ","T   ","T","T     ","T     ","T   ","T     "},
                                                    {"T   ","T     ","T     ","T     ","T   ","T","T     ","T     ","C 2 ","T     "},
                                                    // Start Field
                                                    {"T  ","T     ","T     ","BT 1 1","WT 1","WT 1","BT 1 1","T   ","T","T"},
                                                    {"T  ","S     ","WT 4  ","T     ","S   ","S   ","T     ","WT 2","S","T"},
                                                    {"S  ","T     ","T     ","S     ","T   ","T   ","S     ","T   ","T","S"},}),
    
    map3("The Pit",3,new String[][]{{"T","T","T","T","T","T","T","T ","T","T"},
                                    {"T","T","T","T","C 1","T","T","T ","T","T"},
                                    {"T","T","T","T","T","T","BT 3 1","T ","T","T"},
                                    {"T","T","T","T","HT","HT","T","T ","T","T"},
                                    {"T","T","T 4","HT","HT","HT","HT ","WT 2","T","T"},
                                    {"WT 4","LT 2","T ","HT","HT","HT","HT ","WT 2"," C 3","T"},
                                    {"T","T","T","T","HT","HT","T","T ","T","T"},
                                    {"T","T","T","T","T","T","T","T ","T","T"},
                                    {"T","T","T","T","T","C 2","T","T ","T","T"},
                                    {"T","T","WT 1","T","T","T","T","WT 1","T","T"},

                                    {"S","T ","T","BT 1 1","S","S","BT 1 1","T","T","S"},
                                    {"T","BT 1 2","T","S","T","T","S","T","BT 1 2","T"},
                                    {"T ","S","WT 3","T","T","T","T","WT 3","S","T"},});


    

    

	
	
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
