/**Noel Namai CSCI E-124*/

package cscie124.hw1;

public class FibonacciMatrix
{	
	private static final long START_TIME = System.nanoTime();
	
	public int fib(int n)
	{
		int F[][] = {{1,1},{1,0}};
		
		if (n == 0) return 0;
		
		power(F, n);
	 
		if (F[0][1] < 0)
		{
			throw new RuntimeException("Integer Overflow " + (System.nanoTime() - START_TIME) + " ns.");		
		} 
		
		return F[0][1];
	}
	
	public void power(int F[][], int n)
	{
		int G[][] = {{1,1},{1,0}};
	 
		for (int i = 2; i <= n; i ++ )
		{
			F = multiply(F, G);
		}
	}
	
	public int[][] multiply(int F[][], int G[][])
	{
		  int a =  F[0][0]*G[0][0] + F[0][1]*G[1][0]; 
		  int b =  F[0][0]*G[0][1] + F[0][1]*G[1][1];
		  int c =  F[1][0]*G[0][0] + F[1][1]*G[1][0]; 
		  int d =  F[1][0]*G[0][1] + F[1][1]*G[1][1];
		  
		  F[0][0] = a; 
		  F[0][1] = b;
		  F[1][0] = c; 
		  F[1][1] = d;
		  
		  return F;
	}
	 	
	public static void main(String []args)
	{		
		FibonacciMatrix fibonacci = new FibonacciMatrix();
		
		try
		{
			for (int i = 0; i >= 0; i ++)
			{
				System.out.println(fibonacci.fib(i));
			}
		}
		catch (RuntimeException e)
		{
			System.out.println(e.getMessage());
		}
	}
}