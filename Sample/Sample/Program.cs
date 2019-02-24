using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sample
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var fileNameList = new List<string>();
            ReadFileName(fileNameList);
            foreach (var fileName in fileNameList)
            {
                Console.WriteLine(fileName);
            }

            WriteTime();
        }

        private static void ReadFileName(List<string> fileNameList)
        {
            try
            {
                string readFilePath = "file_name.txt";
                Encoding encoding = Encoding.GetEncoding("UTF-8");


                using (var reader = new StreamReader(readFilePath, encoding))
                {
                    while (reader.Peek() != -1)
                    {
                        fileNameList.Add(reader.ReadLine());
                    }
                }
            }
            catch (Exception)
            {
                Console.WriteLine("ファイルの読み込みに失敗しました。");
                throw;
            }
        }

        private static void WriteTime()
        {
            try
            {
                string writeFilePath = "date_time.txt";


                using (var writer = new StreamWriter(writeFilePath, true))
                {
                    writer.WriteLine(DateTime.Now);
                }
            }
            catch (Exception)
            {
                Console.WriteLine("ファイルの書き込みに失敗しました。");
                throw;
            }
        }
    }
}
