/*
 * Made By Mouad AIT OUGRRAM
 * AkA : Big Marvel
 * 
 */
import java.util.Arrays;
import java.util.Iterator;

public class Finalversion {

		static double[] c;
		static double[] b;
		static double[][] a;
		static double max=0;
		static int[] indices;
		static double[] x;
		
		public Finalversion(double[][] A , double[] B, double[] C)
		{
	        a = new double[A[0].length+B.length][A.length];
	        b= new double[B.length];
	        c = new double[C.length+B.length];
	        x=new double[A[0].length+B.length];
	        v=new double[A.length][b.length];
	        indices=new int[b.length];
	        
	        for (int i = 0; i < A.length; i++)
	            for (int j = 0; j < A[0].length; j++)
	                a[j][i] = A[i][j];
	        for (int j = 0; j < B.length; j++)
	            b[j]=B[j];
	        for (int i = 0; i < C.length; i++)
	            c[i]=C[i];
	        
	        

			add(A[0].length);

			
			for(double[] l:a) {
				System.out.println(Arrays.toString(l));
			}
			System.out.println();

			tt(0,a.length-b.length,0);
		}
		static int bm=0;
		public static void tt(int bg,int end,int in)
		{

			if(end<=a.length-1)
			{

				for(int j=bg ; j<=end ; j++)
				{

//						System.out.print(r[j]);
						v[in]=a[j];
						indices[in]=j;
						tt(j+1,end+1,in+1);
						if(end+1>a.length-1 && det(transp(v))!=0)
						{
//						if(end+1>a.length-1)
//						{
//							bm++;
//
//							for(double[] l:v) {
//								System.out.println(Arrays.toString(l));
//							}
//							System.out.println();
//							System.out.println(Arrays.toString(indices));
//							System.out.println();
							
//							System.out.println("Next one");
//							
//							for(double[] l: transp(v)) {
//								System.out.println(Arrays.toString(l));
//							}
//							System.out.println();
							
//							System.out.println(bm);
							
//							double [] t=new double[x.length];
//							for(int i=0 ; i<indices.length ; i++)
//							{
//								t[indices[i]]=multip(invers(transp(v)),b)[i];
//							}
//							System.out.println(Arrays.toString(multip(invers(transp(v)),b)));
//							System.out.println(isOpt(t));
//							System.out.println();
//							
							
//
						calcule();



						}


				}
			}

		}
		static double[][] v;
		
		public static void add(int m)
		{
			for(int i=m ;i<a.length ; i++)
			{
				for(int j=0 ;j<a[0].length ; j++)
				{
					if(j==i-m)
					{
						a[i][j]=1.0;
					}else {
						a[i][j]=0;
					}
				}
				
			}
			
		}

		public static void calcule()
		{
			if(isSol(multip(invers(transp(v)),b))) //if ==true
			{
				double [] t=new double[x.length];
				for(int i=0 ; i<indices.length ; i++)
				{
					t[indices[i]]=multip(invers(transp(v)),b)[i];
				}
				if(isOpt(t)>max)
				{
					max=isOpt(t);
			        for (int i = 0; i < x.length; i++)
			            	x[i] = t[i];
			        
			        
				}
			}
			
		}
		public static double[] multip(double[][] a,double[] b)
		{
			double[] r=new double[a.length];
			for(int i = 0 ; i<a.length;i++)
			{
				for(int j=0 ; j <a[1].length ; j++)
				{
					r[i]+=a[i][j]*b[j];
				}
			}
			return r;
		}
		
		public static double isOpt(double[] x)
		{
			double value=0;
			for(int i=0 ;i<c.length;i++)
			{
				value=value+c[i]*x[i];
			}
//			System.out.println();
			return value;
		}
		public static boolean isSol(double[] x)
		{
			for(int i=0 ;i<x.length;i++)
			{
				if(x[i]<0)
				{
					return false;
				}
			}
			return true;
			
		}
		public static double det(double[][] m)
		{
				
			
			double[][] ech=new double[m.length][m[0].length];
	        for (int i = 0; i < m.length; i++)
	            for (int p = 0; p < m[0].length; p++)
	            	ech[i][p] = echinf(m)[i][p];

			int i=0;
			double d=1;
			for(double[] vx : ech)
			{
				d=d*vx[i];
				i++;
			}
			return d;
		}
		public static double[][] echinf(double[][] m)
		{
			
			double[][] ech=new double[m.length][m[0].length];
	        for (int i = 0; i < m.length; i++)
	            for (int p = 0; p < m[0].length; p++)
	            	ech[i][p] = m[i][p];
			
			
			
			for(int k =0; k<ech.length;k++) {
				double [] a=ech[k];
				for(int i =k+1; i<ech[1].length;i++)
				{
					double b=ech[i][k];
					for(int j =0; j<ech[1].length;j++)
					{
						if(a[k]==0)
						{
							break;
						}else {
							ech[i][j]-=(b/a[k])*a[j];
						}
					}
				}
			}
	        
			for(int i = 0 ; i <ech[0].length-1;i++)
			{
				if(ech[i][i]==0)
				{
					for(int j = i+1 ; j <ech.length;j++)
					{
						
						if(ech[j][i]!=0)
						{
							double[] temp = ech[j];
							for(int p =0 ; p<ech[0].length;p++)
								ech[i][p]=-ech[i][p];
							ech[j]=ech[i];
							ech[i]=temp;

							break;
							
						}
					}
				}
			}
//			for(double[] l: ech) {
//				System.out.println(Arrays.toString(l));
//			}
//			System.out.println();
//			

			for(int i = 0 ; i <ech[0].length-1;i++)
				for(int j = i+1 ; j <ech.length;j++)
					if(ech[j][i]!=0)
						return echinf(ech);

			return ech;
		}
		public static double[][] invers(double[][] m)
		{
			double[][] I= new double[m.length][m[1].length];
			
			for(int i = 0 ; i <m.length;i++)
			{
				for(int j = 0 ; j <m[1].length;j++)
				{
					I[i][j]=(i==j)?1:0;
				}
			}

			
			return echinf(m,I);
			
		}
	    public static double[][] echsup(double[][] m,double[][] Im)
	    {
			double[][] ech=new double[m.length][m[0].length];
	        for (int i = 0; i < m.length; i++)
	            for (int p = 0; p < m[0].length; p++)
	            	ech[i][p] = m[i][p];
	        
			double[][] I=new double[Im.length][Im[0].length];
	        for (int i = 0; i < Im.length; i++)
	            for (int p = 0; p < Im[0].length; p++)
	            	I[i][p] = Im[i][p];
	        
	        for(int k=ech.length-1 ;k>=0;k--)
	        {
	            double[] a = ech[k];
	            double[] x = I[k];
	            for(int i=0 ;i<k;i++)
	            {
	                double b = ech[i][k];
	                for(int j=0 ;j<ech[1].length;j++)
	                {
	                    ech[i][j]-=(b/a[k])*a[j];
	                    I[i][j]-=(b/a[k])*x[j];
	                }
	            }  
	        }
	        return I;
	    }
	    
	    public static double[][] echinf(double[][] m,double[][] Im)
	    {
			double[][] ech=new double[m.length][m[0].length];
	        for (int i = 0; i < m.length; i++)
	            for (int p = 0; p < m[0].length; p++)
	            	ech[i][p] = m[i][p];
	        
			double[][] I=new double[Im.length][Im[0].length];
	        for (int i = 0; i < Im.length; i++)
	            for (int p = 0; p < Im[0].length; p++)
	            	I[i][p] = Im[i][p];
	        
	        
	        for(int k=0;k<ech.length;k++)
	        {
	            double[] a = ech[k];
	            double[] x = I[k];
	            double div =a[k];
	            for(int p=0 ;p<a.length;p++)
	           	{
	                if(div!=0)
	                {
	                    a[p]/=div;
	                    x[p]/=div;
	                }
	            }
	            for(int i=k+1 ;i<ech.length;i++)
	            {
	                double b = ech[i][k];
	                for(int j=0 ;j<ech[1].length;j++)
	                {
						if(a[k]==0)
						{
							break;
						}else {
		                    ech[i][j]-=(b/a[k])*a[j];
		                    I[i][j]-=(b/a[k])*x[j];
						}
	                }
	            }  
	        }
	        
			for(int i = 0 ; i <ech[0].length-1;i++)
				for(int j = i+1 ; j <ech.length;j++)
					if(ech[j][i]!=0)
					{
						for(int x = 0 ; x <ech[0].length-1;x++)
						{
							if(ech[x][x]==0)
							{
								for(int y = x+1 ; y <ech.length;y++)
								{
									
									if(ech[y][x]!=0)
									{
										double[] temp = ech[y];
										ech[y]=ech[x];
										ech[x]=temp;
										
										double[] tempi = I[y];
										I[y]=I[x];
										I[x]=tempi;

										break;
										
									}
								}
							}
						}
						return echinf(ech,I);
					}
						
	     
	        return echsup(ech,I);
	    }
		public static double[][] transp(double[][] kx)
		{
			double[][] tr = new double[kx.length][kx[0].length];
	        for (int i = 0; i < kx.length; i++)
	            for (int p = 0; p < kx[0].length; p++)
	                tr[i][p] = kx[i][p];
			
			for(int i = 0 ; i <tr.length;i++)
			{
				for(int j = i ; j <tr[1].length;j++)
				{
					double temp =tr[i][j];
					tr[i][j]=tr[j][i];
					tr[j][i]=temp;


				}
			}	
//			
//			for(double[] l: tr) {
//				System.out.println(Arrays.toString(l));
//			}
//			System.out.println();
			return tr;
		}

	    public static void test1() {
	        double[][] mat = {
	            { -1,  1,  0 },
	            {  1,  4,  0 },
	            {  2,  1,  0 },
	            {  3, -4,  0 },
	            {  0,  0,  1 }
	        };
	        double[] con = { 1, 1, 1 };
	        double[] bio = { 5, 45, 27, 24, 4 };
	        Finalversion Finalversion;
	        Finalversion=new Finalversion(mat,bio,con);
	        
			System.out.println(Arrays.toString(x));
			for(int i=0; i<x.length;i++)
			{
				if(i<mat[0].length)
				{
					System.out.printf("x[%d] = %f\n",i,x[i]);
				}else {
					System.out.printf("e[%d] = %f\n",i-mat[0].length,x[i]);
				}
			}
			System.out.println("La Valeur Maximale est ="+max);

	    }
	    
	    public static void test2() {
	        double[][] mat = {
	        		{1,1,2},
	        		{1,4,-1}
	        };
	        double[] con = { 2, 1, -1 };
	        double[] bio = { 6, 4};
	        Finalversion Finalversion;
	        Finalversion=new Finalversion(mat,bio,con);
	        
			System.out.println(Arrays.toString(x));
			for(int i=0; i<x.length;i++)
			{
				if(i<mat[0].length)
				{
					System.out.printf("x[%d] = %f\n",i,x[i]);
				}else {
					System.out.printf("e[%d] = %f\n",i-mat[0].length,x[i]);
				}
			}
			System.out.println("La Valeur Maximale est ="+max);

	    }
	    public static void test3() {
	        double[][] mat = {
	                { 0.5, -5.5, -2.5, 9.0 },
	                { 0.5, -1.5, -0.5, 1.0 },
	                { 1.0,  0.0,  0.0, 0.0 }
	        };
	        double[] con = { 10.0, -57.0, -9.0, -24.0 };
	        double[] bio = {  0.0,   0.0,  1.0 };
	        Finalversion Finalversion;
	        Finalversion=new Finalversion(mat,bio,con);
	        
			System.out.println(Arrays.toString(x));
			for(int i=0; i<x.length;i++)
			{
				if(i<mat[0].length)
				{
					System.out.printf("x[%d] = %f\n",i,x[i]);
				}else {
					System.out.printf("e[%d] = %f\n",i-mat[0].length,x[i]);
				}
			}
			System.out.println("La Valeur Maximale est ="+max);

	    }
	    public static void test4() {
	        double[][] mat = {
	        		{2,3,1},
	        		{4,1,2},
	        		{3,4,2}
	        };
	        double[] con = {5,4,3};
	        double[] bio = {5,11,8};
	        Finalversion Finalversion;
	        Finalversion=new Finalversion(mat,bio,con);
	        
			System.out.println(Arrays.toString(x));
			for(int i=0; i<x.length;i++)
			{
				if(i<mat[0].length)
				{
					System.out.printf("x[%d] = %f\n",i,x[i]);
				}else {
					System.out.printf("e[%d] = %f\n",i-mat[0].length,x[i]);
				}
			}
			System.out.println("La Valeur Maximale est ="+max);

	    }

	    public static void test5() {
	        double[][] mat = {
	                {  5, 7 },
	                {  1,  1 },
	                { 9, 7 }
	        };
	        double[] con = {  3 , 4 };
	        double[] bio = { 16500 ,2500,21300 };
	        Finalversion Finalversion;
	        Finalversion=new Finalversion(mat,bio,con);
	        
			System.out.println(Arrays.toString(x));
			for(int i=0; i<x.length;i++)
			{
				if(i<mat[0].length)
				{
					System.out.printf("x[%d] = %f\n",i,x[i]);
				}else {
					System.out.printf("e[%d] = %f\n",i-mat[0].length,x[i]);
				}
			}
			System.out.println("La Valeur Maximale est = "+ max);
	    }
	    public static void test6() {
	        double[][] mat = {
	                {  1, 3},
	                {  -1, 3 },
	                { 1, -1 }
	        };
	        double[] con = {  1,2 };
	        double[] bio = { 21, 18, 5 };
	        Finalversion Finalversion;
	        Finalversion=new Finalversion(mat,bio,con);
	        
			System.out.println(Arrays.toString(x));
			for(int i=0; i<x.length;i++)
			{
				if(i<mat[0].length)
				{
					System.out.printf("x[%d] = %f\n",i,x[i]);
				}else {
					System.out.printf("e[%d] = %f\n",i-mat[0].length,x[i]);
				}
			}
			System.out.println("La Valeur Maximale est = "+ max);

	    }
	    public static void test7() {
	        double[][] mat = {
	                {0.5,1.5,2},
	                {2,1.5,0.5}
	        };
	        double[] con = {3,4,5};
	        double[] bio = {12,15};
	        Finalversion Finalversion;
	        Finalversion=new Finalversion(mat,bio,con);
	        
			System.out.println(Arrays.toString(x));
			for(int i=0; i<x.length;i++)
			{
				if(i<mat[0].length)
				{
					System.out.printf("x[%d] = %f\n",i,x[i]);
				}else {
					System.out.printf("e[%d] = %f\n",i-mat[0].length,x[i]);
				}
			}
			System.out.println("La Valeur Maximale est = "+ max);
	    }
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			test1();
		}

	}

