import java.util.*;
import java.io.*;
public class QuickUnion {

	private int [] data;
	private int counts;
    private int [] size;
    // Initialize QuickUnion data structure with N nodes of the tree
	public QuickUnion (int N){
		counts =N;
        data= new int[N];
        //to keep track of weighted list
        size = new int[N];
	for (int i=0; i<N; i++ )
		data[i]=i;
    for (int i=0;i<N ;i++ ) {
        // At first there is only one element in each index of an array
        size[i]=1;
    }
	}
    //chase the parent pointers until you reach to the root of the tree
    //is to be private not to be called to the client side
    private int root(int p){
        while(p!=data[p]){
            
            //flaten the tree even futher
            data[p]=data[data[p]];
            p=data[p];
        }

        return p;
    }
    // Connect the two pair to form one object
	public void union(int p,int q){
		// Get the coresponding root
		int i = root(p);
		int j = root(q);
        //if they have the same root return
        if(i==j)return;
        if(size[i] < size[j]){
            data[i]=j;
            size[j]+=size[j];
        } else {
            data[j]=i;
            size[i]+=size[j];
        }
        counts--;
		
	}
	// Asks to find if two pair have the same root
	public boolean unionConnected(int p,int q){
		return root(p)==root(q);
	}
	
    // Counts the number of objects in the component
    public int count(){
    	return counts;
    }

    public static void main(String[] args)throws FileNotFoundException {
    	// Read data from the file one interger at a time
    	Scanner input = new Scanner(new File("tinyUF.txt"));
        
        // Now read the first interger from the file
        int N =input.nextInt();

        // create the UnionFind object
    	QuickUnion  qf = new QuickUnion (N);
    	// Read throught the whole file
    	while(input.hasNextInt()) {

    		// Read the first interger
    		int p = input.nextInt();
    		// Read the next interger
    		int q = input.nextInt();
    		if(!qf.unionConnected(p,q)){
    			qf.union(p,q);
    			System.out.println(p+" "+ q);
    		}

    	};
    }
	
}