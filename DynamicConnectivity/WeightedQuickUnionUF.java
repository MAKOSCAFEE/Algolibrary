/*----------------------------------------------------------------
 *  Author:        Barnabas Makonda
 *  Written:       10/09/2015
 *  Last updated:  14/09/2015
 *
 *  The WeightedQuickUnionUF class represents a union-find data type
 *  (also known as the disjoint-sets data type). 
 *  It supports the union and find operations, along with a connected operation for determining whether two sites 
 *  are in the same component and a count operation that returns the total number of components.
 *
 *----------------------------------------------------------------*/
public class WeightedQuickUnionUF {

	private int [] data;
	private int counts;
    private int [] size;
    // Initialize WeightedQuickUnionUF data structure with N nodes of the tree
	public WeightedQuickUnionUF (int N){
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
}