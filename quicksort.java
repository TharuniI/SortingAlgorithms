/**
 * Driver class developed for test cases
 */
public class SortingDriver {
  //main class sorts a random array of numbers and outputs the before and after
   public static void main(String[] args) {
     int num = 10;
     double[] qArray = generateRandomArray(num);
     System.out.println("Array:\n" + display(qArray));

     // sorting algorithm
     QuickSorter qSorter = new QuickSorter();
     qSorter.sort(qArray);
     System.out.println("Sorted Array using QuickSort:\n" + display(qArray));
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
 * QuickSorter is a sorting method inherited from the Sorter class
 * this sorting method seperates the list into less than pivot and greater than until there is a
 * single item in the list, then it sorts the items and combine them together again
 */
class QuickSorter {
    //variable decleration
    private double pivot;

    //constructor
    public QuickSorter(){}

    /**
     * Abstract class sort inherited from class Sorter
     * @param list randomly generated set of numbers of type double within the range 0 to: 10, 100, 1000, 10000, 100000
     */
    public void sort(double[] list){
        int start = 0;
        int end = list.length-1;
        //initialize the start and end of a list and pass through as parameters for the sort method
        sortList(list, start, end);
    }

    /**
     * SortList seperates list to less than and greater than according to pivot
     * @param list randomly generated list of
     * @param start
     * @param end
     */
    public void sortList(double[] list, int start, int end){
        //run as long as the length is one or greater
        if (start < end){
            int partition = split(list, start, end);

            //sort before and after partition
            sortList(list, start, partition-1);
            sortList(list, partition+1, end);

        }
    }

    /**
     * Split function partitions the list according to the pivot
     * @param list randomly generated set of numbers
     * @param start beginning index of list
     * @param end last index of list
     * @return int
     */
    public int split(double[] list, int start, int end){
        //pivot is always set to the end index
        pivot = list[end];

        int x = (start-1);
        //runs for the length of the list after every partition
        for (int i = start; i < end; i++){
            //if the item at the current index is less than the pivot then swap it with x
            if (list[i] < pivot){
                x++;
                swap(list, x, i);

            }
        }
        swap(list, x+1, end);
        return x+1;
    }

    /**
     * Swap method switches the numbers at two indexes
     * @param list randomly generated array of doubles
     * @param y first index to swap an item with
     * @param z second index to swap an item with
     * @return array
     */
    public double[] swap(double[] list, int y, int z){
        double temp =  list[y];
        list[y] = list[z];
        list[z] = temp;

        return list;
    }
}
