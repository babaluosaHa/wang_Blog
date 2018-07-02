class  ThreadDemo
{
	public static void main(String[] args) 
	{
		Saler s1=new Saler("S1");
		Saler s2=new Saler("S2");

		s1.start();
		s2.start();
	}
}

class Saler extends Thread
{
		static int tickets=100;
		static Object lock=new Object(); //重点是使用一把锁
		private String name;

		public Saler(String name){
			this.name=name;
		}

		public void run(){
			/*
			//--是原子性操作，没问题
			while(tickets>0){
				System.out.println(name+";"+tickets--);
			}
			*/

			/*并发执行，显示有重复
			while(tickets>0){
				int temp=tickets;
				System.out.println(name+":"+temp);
				tickets=tickets-1;
			}*/

			while(true){
				int t=getTickets();
				if(t<1){
					return;
				}
				else{
					System.out.println(name+":"+t);
				}
			}

		}

		//取票
		public int getTicket(){
			synchronized(lock) {
				int t=tickets;
				tickets=tickets-1;
				return t<1?-1:t;
			}
		}
}
