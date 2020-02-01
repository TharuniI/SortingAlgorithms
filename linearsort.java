import java.util.*;

public class Main {
    public static void main(String[] args) {
	// write your code here
        String[] origNumbers = {"0011", "1001", "1000", "0111", "0101"};
        List<String> numbers = new ArrayList<>();
        for (String num: origNumbers) { numbers.add(num); }
        int numDigits = 4;

        radixSort(numbers,numDigits);
    }

    public static void radixSort(List<String> binaryList, int len){
        //create a nested for loop by len by len
        //add to buckets return and then update array
        //done

        print(binaryList);//prints the original before sorting

        int numDigits = len;
        Buckets bucket = new Buckets();
        int size = binaryList.size();

        for(int i=0;i<numDigits;i++){
            len--;
            for(int j=0;j<size;j++){

                String currentBinary = binaryList.get(j);
                char currentSig = currentBinary.charAt(len);

                if(currentSig=='0'){
                    bucket.addZero(currentBinary);
                }
                else{
                    bucket.addOne(currentBinary);
                }
            }
            //reset some var
            binaryList = bucket.getAllInOrder();
            bucket = new Buckets();
            print(binaryList);
        }
    }

    public static void print(List<String> x){
        String result = "[ ";
        for(int i=0;i<x.size();i++){
            result += x.get(i);
            result += " ";
        }
        result += "]";
        System.out.println(result);
    }
}


public class Buckets {
    private List<String> zeroBucket;
    private List<String> oneBucket;

    public Buckets() {
        zeroBucket = new ArrayList<>();
        oneBucket = new ArrayList<>();
    }

    public void addZero(String newValue) {
        zeroBucket.add(newValue);
    }

    public void addOne(String newValue) {
        oneBucket.add(newValue);
    }

    public List<String> getAllInOrder() {
        List<String> result = new ArrayList<>();
        for (String val: oneBucket) {
            result.add(val);
        }
        for (String val: zeroBucket) {
            result.add(val);
        }
        return result;
    }
}
