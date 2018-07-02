class NoNameDemo 
{
	public static void main(String[] args) 
	{
		Pet pet=new Pet(){
			public void meng{
				System.out.println("ameng");
			}
			
			private void run{
				System.out.println("跑一圈！");
			}
		}; 
		pet.meng();
		//pet.run();	// 调不到
	}
}

abstract class Pet
{
	abstract public void meng();
}