
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.*;

public class TriTest extends TestCase {

	protected void setUp() {

	}
	public static Test suite() {

		/*
		 * the type safe way
		 *
		TestSuite suite= new TestSuite();
		suite.addTest(
			new TriTest("add") {
				 protected void runTest() { test1(); }
			}
		);
		
		return suite;
		*/

		/*
		 * the dynamic way
		 */
		return new TestSuite(TriTest.class);
	}
	// public void testEstTrie()
	// {
	// 	int val1[] = {1,2,3};
	// 	int val2[] = {3,2,1};
	// 	int val3[] = {};
	// 	int compteur = 0;
	// 	boolean result1 = Tri.estTrie(val1, compteur);
	// 	assertTrue(result1);
	// 	compteur = 0;
		
	// 	boolean result2 = Tri.estTrie(val2, compteur);
	// 	assertFalse(result2);
	// 	compteur = 0;
		
	// 	boolean result3 = Tri.estTrie(val3, compteur);
	// 	assertTrue(result3);
	// }
	public void test1() {
	
		Tri tt = new Tri();

		System.out.println(" Tri a bulle");
		int val[]={1,2,3};
		int result[]={1,2,3};

		System.out.println("Avant");
		int longu=val.length;
		for(int i=0;i<longu;i++)
		{
			System.out.print(val[i]+" ");
		}

		if (tt.estTrie(val))
                  System.out.println("\n   Le tableau est trie\n");
		else
                  System.out.println("\n   Le tableau est non trie\n");

		tt.triBulleOptimise(val);

		System.out.println("\n"+"Apres");
		for(int i=0;i<longu;i++)
		{
			System.out.print(val[i]+" ");
		}


		// forced failure result == 5
		assertTrue(tt.compare(val,result));
	}

	public void testEstTrie() {
		System.out.println("\n Test est trie");
		int[] tableau = {1, 2, 3};
		int[] tableau0 = {};
		int[] tableau1 = {1};
		int[] tableauNonTrie = {3, 2, 1};
		AtomicInteger compteur = new AtomicInteger();
		System.out.println("Test tableau déjà trié");
		assertTrue(Tri.estTrie(tableau, compteur));
		assertEquals(2, compteur.get());
		System.out.println("Test tableau longueur 0");
		assertTrue(Tri.estTrie(tableau0, compteur));
		assertEquals(0, compteur.get());
		System.out.println("Test tableau longueur 1");
		assertEquals(0, compteur.get());
		assertTrue(Tri.estTrie(tableau1, compteur));
		System.out.println("Test tableau non trié");
		assertFalse(Tri.estTrie(tableauNonTrie, compteur));
		assertEquals(1, compteur.get());
	}
	
	public void testEchanger() {
		try {
			System.out.println("TestEchanger");
			Method method = Tri.class.getDeclaredMethod("echanger", int[].class, int.class, int.class);
			method.setAccessible(true);
			
			int[] tab = {2, 1};
			method.invoke(null, tab, 0, 1);
			
			assert(Arrays.equals(new int[]{1, 2}, tab));
			System.out.println("fin TestEchanger");
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			System.out.println("catch");
			e.printStackTrace();
		}
    }



	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
