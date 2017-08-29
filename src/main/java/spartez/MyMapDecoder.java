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

/**
 * @author debmalyajash
 *
 */
public class MyMapDecoder implements MapDecoder {

	/* (non-Javadoc)
	 * @see spartez.MapDecoder#decode(java.lang.String)
	 */
	@Override
	public Map<String, String> decode(String s) {
		if (s==null){
			return null;
		}
		
		s = s.trim();
		if ("".equals(s) ){
			return new HashMap<String,String>();
		}
		if ( !s.contains("=")){
			throw new IllegalArgumentException("String has an invalid format");
		}
		
		if (s.indexOf("=") != s.lastIndexOf("=") && !s.contains("&")){
			// multiple key value pair, but there is no "&" as separator
			throw new IllegalArgumentException("String has an invalid format");
		}
		String[] keyValuePairs = s.split("&");
		
		Map<String,String> keyValueMap = new HashMap<>();
		for (String eachKeyValue:keyValuePairs){
			String[] keyValue = eachKeyValue.split("=");
			String key = "";
			String value = "";
			if (keyValue.length == 1){
				key = keyValue[0];
			}else if (keyValue.length == 2){
				key = keyValue[0];
				value = keyValue[1];
			}
			
			keyValueMap.put(key, value);
		}
		
		return keyValueMap;
	}

}
