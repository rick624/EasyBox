package com.rick;

public abstract class Box {
    float length;
    float width;
    float height;
    float[] sizeSort;

    public Box(float length, float width, float height) {
        this.length = length;
        this.width = width;
        this.height = height;
        sizeSort();
    }

    public abstract boolean validate(float length, float width, float height);

    public float[] sizeSort(){      //尺寸由大至小排序
        sizeSort = new float[] {length, width, height};
        for (int i=1; i<3; i++){
            for (int j=0; j<2; j++){
                if (sizeSort[j] < sizeSort[j+1]){
                    float temp = sizeSort[j];
                    sizeSort[j] = sizeSort[j+1];
                    sizeSort[j+1] = temp;
                }
            }
        }
        return sizeSort;
    }
}
