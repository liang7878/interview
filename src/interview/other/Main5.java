package interview.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main5 {

    static class Question {
        int nandu;
        int tagCount;
        ArrayList<String> tags = new ArrayList<>();

        public Question(int nandu, int tagCount) {
            this.nandu = nandu;
            this.tagCount = tagCount;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());

        for(int i=0; i<T; i++) {
            HashMap<String, ArrayList<Question>> pool = new HashMap<>();



            String[] nmls = in.nextLine().split(" ");
            int N = Integer.parseInt(nmls[0]);
            int M = Integer.parseInt(nmls[1]);
            int L = Integer.parseInt(nmls[2]);
            int S = Integer.parseInt(nmls[3]);

            ArrayList<Question> questionArrayList = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String line = in.nextLine();
                String [] slices = line.split(" ");
                Question question = new Question(Integer.parseInt(slices[0]), Integer.parseInt(slices[1]));

                for (int k = 0; k < Integer.parseInt(slices[1]); k++) {
                    question.tags.add(slices[k+2]);
                }

                questionArrayList.add(question);
                for (int k = 0; k < Integer.parseInt(slices[1]); k++) {
                    if(pool.get(slices[k+2]) == null) {
                        ArrayList<Question> list = new ArrayList<>();
                        list.add(question);
                        pool.put(slices[k+2], list);
                    } else {
                       pool.get(slices[k+2]).add(question);
                    }
                }
            }

            ArrayList<ArrayList<ArrayList<Question>>> resultlist = new ArrayList<>();
            ArrayList<ArrayList<Integer>> nandulist = new ArrayList<>();

            for (int j = 0; j < L+1; j++) {
                resultlist.add(new ArrayList<>());
            }

            for (int j = 0; j < questionArrayList.size(); j++) {
                Question question = questionArrayList.get(j);
                for (int k = question.nandu; k < L+1; k++) {
                    if(k == question.nandu) {
                        ArrayList<Question> result = new ArrayList<>();
                        result.add(question);
                        resultlist.get(k).add(result);
//                        if(nandulist.get(k) == null) nandulist.set(k, new ArrayList<Integer>());
//                        nandulist.get(k).add(question.nandu);
                    } else {
                        //当前k的list + k-nandu的list加上当前question
                        ArrayList<ArrayList<Question>> currentAnswerlist = resultlist.get(k);

                        ArrayList<ArrayList<Question>> jianklist = resultlist.get(k-question.nandu);
                        ArrayList<ArrayList<Question>> buchongtulist = new ArrayList<>();

                        for (int l = 0; l < jianklist.size(); l++) {
                            ArrayList<Question> questionArrayList1 = jianklist.get(l);
                            boolean chongtu = false;
                            int minNandu = Integer.MAX_VALUE;
                            int maxNandu = Integer.MIN_VALUE;
                            int nandumax = 0;
                            if(questionArrayList1.size() >= M) chongtu = true;

                            for (int m = 0; m < questionArrayList1.size() && questionArrayList1.size()<M; m++) {
                                Question test= questionArrayList1.get(m);
                                nandumax += test.nandu;
                                if(test.nandu > maxNandu) maxNandu = test.nandu;
                                if(test.nandu < minNandu) minNandu = test.nandu;

                                if(tagchongtu(test, question)) {
                                    chongtu = true;
                                }

                            }

                            if(nandumax+question.nandu > L) chongtu = true;

                            if(question.nandu > maxNandu) maxNandu = question.nandu;
                            if(question.nandu < minNandu) minNandu = question.nandu;

                            if(maxNandu-minNandu<S) chongtu =true;

                            if(!chongtu) {
                                questionArrayList1.add(question);
                                buchongtulist.add(questionArrayList1);
                            }
                        }

                        currentAnswerlist.addAll(buchongtulist);
                        resultlist.set(k, currentAnswerlist);
                    }
                }
            }

            System.out.println("other/test");
        }

        System.out.println("other/test");

    }

    public static boolean tagchongtu(Question q1, Question q2) {
        ArrayList<String> q1Tags = q1.tags;
        ArrayList<String> q2Tags = q2.tags;

        for (int i = 0; i < q1Tags.size(); i++) {
            for (int j = 0; j < q2Tags.size(); j++) {
                if(q1Tags.get(i).equals(q2Tags.get(j))) {
                    return true;
                }
            }
        }

        return false;
    }

}
