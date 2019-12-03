/**
 * @author maitentai
 * @version 1.0
 * @date 2019-10-10 12:12
 */
public class len {
    //[0，0，4，2，5，0，3，0]


    public static void main(String[] args) {

    }


}
class A {
    public A foo(){
        return this;
    }
}
class B extends A{
    @Override
    public A foo(){
        return this;
    }
}
class C extends B{
    public A foo(B b){
        return b;
    }
}
