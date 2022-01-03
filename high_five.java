import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Given a list of the scores of different students, items, 
where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.

Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average.
 Sort result by IDj in increasing order.

A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.

    Example 1:

    Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
    Output: [[1,87],[2,88]]
    Explanation: 
    The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
    The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
        
    Example 2:

    Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
    Output: [[1,100],[7,100]]

*/

class HighFiveSolution {
    
    HashMap<Integer,List<Integer>> hm=new HashMap<Integer,List<Integer>>();    
    
    //With some help, I solved it using a hashmap
    //I made the hashmap store a key-value pair of integer and listOfInteger, the key will correspond to the ID of the student
    // the listOfInteger will correspond to the scores

    //So i went through the multidimensional array, for every row, i got too, every array there will only have two values obviously
    //the 0th value will be the id and the 1th value will be the score of the student

    public int[][] highFive(int[][] items) {
        
        for(int i = 0; i< items.length; i++){
            int key = items[i][0];
            int value = items[i][1];
            
            List<Integer> list = hm.get(key);
            //so when i get the key, i check the hashmap if there's a key(using the 0th value), value that already exists
            //if the value already exists, i'll take the list, add the score to it then update the value of the id
            if(list == null) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(value);
                hm.put(key, newList);
            } else {
                list.add(value);
                hm.put(key, list);
            }
        }
        
        //I created an array that will contain the IDs and the average score
        int[][] array = new int[hm.keySet().size()][2];
        
        //Here, i'm going through each entry in the hashmap, getting key and values
        //the values here are Lists so, i convert them to an array so they can be sorted by the Arrays.sort utility function

        //After it's done, i converted the sorted array back to a list using Arrays.asList() the update the ID in the hashmap
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
        
        //Here, I create an array from the list of keys in the hashmap, this array contains the keys i.e ids of the student
        //So i get a key, access the hashmap which now contains sorted scores

        //Since the scores are sorted from least to highest, i start from the end of the list
        //Take values until i reach the fifth values from the right, so that means i have taken the five highest
        //values

        //if the size of the list isn't greater than 5, just get the average either way
        //do the rest!
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
