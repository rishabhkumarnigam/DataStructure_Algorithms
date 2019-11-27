package arrayExample;

//input :-
//Hi I am the Author
//output :-
//rohtuA eht ma I iH


public class ReverseSentence {
  public static void main(String[] args) {

    String inputSentence="Hi I am the Author";
    System.out.println("reverse Sentence1 = " + reverseSentence(inputSentence));
    System.out.println("reverse Sentence2 = " + reverseSentence2(inputSentence));

  }

  private static String reverseSentence(String sentence){
    //check input always
    if(sentence == null || sentence.length() <2 ){
      return sentence;
    }

    StringBuffer reverseSentence=new StringBuffer("");

    for(int i=sentence.length()-1;i>=0;i--){
      reverseSentence=reverseSentence.append(sentence.charAt(i));
    }
    return reverseSentence.toString();
  }

  private static String reverseSentence2(String sentence)
  {
    //check input always
    if(sentence == null || sentence.length() <2 ){
      return sentence;
    }

    StringBuffer sb=new StringBuffer(sentence);
     return sb.reverse().toString();
  }
}
