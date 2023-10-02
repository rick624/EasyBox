package com.rick;

import java.util.Scanner;

public class BoxTester {

    static float[] sizeSort;

    public static void main(String[] args) {
        Box3 box3 = new Box3(23, 14, 13);
        Box5 box5 = new Box5(39.5f, 27.5f, 23);
        System.out.println("Box3 size: "+box3.length+" x "+box3.width+" x "+box3.height);
        System.out.println("Box5 size: "+box5.length+" x "+box5.width+" x "+box5.height);
        userBox();
        System.out.println("User size: "+sizeSort[0]+" x "+sizeSort[1]+" x "+sizeSort[2]);

        if (box3.validate(sizeSort[0], sizeSort[1], sizeSort[2])){     //userBox的尺寸由大至小輸入
            System.out.println("Select Box3.");
        }else if(box5.validate(sizeSort[0], sizeSort[1], sizeSort[2])){
            System.out.println("Select Box5.");
        }
        else{
            System.out.println("Not all boxes fit.");
        }
    }

    public static void userBox() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter object's length: ");
        float length = scanner.nextFloat();
        System.out.print("Please enter object's width: ");
        float width = scanner.nextFloat();
        System.out.print("Please enter object's height: ");
        float height = scanner.nextFloat();
        Box userBox = new Box(length, width, height) {
            @Override
            public boolean validate(float length, float width, float height) {
                return false;
            }
        };
        sizeSort = userBox.sizeSort;
    }
}
