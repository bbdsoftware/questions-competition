#include <bits/stdc++.h>
using namespace std;
string ltrim(const string &);
string rtrim(const string &);

map<string, int> AggregateNames(vector<string> nameList) {
    map<string, int> dic;
    for (int i=0; i<nameList.size(); ++i)
    {
        if (dic.count(nameList[i]) > 0)
            dic[nameList[i]] += 1;
        else
            dic[nameList[i]] = 1;
    }
    return dic;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));
    string nameList_count_temp;
    getline(cin, nameList_count_temp);
    int nameList_count = stoi(ltrim(rtrim(nameList_count_temp)));
    vector<string> nameList(nameList_count);

    for (int i = 0; i < nameList_count; i++) {
        string nameList_item;
        getline(cin, nameList_item);

        nameList[i] = nameList_item;
    }

    map<string, int> result = AggregateNames(nameList);
    for ( auto item : result )
    {
        fout << item.first << " " << item.second << "\n";
    }
    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);
    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );
    return s;
}

string rtrim(const string &str) {
    string s(str);
    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
