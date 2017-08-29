/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spartez;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class MyMapDecoderTest {
	
	MyMapDecoder decoder = new MyMapDecoder();

	/**
	 * Test method for {@link spartez.MyMapDecoder#decode(java.lang.String)}.
	 * If the given String is null, null should be returned.
	 */
	@Test
	public final void testDecodeWithNull() {
		try {
			Assert.assertNull(decoder.decode(null));
			
		}catch(IllegalArgumentException iae){
			Assert.assertTrue(false);
		}
	}
	
	

	/**
	 * If the string has more than one "=" must have an ampersand
	 * If the given String has an invalid format, an IllegalArgumentException should be thrown.
	 */
	@Test
	public final void testDecodeWithoutEqualsSign() {
		try {
			decoder.decode("one=1two=2");
			Assert.assertTrue("Not able to validate without equals",false);
		}catch(IllegalArgumentException iae){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public final void testIllegalArgumentException() {
		try {
			decoder.decode("DebmalyaJash");
			Assert.assertTrue("Not able to validate without equals",false);
		}catch(IllegalArgumentException iae){
			Assert.assertTrue(true);
		}
	}
	
	/**
	 * If the value is empty, empty String should be put to the map as value.
	 */
	@Test
	public final void testDecodeWithoutEqualsAmpersand() {
		try {
			Map<String,String> stringMap = new HashMap<>();
			stringMap.put("WithoutEquals", "");
			Assert.assertEquals(stringMap,decoder.decode("WithoutEquals="));
		}catch(IllegalArgumentException iae){
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public final void testOneTwo(){
		Map<String,String> stringMap = new HashMap<>();
		stringMap.put("one", "1");
		stringMap.put("two", "2");
		
		Assert.assertEquals(stringMap, decoder.decode("one=1&two=2"));
		
	}
	
	/**
	 * 
	 */
	@Test
	public final void testOne(){
		Map<String,String> stringMap = new HashMap<>();
		stringMap.put("one", "1");
		stringMap.put("two", "");
		
		Assert.assertEquals(stringMap, decoder.decode("one=1&two"));
		
	}
	
	@Test
	public final void testOneEmpty(){
		Map<String,String> stringMap = new HashMap<>();
		stringMap.put("one", "1");
		
		Assert.assertEquals(stringMap, decoder.decode("one=1"));
		
	}
	
	/**
	 * If the key is empty, empty String should be put to the map as key.
	 */
	@Test
	public final void testEmptyKey(){
		Map<String,String> stringMap = new HashMap<>();
		stringMap.put("", "1");
		Assert.assertEquals(stringMap, decoder.decode("=1"));
	}
	
	/**
	 * If the key is empty, empty String should be put to the map as key.
	 */
	@Test
	public final void testEmptyKey2(){
		Map<String,String> stringMap = new HashMap<>();
		stringMap.put("", "2");
		Assert.assertEquals(stringMap, decoder.decode("=1&=2"));
	}
	
	/**
	 * If the given String is empty, an empty Map should be returned.
	 */
	@Test
	public final void testEmpty(){
		Map<String,String> stringMap = new HashMap<>();
		Assert.assertEquals(stringMap, decoder.decode(""));
		Assert.assertEquals(stringMap, decoder.decode("    "));
	}
}
