class ThreadDemo 
{
	public static void main(String[] args) 
	{
		//创建线程对象
		MyThread t1=new MyThread("Thread-1");
		MyThread t2=new MyThread("Thread-1");

		t1.start();	//使用start开启线程
		t2.start();
	}
}

Class MyThread extends Thread{
	private String name;
	public MyThread(String name){
		this.name=name;
	}
	//线程内部运行代码放在run函数里
	public void run(){
		for(;;){
			System.out.println(name);
			//yield,放弃，谦让
			Thread.yield();
		}
	}
}