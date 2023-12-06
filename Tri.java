import java.util.*;

public class Tri
	{
		
		
	public static boolean compare(int ta1[], int ta2[])
	{
		int l1=ta1.length;
		int l2=ta2.length;
		for(int i=0;i<l1-1;i++)
		{
			if(ta1[i] !=ta2[i])
			{
				return(false);
			}
		}
		return(true);
	}

	public static boolean estTrie(int tableau[])
	{
		int compteur=0;
		int longueur=tableau.length;

		for(int i=0;i<longueur-1;i++)
		{
			if(tableau[i]>tableau[i+1])
			{
				assert(compteur == i);
				return(false);
			}
			compteur++;
		}
		assert(compteur == longueur-1);
		return(true);
	}
	
	public static boolean estTrie(int tableau[], AtomicInteger compteur)
	{
		int longueur=tableau.length;
		compteur.set(0);
		for(int i=0;i<longueur-1;i++)
		{
			compteur.incrementAndGet();
			if(tableau[i]>tableau[i+1])
			{
				return(false);
			}
		}
		return(true);
	}

	private static void echanger(int tableau[],int i,int j)
	{
		int memoire=tableau[i];
		tableau[i]=tableau[j];
		tableau[j]=memoire;
	}
 
        
    /**
	*Le tri bulle optimis�
	*
	*/
	public static void triBulleOptimise(int tableau[])
	{
		int longueur=tableau.length;
		boolean inversion;
		
		do
		{
			inversion=false;

			for(int i=0;i<longueur-2;i++)
			{
				if(tableau[i]>tableau[i+1])
				{
					echanger(tableau,i,i+1);
					inversion=true;
				}
			}
             		longueur--;
		}
		while(inversion);	
	}
			

	/**
	*Le tri selection
	*
	*/
	public static void triSelection(int tableau[])
	{
		int longueur=(tableau.length-1);
		
		while (longueur>0)
		{
			//on recupere la position du plus grand �l�ment du tableau non encore tri�
			int maxi=0;
			for(int i=1;i<=longueur;i++)
			{
				if (tableau[i]>tableau[maxi]) 
					maxi=i;
			}
			echanger(tableau,maxi,longueur); 	//on met le plus grand �l�ment � la fin
			longueur--; 				//et on traite le reste du tableau !!!
		}
	}

	/**
	* Le main, qui sert dans la p�riode de test
	*
	*/
	public static void main(String args[])
	{
		System.out.println(" Tri a bulle");
		int val[]={1,5,4,6,3,2,8,9,4,3,10};

		System.out.println("Avant");
		int longu=val.length;
		for(int i=0;i<longu;i++)
		{
			System.out.print(val[i]+" ");
		}

		if (estTrie(val))
                  System.out.println("\n   Le tableau est trie\n");
		else
                  System.out.println("\n   Le tableau est non trie\n");

		triBulleOptimise(val);

		System.out.println("\n"+"Apres");
		for(int i=0;i<longu;i++)
		{
			System.out.print(val[i]+" ");
		}

		System.out.println("\n\n Tri par s�lection");
		int val1[]={1,5,4,6,3,2,8,9,4,3,10};

		System.out.println("Avant");
		longu=val1.length;
		for(int i=0;i<longu;i++)
		{
			System.out.print(val1[i]+" ");
		}

		triSelection(val1);

		System.out.println("\n"+"Apres");
		for(int i=0;i<longu;i++)
		{
			System.out.print(val1[i]+" ");
		}	
	}
		
}