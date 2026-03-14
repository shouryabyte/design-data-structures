import java.util.Stack;

public class browser {
    Stack<String> back;
    Stack<String> forr;
    String curr;
    public browser(String homepage){
        curr=homepage;
        back=new Stack<>();
        forr=new Stack<>();
    }
    public void visit(String url){
        back.push(curr);
        curr=url;
        forr.clear();
    }
    public String back(int steps){
        while(steps>0 && !back.isEmpty()){
            forr.push(curr);
            curr=back.pop();
            steps--;
        }
        return curr;
    }
    public String forr(int steps){
        while(steps>0 && !forr.isEmpty()){
            back.push(curr);
            curr=forr.pop();
            steps--;
        }
        return curr;
    }
    public static void main(String[] args) {
        browser br = new browser("leetcode.com");
        br.visit("google.com");
        br.visit("facebook.com");
        br.visit("youtube.com");
        System.out.println(br.back(1));     
        System.out.println(br.back(1));     
        System.out.println(br.forr(1));    
        br.visit("linkedin.com");
        System.out.println(br.forr(2));   
        System.out.println(br.back(2));  
    }
}
