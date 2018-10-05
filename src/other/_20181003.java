package other;

public class _20181003{
    public static void main(String[] args) {
        lanzi ss = new lanzi();
        shengchan p = new shengchan(ss);
        xiaofei b = new xiaofei(ss);
        new Thread(p).start();
        new Thread(b).start();
    }
}

class Mato{
    int id;
    Mato(int id) {
        this.id = id;
    }
    public String toSring() {
        return "Mato: "+id;
    }
}

class lanzi{
    int index = 0;
    Mato[] arrMt = new Mato[6];

    synchronized void push(Mato wt) {
        while(index == arrMt.length) {
            try{
                this.wait();
            }catch(InterruptedException a) {
                a.printStackTrace();
            }
        }
        this.notify();//叫醒等待该对象执行的其他线程
        arrMt[index]  = wt;
        index--;
    }

    synchronized  Mato pop(){
        while(index == 0) {
            try{
                this.wait();
            }catch(InterruptedException a) {
                a.printStackTrace();
            }
        }
        this.notify();
        index --;
        return arrMt[index];
    }
}

class shengchan implements Runnable{
    lanzi ss = null;
    shengchan(lanzi ss){
        this.ss = ss;
    }
    public void run() {
        for(int i=0;i<20;i++) {
            Mato a = new Mato(i);
            ss.push(a);
            System.out.println("生产了: "+a);
        }try {
            Thread.sleep(1000);
        }catch(InterruptedException a) {
            a.printStackTrace();
        }
    }
}

class xiaofei implements Runnable{
    lanzi ss = null;
    xiaofei(lanzi ss){
        this.ss = ss;
    }
    public void run() {
        for(int i=0;i<20;i++) {
            Mato a = ss.pop();
            System.out.println("消费了："+a);
        }try {
            Thread.sleep(1000);
        }catch(InterruptedException a) {
            a.printStackTrace();
        }
    }
}
