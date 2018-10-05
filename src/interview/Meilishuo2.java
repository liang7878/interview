package interview;

import java.util.*;

public class Meilishuo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine().replaceAll("s =", "").replaceAll("\"", "");
        String line2 = in.nextLine().replaceAll("dict =", "").replaceAll("\"", "");
        String [] dicts = line2.split(",");

        Set<String> dictSet = new HashSet<>();

        for (int i = 0; i < dicts.length; i++) {
            dictSet.add(dicts[i]);
        }

        ArrayList<String> result = (ArrayList<String>) wordBreak(line1, dictSet);


        System.out.print("[");

        for (int i = 0; i < result.size(); i++) {
            if(i!=result.size()-1) {
                System.out.print(result.get(i) + ", ");
            } else {
                System.out.print(result.get(i) + "]");
            }
        }

    }

    //s ="catsanddog"
    //dict ="cat","cats","and","sand","dog"


    public static List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<String>();

        for(int i=0; i<s.length(); i++)
            if (pos[i] != null) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (wordDict.contains(sub)) {
                        if (pos[j] == null) {
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(sub);
                            pos[j] = list;
                        } else {
                            pos[j].add(sub);
                        }

                    }
                }
            }

        if(pos[s.length()]==null){
            return new ArrayList<String>();
        }else{
            ArrayList<String> result = new ArrayList<String>();
            dfs(pos, result, "", s.length());
            return result;
        }
    }

    public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
            dfs(pos, result, combined, i-s.length());
        }
    }
}
