package package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IsomorphicString
{
	public HashMap<Character,Integer> occurrence(String s)
	{
		char[] ch = s.toCharArray();
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<ch.length;i++)
		{
			map.put(ch[i], map.getOrDefault(ch[i], 0)+1);
		}
		return map;
	}
	
	public ArrayList<Integer> getMapValues(HashMap<Character,Integer> map)
	{
		ArrayList<Integer> list = new ArrayList<>();
		for(Map.Entry<Character,Integer> e : map.entrySet())
		{
			list.add(e.getValue());
		}
		return list;
	}
	public boolean checkIsomorphic(String s1,String s2)
	{
		ArrayList<Integer> l1 = getMapValues(occurrence(s1));
		ArrayList<Integer> l2 = getMapValues(occurrence(s2));
		return l1.equals(l2);
	}

	@Test
	public void testCase1()
	{
		Assert.assertTrue(checkIsomorphic("aabb", "xxyy"));
	}
	
	@Test
	public void testCase2()
	{
		Assert.assertTrue(checkIsomorphic("ab", "xy"));
	}
	
	@Test
	public void testCase3()
	{
		Assert.assertFalse(checkIsomorphic("aab", "xy"));
	}

}
