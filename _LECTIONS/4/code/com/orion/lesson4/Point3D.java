package com.orion.lesson4;

public class Point3D extends Point {
    int z;
    int x;

    public Point3D(int x, int y, int z) {
        super();
        this.x = x + 1;
        this.z = z;
    }




    public void printX() {
        System.out.println(x);
    }


    public static void main(String[] args) {
        final Point3D point3D = new Point3D(0, 0, 0);
        point3D.printX();
        System.out.println(point3D.getX());

    }
}
