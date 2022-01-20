import java.util.Iterator;
import java.util.LinkedList;

class Pair {
    int key;
    int value;
    
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

class MyHashMap {
    //The current size of the array
    int arraySize = 16;
    
    //The array to store the linkedlist of our pairs, we use linkedlist to chain values together
    //because different indexes can have the same hashcode
    LinkedList<Pair>[] bucket;
    int noOfItems;
    double loadFactor = 0.75;
    
    public MyHashMap() {
        bucket = new LinkedList[arraySize];
        noOfItems = 0;
    }
    
    //The hashcode implementation for mapping keys to index
    int hashCode(int index){
        return index % arraySize;
    }
    
    //This check if the current number of items has passed the load factor
    //in this case it is 0.75, so 3/4 of the arraysize
    boolean overload() {
        double currentLoad = (double) noOfItems / (double) arraySize;
        return currentLoad > loadFactor;
    }
    
    //In the case of an overload, we increase the number of values that can be stored in the         //array. Then a rehasing is done, create an array with the new size and transfer all the
    //items in the old array to the new one
    void rehash() {
       LinkedList<Pair>[] temp = bucket;
        arraySize *= 2;
        
        bucket = new LinkedList[arraySize];
        for (LinkedList<Pair> lp: temp){
            if(lp == null) continue;
            for(Pair pair: lp) {
                put(pair.key, pair.value);
            }
        }
    }
    
    public void put(int key, int value) {
        //Here lies the main feature of this approach
        
        //To add a value, with it's key to our made-up hashmap
        //Since, we're using the an array to store a list of the values
        //we'll hash the key, using the hashCode(method). This will give like a
        //resolution for mapping a key to one index in the array so we can store the
        //pair of values there
        
        int index = hashCode(key);
        Pair pair = new Pair(key, value);
        
        //Here, we're just doing a routine adding, 
        //Each item in the array is a linkedlist so we isolate tje current linedlist for the
        //index and do the magic
        LinkedList<Pair> foundLinkedList =  bucket[index];
        
        //We check if the value is null, if it is initialize a new LikedList and add
        //it's first pair
        if(foundLinkedList == null){
            bucket[index] = new LinkedList<Pair>();
            bucket[index].add(pair);
            
            //increase the number of items in the array
            noOfItems++;
            
            //check if the overload is passed i.e the loadfactor has been exceeded
            if(overload()){
                rehash();
            }
        } else {
            //In this case this index corrresponded to the hashcode
            boolean found = false;
            for (Pair p: bucket[index]){
                if(p.key == pair.key){
                    
                    p.value = pair.value;
                    
                    found = false;
                    break;
                }   
            }
            
            if(!found){
                bucket[index].add(pair);
                
                noOfItems++;
                if(overload()){
                    rehash();
                }
            }
        }
    }
    
    //We're retriveing the array here, get the corresponding array index by find the
    //hashcode,
    
    //If the hashcode leads to a index in the array in which there's no value
    //i.e null return -1;
    
    //Cycle through the linkedlist and find a pair that corresponds whose key correspond
    //to the one the user is asking for
    
    //if no one is found return -1;
    //if one is found return the value
    public int get(int key) {
        int index = hashCode(key);
        LinkedList<Pair> value =  bucket[index];
        
        if(value == null){
            return -1;
        } else {
            int gottenValue = -1;
                
            for(Pair pair: bucket[index]){
                if(pair.key == key){
                    gottenValue = pair.value;
                    break;
                }
            }
                
            return gottenValue;
        }
    }
    
    //We're removing the value here
    
    //get the corresponding array index by find the
    //hashcode, get the value corresponding to the array[hashCode];
    
    //If the value is null, nothing will be done
    //If the values is not null, use the `Iteration method` below to
    //remove the value from the linkedlist
    public void remove(int key) {
        int index = hashCode(key);
        LinkedList<Pair> value =  bucket[index];
        
        if(value != null){
            //This is the way to remove a value from a linkedlist successfull
           Iterator<Pair> iter = value.iterator();
            while(iter.hasNext()){
                if(iter.next().key==key){
                    iter.remove();
                }
            }
        }
    }
}
