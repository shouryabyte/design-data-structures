class parking{
    int b,m,s;
    public parking(int big, int medium, int small) {
        b=big;
        m=medium;
        s=small;
    }
    public boolean addCar(int carType){
        if((carType==1 && b==0) || (carType==2 && m==0) || (carType==3 && s==0)){
            return false;
        }
        if(carType==1){
            b--;
        }
        else if(carType==2) m--;
        else s--;
        return true;
    }
    public static void main(String[] args) {
        parking p = new parking(1,1,0);
        System.out.println(p.addCar(1));
        System.out.println(p.addCar(2));
        System.out.println(p.addCar(3));
        System.out.println(p.addCar(1));


    }
}