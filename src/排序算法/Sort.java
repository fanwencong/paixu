package 排序算法;

public class Sort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int arr[]={40,30,68,98,86,15,57};
		heapSort(arr);
		//System.out.println("直接插入排序");insertSort(arr);//直接插入排序  
	
//		System.out.println("冒泡排序");bubbleSort(arr);//冒泡排序
	//	System.out.println("希尔排序");shellSort(arr);//希尔排序
		
		System.out.println("快速排序");
		quickSort(arr, 0, arr.length-1);
		for (int i : arr) {
			System.out.print(i+"\t");
		}
		}

public static  void insertSort(int[] nums) //直接插入排序    
{                // 时间复杂度：在最好情况下，待排序序列为正序，时间复杂度为O(n)；
	           //最坏情况下，待排序序列为逆序，时间复杂度为O(n^2);平均情况下，时间复杂度为O(n^2)。
	for(int i=1;i<nums.length;i++)
	{for(int j=i;j>0;j--)
	{if(nums[j]<nums[j-1])
	  {                                  
		int temp=nums[j];                   
		nums[j]=nums[j-1];                    
		nums[j-1]=temp;                
		}                
	}            
	System.out.print(i+":");             
	for(int a:nums)                
		System.out.print(a+"\t");           
	System.out.println();        
	}      
	}

public static void shellSort(int[] nums)
{//希尔排序         对直接插入排序的改进     时间复杂度：O（nlogn）~O(n^2) 
	int d=nums.length/2;//增量大小         
	while(d>0){              
		int k=0;//控制量             
		while(k<d){ 
			//进行直接插入排序                 
			for(int i=k;i<nums.length;i=i+d){                     
				for(int j=i;j>0&&j-d>=0;j=j-d){                         
					if(nums[j]<nums[j-d]){                                               
						int temp=nums[j];                             
						nums[j]=nums[j-d];                             
						nums[j-d]=temp;                          
						}                                            
					}                                    
				}                  
			k++;//控制量增加              
			}//while              
		System.out.print(d+":");             
		for(int a:nums)                  
			System.out.print(a+" ");            
		System.out.println();              
		d=d/2;           
		}//while     
	}

public static void bubbleSort(int[] nums)
{//冒泡排序        
	for(int i=nums.length-1;i>0;i--)
	{  for(int j=0;j<i;j++)
	{  if(nums[j]>nums[j+1])
	{  int temp=nums[j];                   
	   nums[j]=nums[j+1];                    
	   nums[j+1]=temp;                
	}             
	}            
	System.out.print(nums.length-i+":");            
	for(int a:nums)                  
		System.out.print(a+"\t");             
	System.out.println();         
	}      
	} 
			/**
			 快速排序
			*/
public static void quickSort(int[] nums,int low ,int high){
	//快速排序          对冒泡排序的改进   首先选一个轴值，将待排序记录分割成独立的两部分，
	//左侧记录的关键字均小于或者等于轴值，右边记录的关键字均大于或者等于轴值，
	//然后分别对这两部分重复上述过程，直到整个序列有序。
//	在最好情况下，每次划分轴值的左侧子序列与右侧子序列的长度相同，时间复杂度为O(nlogn),
//	在最坏情况下，待排序序列为正序或逆序，时间复杂度为O(n^2)；平均情况下，时间复杂度为O(nlogn)。
	if(low<high) {                           
		int dp=partition(nums,low,high);                 
		quickSort(nums,low,dp-1);  
		quickSort(nums,dp+1,high); 
		}
	}     
public static int partition(int[] nums,int low ,int high){          
	int pivot=nums[low];         
	while(low<high){              
		while(low < high && nums[high]>=pivot)                 
			high--;                      
		nums[low]=nums[high];               
		while(low < high && nums[low]<=pivot)                 
			low++;              
		nums[high]=nums[low];          
		} 
	nums[low]=pivot;//此时low等于high，所以，也可以写成nums[high]=pivot;          
	return low; //此时low等于high，所以返回任意一个都是正确的      }		
}


public static void heapSort(int[] nums) {
	//堆排序    时间复杂度：最好，最坏，平均的时间复杂度都是O(nlogn)。
//	首先将待排序的记录序列构造成一个堆，此时，选出了堆中所有记录的最大者即堆顶记录，
//	然后将他从堆中移走，并将剩下的记录再调整成堆，这样又找出了次大的记录，以此类推，直到堆中只有一个记录为止。
	if (nums == null || nums.length <= 1) {          
		return;     }     
	buildMaxHeap(nums);//调用建立堆的函数      
	//将堆顶元素调整至数组最后，然后，将当前堆继续调整为大顶堆     
	for (int i = nums.length - 1; i >= 1; i--) {          
		int temp=nums[0];         
		nums[0]=nums[i];         
		nums[i]=temp;          
		maxHeap(nums, i, 0);           
		System.out.print(nums.length-i+":");         
		for(int a:nums)          
			System.out.print(a+" ");         
		System.out.println();     } }  
private static void buildMaxHeap(int[] nums) {
	//建立堆     
	if (nums == null || nums.length <= 1) {         
		return;     }      
	int half = nums.length / 2;     
	for (int i = half; i >= 0; i--) {        
		maxHeap(nums, nums.length, i);     } 
	}  
private static void maxHeap(int[] nums, int heapSize, int index) {
	//递归调整为大顶堆      
	int left = index * 2 + 1;     
	int right = index * 2 + 2;      
	if( left > heapSize && right > heapSize ){            
		//没有这个return，也是正确的，好吧!我没有看懂~            
		return;     }      
	int largest = index;     
	if (left < heapSize && nums[left] > nums[index]) {         
		largest = left;     }      
	if (right < heapSize && nums[right] >nums[largest]) {         
		largest = right;     }      
	if (index != largest) {                  
		int temp=nums[index];         
		nums[index]=nums[largest];         
		nums[largest]=temp;          
		maxHeap(nums, heapSize, largest);     }   
	}


}


