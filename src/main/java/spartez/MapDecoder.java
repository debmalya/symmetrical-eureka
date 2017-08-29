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

import java.util.Map;

/**
 * @author debmalyajash
 *
 */
public interface MapDecoder {
	/**
     * Decodes the given String into a Map. The String format is a URL parameter string (key=value&key=value&...).
     * Empty keys and values are allowed.
     *
     * @param s     the String to decode
     * @return a    Map representing the given String. If the given String is empty, an empty Map is returned. If the given
     *              String is null, null is returned.
     * @throws IllegalArgumentException if the given String has an invalid format
     */
    Map<String, String> decode(String s);
}
