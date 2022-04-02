package ru.example.fourth;

import java.io.IOException;

public class FourthHomeWork {
    public static void main(String[] args) throws TriangleSideException {
        System.out.println(triangle(7, 8, 9));
    }
    public static int triangle(int a, int b, int c) throws TriangleSideException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw  new TriangleSideException("The side of the triangle cannot be equal or less to zero");
        }
        else if (a >= (b + c) || b >= (a + c) || c >= (a + b)) {
            throw  new TriangleSideException("The side of a triangle cannot be greater than the sum of the other two sides");
        }
        int p = (a + b + c) / 2;
        int s = (p * (p - a) + (p - b) * (p - c));
        return (int)Math.sqrt(s);
    }
}