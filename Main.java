package MargeSort;

import java.util.Arrays;

public class Main {
	static int items[] = {7,5,3,6,4,1,2};
	public static void main(String[] args) {
		split(items,0,items.length-1);
		System.out.println(Arrays.toString(items));
	}
	
	
	
	public static void split(int nums[],int left,int right)
	{
		if(left>=right)
			return;
		
		int mid = left+(right-left)/2;
		
		split(nums,left,mid);
		split(nums,mid+1,right);
		
		marge(nums,left,mid,right);
	}
	
	
	public static void marge(int nums[],int left,int mid,int right)
	{
		int n1 = mid-left+1;
		int n2 = right - mid;
		
		int leftElement[] = new int[n1];
		int rightElement[]  = new int[n2];
		
		
		for(int i = 0; i<n1; i++)
			leftElement[i] = nums[left+i];
		
		for(int i = 0; i<n2; i++)
			rightElement[i] = nums[mid+1+i];
		
		int i = 0, j = 0,k = left;
		
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
