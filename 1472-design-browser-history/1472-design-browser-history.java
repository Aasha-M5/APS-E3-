import java.util.*;

class BrowserHistory {

    Stack<String> backStack;
    Stack<String> forwardStack;
    String current;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        current = homepage;
    }

    public void visit(String url) {
        backStack.push(current);   // save current
        current = url;             // move to new page
        forwardStack.clear();      // clear forward history
    }

    public String back(int steps) {
        while (steps > 0 && !backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
            steps--;
        }
        return current;
    }

    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
            steps--;
        }
        return current;
    }
}