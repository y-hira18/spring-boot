using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SampleApp
{
    public class MethodClass
    {
        public static string Method1()
        {
            string str = "str1";
            str = Method2(str);
            str += ",str1";
            return str;
        }

        private static string Method2(string str)
        {
            str += ",str2";

            return str;
        }

        public static string Method3(PropertyClass property)
        {
            return property.Str;
        }
    }
}
