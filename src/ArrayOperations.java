import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayOperations {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter name of file containing your data:");
		String file = stdin.next();
		ArrayList<Integer> data = readFromFile(file);
		printArray(data);

		System.out.println("\nThe average is: " + average(data));
		
		System.out.println("The smallest element is: " + smallest(data));
		System.out.println("The index of the smallest element is: " + getMinIndex(data));
		System.out.println("The largest element is: " + largest(data));
		System.out.println("The index of the largest element is: " + getMaxIndex(data));
		System.out.println("The index of the 2nd largest element is: " + secondMaxIndex(data));

		int numPrimes = 0;
		System.out.print("The prime numbers are: ");
		for (int i = 0; i < data.size(); i++){
			if (isPrime(data.get(i))){
				numPrimes++;
				System.out.print(data.get(i) + " ");
			}// end if
		}// end for i

		System.out.println("\nThe number of primes is: " + numPrimes);

		data = sortUp(data);
		System.out.print("The sorted array in non-decreasing order is:");
		printArray(data);

		ArrayList<Integer> reverseList= new ArrayList<Integer>();
		reverseList = reverse(data);
		System.out.print("\nThe reverse of the sorted array is:");
		printArray(reverseList);

		stdin.close();
	}
	
	public static ArrayList<Integer> readFromFile(String fileName)
            throws FileNotFoundException
	{
		File f = new File(fileName);
		Scanner fileIn = new Scanner (f);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (fileIn.hasNextInt()){ // quit when you encounter ¡®Q¡¯
		int num = fileIn.nextInt();
		list.add(num);
		
		}// end while
		fileIn.close();
		return list;
	} // end readFromFile

	public static int smallest(ArrayList<Integer> list) {
		int smallest = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < smallest) {
				smallest = list.get(i);
			}
		}
		return smallest;
	}
	
	public static int getMinIndex(ArrayList<Integer> list) {
		int smallest = list.get(0);
		int minIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < smallest) {
				smallest = list.get(i);
				minIndex = i;
			}
		}
		return minIndex + 1;
	}
	
	public static int largest(ArrayList<Integer> list) {
		int largest = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > largest) {
				largest = list.get(i);
			}
		}
		return largest;
	}
	
	public static int getMaxIndex(ArrayList<Integer> list) {
		int largest = list.get(0);
		int maxIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > largest) {
				largest = list.get(i);
				maxIndex = i;
			}
		}
		return maxIndex + 1;
	}
	
	public static int secondMaxIndex(ArrayList<Integer> list) {
		int maxIndex = getMaxIndex(list);
		ArrayList<Integer> data = list;
		data.remove(maxIndex - 1);
		int secondMaxIndex = getMaxIndex(data);
		
		if (secondMaxIndex < maxIndex)
			return secondMaxIndex;
		else
			return secondMaxIndex + 1;
	}
	
	public static float average(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum/list.size();
	}
	
	public static void printArray(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	public static ArrayList<Integer> sortUp(ArrayList<Integer> list) {
		ArrayList<Integer> data = list;
		ArrayList<Integer> sort = new ArrayList<Integer>();
		while (data.size() != 0) {
			sort.add(smallest(data));
			data.remove(getMinIndex(data) - 1);
		}
		return sort;
	}
	
	public static ArrayList<Integer> reverse(ArrayList<Integer> list) {
		ArrayList<Integer> reverse = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			reverse.add(list.get(list.size() - i - 1));
		}
		return reverse;
	}
	
	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if ( num % i == 0)
				return false;
		}
		return true;
	}
}
