package wordle;

import wordle.wordle;

import java.util.ArrayList;

public class wordlel {
    static int wordsize;
    static ArrayList<String> answer =new ArrayList<>();
    wordlel(){
        answer.add("f");
        answer.add("a");
        answer.add("r");
        wordsize=answer.size();
    }
    static boolean exactLetter(int i){
        if(wordle.tf.get(i).getText().equals(answer.get(i))){
            return true;
        }
        return false;
    }
    static boolean containLetter(int i){
        if(answer.contains(wordle.tf.get(i).getText())){
            return true;
        }
        return false;
    }

}
