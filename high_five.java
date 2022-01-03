import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HighFiveSolution {
    
    HashMap<Integer,List<Integer>> hm=new HashMap<Integer,List<Integer>>();    
    
    public int[][] highFive(int[][] items) {
        
        for(int i = 0; i< items.length; i++){
            int key = items[i][0];
            int value = items[i][1];
            
            List<Integer> list = hm.get(key);
            if(list == null) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(value);
                hm.put(key, newList);
            } else {
                list.add(value);
                hm.put(key, list);
            }
        }
        
        int[][] array = new int[hm.keySet().size()][2];
        
        for(Map.Entry m : hm.entrySet()){    
            System.out.println(m.getKey()+" "+m.getValue());
            List<Integer> fresh = (List<Integer>)m.getValue();
            Integer[] newArray = fresh.toArray(new Integer[0]);
            
            Arrays.sort(
                newArray, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                }
                );
            
            List<Integer> newList = Arrays.asList(newArray); 
            int key = (int)m.getKey();
            hm.put(key, newList);
        }
        
        Integer[] newArray = hm.keySet().toArray(new Integer[0]);
        for(int i = 0; i < newArray.length; i++){  
            // System.out.println("sorted: " + m.getKey()+" "+m.getValue());
            List<Integer> list = hm.get(newArray[i]);
            int average = 0;
            int listSize = list.size();
            for (int k = listSize - 1; k >= 0; k--){
                average += list.get(k);
                if(k == (listSize -5)){
                    average /= 5;
                    break;
                } else if(k == 0){
                    average /= 5;
                    break;
                }
            }
            System.out.println("Average: " + average);
            array[i][0] = newArray[i];
            array[i][1] = average;
            
        }
        
        
        return array;
    }
}
