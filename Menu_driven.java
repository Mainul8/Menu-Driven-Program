import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

class Menu_driven
{
	static Scanner userInput = new Scanner(System.in);
	static void sequential_search(long arr[],int n,long key)
	{
		int count1 = 0;
		int index = 0;
		while(index < n && arr[index] != key)
		{
			index++;
			count1++;
		}

		if (index != n)
			System.out.println("Element : "+key+" found at index : "+index);
		else
			System.out.println("Element : "+key+" not found");

		System.out.println("\nTime Complexity (Number of times basic operation is ): "+count1);
	}
	
	static int binary_search(long arr[],int start,int end,long key,int count2)		//passing formal arguments in the Recursive Binary search function
	{
		count2++;			        //counting the no of execution time or time complexity
		
		int mid=(start + end)/2;	//finding Middle Position
		
		if(start>end) {				//When the array ends - Base Condition
			System.out.println("\nThe number of times the Loop will be execute is:"+count2);
			return -1;				//returning from the function when the key is not found in the Array
		}		                    //end of if
		
		else if(key==arr[mid]) {            //when key value is found - Base condition
			System.out.println("The number of times the Loop will be execute is:"+count2);
			return mid;			//returning from the function when the Key is found at the middle Position
		}		//end of if else
			
		else if(key>arr[mid]) {
			return binary_search(arr,mid+1,end,key,count2);        //recursive call for the condition if Key is greater than Middle position
		}		//end of if else
			
		else {
			return binary_search(arr,start,mid-1,key,count2);	//recursive call for the condition if Key is less than Middle position
		}                    //end of else
	}		//end of binary search Recursive function
	
	//bubble sort in non decreasing order
	static void bubbleSorting(long a[]) {
		int n = a.length;
		long temp;
		for(int i=0;i<n-1;i++) {
			int flag = 0;
			for(int j = 0;j<n-i-1;j++) {
				if(a[j]>a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag =1;
				}
			}	
			if(flag == 0)
				break;
		}
	}
	
	//insertion sort in non increasing order
	static void insertionSorting(long arr[]) {
		int n = arr.length;
		long temp;
		for(int i = 1;i<n;i++) {
			temp = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	//selection sort in non decreasing order
	static void selectionSorting(long a[]) {
	      int n = a.length;
	      long temp;
	      for(int i=0;i<n-1;i++) {
	         int min = i;
	         for(int j = i+1;j<n;j++) {
	            if(a[j]<a[min]) {
	               min = j;
	            }
	         }
	         if(min != i) {
	            temp = a[i];
	            a[i] = a[min];
	            a[min] = temp;
	      
	         }
	      }
	   }
	
	
	//merge sort in non decreasing order
	static void mergeSort(long arr[],int start,int mid,int end)
	{
		mid = (start+(end-start)/2);
		int n1 = mid - start +1;
		int n2 = end - mid;
		
		long l[] = new long[n1];
		long r[] = new long[n2];
		for(int i = 0;i<n1;i++) {
			l[i] = arr[start + i];
		}
		
		for(int j = 0;j<n2;j++) {
			r[j] = arr[mid+1+j];
		}
		
		int i =0;
		int j=0;
		int k =start;
		while(i<n1 && j<n2) {
			if(l[i]<=r[j]) {
				arr[k] = l[i];
				i++;
			}
			else {
				arr[k] = r[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k]= l[i];
			i++;
			k++;
		}

		while(j<n2) {
			arr[k] = r[j];
			j++;
			k++;
		}
		
	}
		
	static void sort(long arr[],int start,int end) 
	{
		if(start<end) 
		{
			int mid  = (start+(end-start)/2);
			sort(arr,start,mid);
			sort(arr,mid+1,end);
			mergeSort(arr,start,mid,end);
		} 
	}
	
	//heap sort in non increasing order
	static void heapify(long a[], int n, int i)
	{
		int smallest = i; // Initialize smalles as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2
	
		// If left child is smaller than root
		if (l < n && a[l] < a[smallest])
			smallest = l;
	
		// If right child is smaller than smallest so far
		if (r < n && a[r] < a[smallest])
			smallest = r;
	
		// If smallest is not root
		if (smallest != i) {
			long temp = a[i];  
	        a[i] = a[smallest];  
	        a[smallest] = temp;
	
			// Recursively heapify the affected sub-tree
			heapify(a, n, smallest);
		}
	}
	
	// main function to do heap sort
	static void heapSort(long a[], int n)
	{
		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(a, n, i);
	
		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			long temp = a[0];  
	        a[0] = a[i];  
	        a[i] = temp;
	
			// call max heapify on the reduced heap
			heapify(a, i, 0);
		}
	}
	
	static void print(long arr[])
	{
		int n = arr.length;
		for(int i =0;i<n;i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
		
	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.println("\n*****Enter Data from text files******\nEnter file path : \t");
		String filepath = userInput.nextLine();  		          //accepting a string from command line (the filepath)

		Scanner inp=new Scanner(new File(filepath));    	      //creating a scanner object and file object
		int n = Integer.parseInt(inp.nextLine()); 		      // first line of textfile contains number of elements the array should contain
		long key1 = Long.parseLong(inp.nextLine());	      // first key in line 2
		long key2 = Long.parseLong(inp.nextLine());	      // second key in line 3
		

		long arr[] = new long[n]; 					      //declaring array and allocating memory to array
		
		for(int i=0;i<n;i++) 						          //populating the array with elements present in the textfile from line 2 till last
			arr[i]=Long.parseLong(inp.nextLine());

		System.out.println("\nElements entered succesfully\nDisplaying the created array. . .\n");
		for(int j = 0;j<n;j++)
				System.out.print(arr[j]+"\t");
			System.out.println("");

		
		int choice = 0;
		while(choice != 8)
		{
			System.out.println("\nMENU (select 1,2,3,4 or 5):\n1.Sequential Search\n2.Binary Search\n3.Bubble Sort\n4.Insertion Sort\n5.Selection Sort\n6.Merge Sort\n7.Heap Sort\n8.Exit..");
			choice = Integer.parseInt(userInput.nextLine());
			switch(choice)
			{
				case 1:
					System.out.println("\n");
					System.out.println("**************************SEQUENTIAL SEARCH********************************");
					System.out.println("-------------------------------------------------------------------------");
					sequential_search(arr,n,key1);
					sequential_search(arr,n,key2);
					break;
					
				case 2:
					System.out.println("\n");
					System.out.println("**************************BINARY SEARCH************************************");
					System.out.println("-------------------------------------------------------------------------");
					sort(arr,0,n-1);
					System.out.println();
					System.out.println("After Sorting : ");
					print(arr);
					int count2 = 0;
					int d = binary_search(arr,0,n-1,key1,count2);
					if(d == -1)
					    System.out.println("\nElement :"+key1+" not found");
					else 
						System.out.println("\nElement:"+key1+" found at index: "+d);
					System.out.println();
					int f = binary_search(arr,0,n-1,key2,count2);
					if(f == -1) 
					    System.out.println("\nElement : "+key2+" not found");
					else 
						System.out.println("\nElement:"+key2+" found at index: "+f);
					
					break;
					
				case 3:
					System.out.println("\n");
					System.out.println("*******************BUBBLE SORT(Non Decreasing Order)**********************");
					System.out.println("--------------------------------------------------------------------------");
					bubbleSorting(arr);
					System.out.println();
					System.out.println("After Sorting : ");
					print(arr);
					break;

				case 4:
					System.out.println("\n");
					System.out.println("****************INSERTION SORT(Non Decreasing Order)***********************");
					System.out.println("--------------------------------------------------------------------------");
					insertionSorting(arr);
					System.out.println();
					System.out.println("After Sorting : ");
					print(arr);
					break;
					
				case 5:
					System.out.println("\n");
					System.out.println("****************SELECTION SORT(Non Decreasing Order)**********************");
					System.out.println("--------------------------------------------------------------------------");
					selectionSorting(arr);
					System.out.println();
					System.out.println("After Sorting : ");
					print(arr);
					break;

				case 6:
					System.out.println("\n");
					System.out.println("****************MERGE SORT(Non Decreasing Order)**************************");
					System.out.println("--------------------------------------------------------------------------");
					sort(arr,0,n-1);
					System.out.println();
					System.out.println("After Sorting : ");
					print(arr);
					break;
					
				case 7:
					System.out.println("\n");
					System.out.println("****************HEAP SORT(Non Increasing Order)***************************");
					System.out.println("--------------------------------------------------------------------------");
					heapSort(arr,n);
					System.out.println();
					System.out.println("After Sorting : ");
					print(arr);
					break;
					
				case 8:
					System.out.println("\nExit code accepted...\nTask complete...");
					break;				

				default:
					System.out.println("\nInvalid Choice...\nPlease try again...");
					
			} //end of switch
		}  // end of while

	} // end of main
} // end of class