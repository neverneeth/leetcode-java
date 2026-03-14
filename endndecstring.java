/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
    // ... your code
    return encoded_string;
}
Machine 2 (receiver) has the function:

vector<string> decode(string s) {
    //... your code
    return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.
*/


class Solution {

    public String encode(List<String> strs) {
        String str = "";
        for(String x: strs)
        {
            str+= x+"🔥";
        }
        System.out.println(str);
        return str;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        String temp = "";
        int l = str.length();
        for(int i = 0; i<l; i++)
        {            
            char ch = str.charAt(i);
            if(ch!='🔥')
            {
                temp += ch;
            }
            else
            {
                strs.add(temp);
                i++;
                temp = "";
            }
        }
        return strs;
    }
}
