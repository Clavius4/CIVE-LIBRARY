interface Mathematics{
    void rectangle_area();
    void square_area();
    void cicle_area();

}
class M1{
    public void rectangle_area(int t, int b){
        int a = t*b;
        System.out.println("Area of the Rectangle is: "+a);
    }
    public void square_area(int s){
        int a = s*s;
        System.out.println("Area of the Square is: "+a);

    }
    public void cicle_area(float r){
        float a = 3.14f*r*r;
        System.out.println("Area of the Circle is: "+a);
    }
}

public class Javam {
    public static void main(String[] args) {
        M1 d = new M1();
        d.rectangle_area(4, 1);
        d.square_area(6);
        d.cicle_area(7);
    }

   
}