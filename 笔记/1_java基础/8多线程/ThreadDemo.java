class ThreadDemo 
{
	public static void main(String[] args) 
	{
		//�����̶߳���
		MyThread t1=new MyThread("Thread-1");
		MyThread t2=new MyThread("Thread-1");

		t1.start();	//ʹ��start�����߳�
		t2.start();
	}
}

Class MyThread extends Thread{
	private String name;
	public MyThread(String name){
		this.name=name;
	}
	//�߳��ڲ����д������run������
	public void run(){
		for(;;){
			System.out.println(name);
			//yield,������ǫ��
			Thread.yield();
		}
	}
}