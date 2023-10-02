package com.rick;

public class Box5 extends Box{
    public Box5(float length, float width, float height) {
        super(length, width, height);
    }

    @Override
    public boolean validate(float length, float width, float height) {
        while (length <= sizeSort[0]){      //輸入的最大值要比Box5的最大值小或等於
            if (width <= sizeSort[1]){      //輸入的第二大值要比Box5的第二大值小或等於
                if (height <= sizeSort[2]){  //輸入的最小值要比Box5的最小值小或等於
                    return true;
                }else return false;
            }else return false;
        }
        return false;
    }
}
