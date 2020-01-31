/**
 * Driver class developed for test cases
 */
public class SortingDriver {
  //main class sorts a random array of numbers and outputs the before and after
   public static void main(String[] args) {
     int num = 10;
     double[] iArray = generateRandomArray(num);
     System.out.println("Array:\n" + display(iArray));

     // sorting algorithm
     InsertionSort iSorter = new InsertionSort();
     iSorter.sort(iArray);
     System.out.println("Sorted Array using QuickSort:\n" + display(iArray));
   }

   //generates a random array of numbers from 0-100
   public static double[] generateRandomArray(int size) {
     double[] array = new double[size];
     for (int i = 0; i < array.length; i++) {
       array[i] = Math.random() * 100.0;
     }
     return array;
   }

   //this method prints out the array into one line
   public static String display(double[] array){
     String result = "[ ";
     for (int i = 0; i < array.length; i++){
       result += array[i] + " ";
     }

     result += "]";

     return result;
   }
 }

/**
 * Insertion sort is a sorting algoritm that compares an item at a certain index, starting from the left,
 * with every index before it, and swaps two numbers until the item is greater than the item before it
 */
class InsertionSort{
    private int SIZE = 0;

    //constructor class
    public InsertionSorter(){}

    /**
     * Abstract class sort inherited from parent class Sorter that sorts an array of numbers
     * @param list randomly generated set of numbers of type double within the range 0 to: 10, 100, 1000, 10000, 100000
     */
    public void sort(double[] list){
        resetOpCount();
        SIZE = list.length;

        for (int i = 1; i < SIZE; i++){ //don't start at 0 bc first index is always assumed to be 'sorted'
            //set the values for the key item we are sorting and the number before it
            int curr = i; int prev = i-1;

            //run through the list from the current index down to the beginning
            for (int j = curr; j >= 0; j--){
                //as long as the number is less than previous keep swapping numbers
                if ((j > 0) && (list[curr] < list[prev])){
                    swap(list, curr, prev);
                    curr -= 1; prev-= 1;

                    countOp();

                //once the number is greater than the previous number stop swapping and look at next index in list
                } else { break; }
            }
        }
    }

    /**
     * Swap methods switches the values of two items at certain indexes
     * @param list rnadomly generated array of numbers
     * @param x first index to be swapping an item with
     * @param y second index to be swapping an item with
     * @return array
     */
    public double[] swap(double[] list, int x, int y){
        double temp = list[y];
        list[y] = list[x];
        list[x] = temp;

        return list;
    }
}
