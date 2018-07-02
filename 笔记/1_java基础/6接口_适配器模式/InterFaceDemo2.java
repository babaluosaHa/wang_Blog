class InterfaceDemo2 
{
	public static void main(String[] args) 
	{
		//创建usb设备
		Mp3 mp3=new Mp3();
		Fan fan=new Fan();
		Camera cam=new Camera();

		//创建Computer
		Computer com=new Computer();

		//传参 USB
		com.insert(mp3);
		com.insert(fan);
		com.insert(cam);
	}
}

interface USB
{
	public void play();
}

class Mp3 implements USB
{
	public void play(){
		System.out.println("啦啦啦啦,,,,")
	}
}

class Fan implements USB
{
	public void play(){
		System.out.println("好凉快呀！！");
	}
}

class Camera implements USB
{
	public void play(){
		System.out.println("咔嚓！！");
	}
}

class Computer
{
	public void insert(USB usb)
	{
		System.out.println("USB设备就绪！");
		usb.play();
	}
}