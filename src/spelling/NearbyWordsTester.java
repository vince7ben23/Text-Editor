package spelling;

import static org.junit.Assert.*;

import java.util.List;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.Before;

/**
 * @author Cheng-Ying Chen
 * @date 2023/04/08
 *
 */

public class NearbyWordsTester {
	
	// declare variables
	Dictionary dict;
	NearbyWords nw;
	String word;
	List<String> currentList;
	
	
	
	@Before
	public void setUp() throws Exception {
		word = "word";
		currentList = new LinkedList<String>();
		dict = new AutoCompleteDictionaryTrie();
		DictionaryLoader.loadDictionary(dict, "data/dict.txt");
		nw = new NearbyWords(dict);
		
	}
	

	@Test
	public void testSubstitution() {
		nw.substitution(word, currentList, false);
		assertEquals(25*word.length(), currentList.size());
		
	}
	
	@Test
	public void testInsertions() {
		nw.insertions(word, currentList, false);
		//System.out.print(currentList);
		assertEquals(26*(word.length()+1) - word.length(), currentList.size()); // exclude the duplicate string
	}
	
	@Test
	public void testDeletions() {
		nw.deletions(word, currentList, false);
		assertEquals(word.length(), currentList.size());
	}
	
	@Test
	public void testDistanceOne() {
		List<String> resList = nw.distanceOne(word, false);
		assertEquals(51*word.length()+26, resList.size());
	}
	
	@Test
	public void testSuggestions() {
		String misSpell = "speel";
		List<String> resList = nw.suggestions(misSpell, 5);
		System.out.println("testSuggestions result: " + resList);
		for (String str : resList) {
			if (!dict.isWord(str)) {
				fail(str + "is not a valid word.");
			}
		}
	}

}
