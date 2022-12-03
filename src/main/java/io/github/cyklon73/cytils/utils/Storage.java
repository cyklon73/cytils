package io.github.cyklon73.cytils.utils;

public class Storage<t1, t2> {

    private t1 obj1;
    private t2 obj2;

    public Storage(t1 obj1, t2 obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public t1 getObj1() {
        return obj1;
    }

    public t2 getObj2() {
        return obj2;
    }

    public void setObj1(t1 obj) {
        this.obj1 = obj;
    }

    public void setObj2(t2 obj) {
        this.obj2 = obj;
    }
}

