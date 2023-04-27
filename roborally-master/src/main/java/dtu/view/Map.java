package dtu.view;

import java.util.ArrayList;

import javax.management.relation.RelationSupportMBean;

public enum Map {
    map1("Empty",1,new String[][]{{"T","T","T","T","T","T","T","T","T","T"},
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

    map2("mapname1",2,new String[][]{{"T","T","HT","T","T","T","T","T","T","T"},
                                                {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
                                                {"T","T","HT","T","T","T","T","T","T","T"},
                                                {"T","T","T","T","T","C 1","T","T","T","T"},
                                                {"T","T","BT 4 1","BT 4 1","BT 4 1","BT 4 1","BT 4 1","T","T","T"},
                                                {"T","T","BT 2 1","BT 2 1","BT 2 1","BT 2 1","BT 2 1","T","T","T"},
                                                {"T","T","BT 1 1","BT 4 1","LT 4","T","T","T","T","T"},
                                                {"T","T","T","T","T","T","T","T","C 3","T"},
                                                {"C 2","T","HT","BT 1 2","BT 4 2","T","T","T","T","T"},
                                                {"T","T","HT","T","T","T","T","T","T","T"},
                                                // Start Field
                                                {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
                                                {"T","S","WT 4","T","S","S","T","WT 2","S","T"},
                                                {"S","T","T","S","T","T","S","T","T","S"},});
	
	
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
