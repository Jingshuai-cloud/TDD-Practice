package SiteClearSimulator;

import java.util.HashMap;

public class Budollzer {
    private HashMap<String, String> position = new HashMap<>();

    public Budollzer(){
        position.put("X", "-1");
        position.put("Y", "0");
        position.put("facing","EAST");
    }

    public void turn(String command) {
        HashMap<String, Integer> turnIndex = new HashMap<>();
        turnIndex.put("left", 0);
        turnIndex.put("right", 1);
        int direction = turnIndex.get(command);

        HashMap<String, String[]> nextFacing = new HashMap<>();
        nextFacing.put("NORTH", new String[]{"WEST", "EAST"});
        nextFacing.put("EAST", new String[]{"NORTH", "SOUTH"});
        nextFacing.put("SOUTH", new String[]{"EAST", "WEST"});
        nextFacing.put("WEST", new String[]{"SOUTH", "NORTH"});

        String facing = position.get("facing");
        String newFacing = nextFacing.get(facing)[direction];

        this.position.replace("facing", newFacing);
    }

    public HashMap<String,String> getPosition(){
        return position;
    }

    public void advance(int step) {
        Integer[] caculateNext = getNextPositionCaculateIndex();
        int newX = 0, newY =0;
        for(int i = 0; i < step; i++){
            newX = Integer.parseInt(position.get("X")) + caculateNext[0];
            newY = Integer.parseInt(position.get("Y")) + caculateNext[1];
            position.replace("X", String.valueOf(newX));
            position.replace("Y", String.valueOf(newY));
        }



    }

    private Integer[] getNextPositionCaculateIndex(){
        HashMap<String, Integer[]> nextBlock = new HashMap<>();
        nextBlock.put("NORTH", new Integer[]{0, -1});
        nextBlock.put("SOUTH", new Integer[]{0, 1});
        nextBlock.put("WEST", new Integer[]{-1, 0});
        nextBlock.put("EAST", new Integer[]{1, 0});

        String facing = this.position.get("facing");
        Integer[] nextPositionIndex = nextBlock.get(facing);
        return nextPositionIndex;
    }
}
