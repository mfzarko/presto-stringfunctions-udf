/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.prestosql.stringfunctions;

import io.airlift.slice.Slice;
import io.prestosql.spi.connector.ConnectorSession;
import io.prestosql.spi.function.Description;
import io.prestosql.spi.function.ScalarFunction;
import io.prestosql.spi.function.SqlType;
import io.prestosql.spi.type.StandardTypes;

import java.util.Arrays;

public final class StringComparisonFunctions
{
   private StringComparisonFunctions()
   {
   }

   @Description("Checks if two strings are anagrams of one another.")
   @ScalarFunction("are_anagrams")
   @SqlType(StandardTypes.BOOLEAN)

   public static boolean are_anagrams(ConnectorSession session,
           @SqlType(StandardTypes.VARCHAR) Slice string1,
           @SqlType(StandardTypes.VARCHAR) Slice string2)
   {
       byte[] string1Sorted = string1.getBytes();
       Arrays.sort(string1Sorted);
       byte[] string2Sorted = string2.getBytes();
       Arrays.sort(string2Sorted);
       return Arrays.equals(string1Sorted, string2Sorted);
   }
}