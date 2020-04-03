using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Result
{
    public static Dictionary<string, int> AggregateNames(string[] nameList)
    {
        return lines.GroupBy(n => n).ToDictionary(grp => (string)grp.Key, grp => (int)grp.Count()).OrderBy(x => x.Key).ToDictionary(x => x.Key, x => x.Value);
    }
}


class Solution
{
    public static void Main(string[] args)
    {
        string fileName = System.Environment.GetEnvironmentVariable("OUTPUT_PATH");
        TextWriter tw = new StreamWriter(@fileName, true);
        Dictionary<string, int> res;
        
        int _lines_size = 0;
        _lines_size = Convert.ToInt32(Console.ReadLine());
        string[] _lines = new string [_lines_size];
        string _lines_item;
        for(int _lines_i = 0; _lines_i < _lines_size; _lines_i++) {
            _lines_item = Console.ReadLine();
            _lines[_lines_i] = _lines_item;
        }
        
        res = Result.AggregateNames(_lines).OrderBy(x => x.Key).ToDictionary(x => x.Key, x => x.Value);
        foreach (var item in res)
        {
            tw.WriteLine(String.Format("{0} {1}", item.Key, item.Value));
        }
               
        tw.Flush();
        tw.Close();
    }
}

