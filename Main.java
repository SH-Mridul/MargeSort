package MargeSort;

import java.util.Arrays;

public class Main {
	static int items[] = {7,5,3,6,4,1,2};
	public static void main(String[] args) {
		split(items,0,items.length-1);
		System.out.println(Arrays.toString(items));
	}
	
	
	//spliting the array element
	public static void split(int nums[],int left,int right)
	{	//base case
		if(left>=right)
			return;
		//taking mid
		int mid = left+(right-left)/2;
		
		//call for left elements
		split(nums,left,mid);
		
		//call for right elements
		split(nums,mid+1,right);
		
		//marge elements
		marge(nums,left,mid,right);
	}
	
	//marge the spliting element
	public static void marge(int nums[],int left,int mid,int right)
	{	
		
		int n1 = mid-left+1; //left elements size
		int n2 = right - mid; // right element size
		
		int leftElement[] = new int[n1]; //for left element of array
		int rightElement[]  = new int[n2]; // for right element of array
		
		//input left element
		for(int i = 0; i<n1; i++)
			leftElement[i] = nums[left+i];
		
		//input right element
		for(int i = 0; i<n2; i++)
			rightElement[i] = nums[mid+1+i];
		//index field
		int i = 0, j = 0,k = left;
		
		//compare left and right then marge 
		while(i<n1 && j<n2)
		{
			if(leftElement[i]<=rightElement[j])
			{
				nums[k] = leftElement[i];
				i++;
			}else {
				nums[k] = rightElement[j];
				j++;
			}
			
			k++;
		}
		
		//----if i or j not equal n1 or n2
		while(i<n1)
		{
			nums[k] = leftElement[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
			nums[k] = rightElement[j];
			j++;
			k++;
		}
		
	}

}
