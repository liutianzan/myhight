package com.my.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStacke {
    static class NodeL{
        NodeL pre;
        int val;
        public NodeL(int val){
            this.val = val;
        }
    }
    NodeL head = null;
    NodeL conurron = null;
    public void push(Integer val){
        if(head == null){
            NodeL node = new NodeL(val);
            head = node;
            conurron = head;
        }else {
            NodeL nodeL = new NodeL(val);
            nodeL.pre = conurron;
            conurron = nodeL;
        }
    }
    public Integer pop(){
        if(conurron==null){
            return null;
        }
        NodeL node = conurron;
        conurron = conurron.pre;
        return node.val;
    }

}
class MyStack1{
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();
    public void push(Integer val){
        if(q1.isEmpty()&&q2.isEmpty()){
            q1.add(val);
            return;
        }
        if(q1.isEmpty()){
            q2.add(val);
            return;
        }
        if(q2.isEmpty()){
            q1.add(val);
            return;
        }
    }
    public Integer pop(){
        if(q1.isEmpty()&&q2.isEmpty()){
            return null;
        }
        if(q1.isEmpty()){
            while(q2.size()>1){
                q1.add(q2.poll());
            }
            return q2.poll();
        }else{
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            return q1.poll();
        }
    }
}
class Test111{
    public static void main(String [] args){
        MyStacke s = new MyStacke();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        MyStack1 s1 = new MyStack1();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }
}
